import { Category } from "./category.model";

export class Product {
    id?: number;
    name?: string;
    description?: string;
    price?: number;
    quantityAvailable?: number;
    imageURL?: string;
    category?: Category;
  }