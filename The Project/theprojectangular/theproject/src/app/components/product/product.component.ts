import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Product } from '../../model/product.model';
import { ProductService } from '../../service/product.service';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent implements OnInit{

  productForm!: FormGroup;
  products!: Product[];
  categories: any[] = []; 


  constructor(
    private formBuilder: FormBuilder,
    private productService: ProductService,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.productForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: [''],
      price: ['', Validators.required],
      quantityAvailable: ['', Validators.required],
      imageURL: [''],
      category: ['']
    });

    this.loadProducts();
    this.loadCategories(); 
  }

  loadProducts(): void {
    this.productService.getAllProducts()
      .subscribe(products => this.products = products);
  }

  loadCategories(): void {
    this.categoryService.getAllCategories()
      .subscribe(categories => this.categories = categories);
  }

  onSubmit(): void {
    if (this.productForm.invalid) {
      return;
    }

    const product: Product = {
      name: this.productForm.value.name,
      description: this.productForm.value.description,
      price: this.productForm.value.price,
      quantityAvailable: this.productForm.value.quantityAvailable,
      imageURL: this.productForm.value.imageURL,
      category: this.productForm.value.category
    };

    this.productService.createProduct(product)
      .subscribe(() => {
        this.loadProducts();
        this.productForm.reset();
      });
  }

  deleteProduct(id: number | undefined): void {
    if (id === undefined) {
      return;
    }

    this.productService.deleteProduct(id)
      .subscribe(() => this.loadProducts());
  }




}
