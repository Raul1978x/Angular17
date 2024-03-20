export interface IDataProductExcel {
  productTable: IProductTable[];
  productsItems: IProduct[];
}
export interface IProduct {
  id: number;
  title: string;
  price: string;
  category: string;
  description: string;
  image: string;
}

export interface IProductTable {
  id: number;
  urlImage: string;
  title: string;
  description: string;
  price: string;
}