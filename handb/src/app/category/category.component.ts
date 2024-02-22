import { Component, OnInit } from '@angular/core';
import { Category } from '../model/product.model';
import { CategoryService } from '../service/category.service';
// import { CategoryService } from './category.service'; // Import CategoryService
// import { Category } from './category.model'; // Import Category model

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {
  categories: Category[] = []; // Array to store category data

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.loadCategories(); // Call the method to load categories when the component initializes
  }

  loadCategories(): void {
    // Call the CategoryService method to fetch categories
    this.categoryService.getCategories().subscribe(
      (categories: Category[]) => {
        this.categories = categories; // Assign the fetched categories to the categories array
      },
      (error) => {
        console.error('Error fetching categories:', error); // Handle error if any
      }
    );
  }

  // You can add more methods here for interacting with the category data as needed
}
