import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Category } from '../../model/category.model';
import { CategoryService } from '../../service/category.service';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent implements OnInit{

  categoryForm!: FormGroup ;
  categories!: Category[] ;

  constructor(
    private formBuilder: FormBuilder,
    private categoryService: CategoryService
  ) { }

  ngOnInit(): void {
    this.categoryForm = this.formBuilder.group({
      name: ['', Validators.required]
    });

    this.loadCategories();
  }

  loadCategories(): void {
    this.categoryService.getAllCategories()
      .subscribe(categories => this.categories = categories);
  }

  onSubmit(): void {
    if (this.categoryForm.invalid) {
      return;
    }

    const category: Category = {
      name: this.categoryForm.value.name
    };

    this.categoryService.createCategory(category)
      .subscribe(() => {
        this.loadCategories();
        this.categoryForm.reset();
      });
  }

  deleteCategory(id: number | undefined): void {
    if (id === undefined) {
      return;
    }

    this.categoryService.deleteCategory(id)
      .subscribe(() => this.loadCategories());
  }

}
