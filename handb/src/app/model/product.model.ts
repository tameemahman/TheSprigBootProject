export interface Product {
    id: number;
    name: string;
    category: Category;
    price: number;
    weight: number;
    description: string;
    imageName: string;
}

export interface Category {
  id: number;
name: any;
    // id: any;
    categoryId: number;
   
}
