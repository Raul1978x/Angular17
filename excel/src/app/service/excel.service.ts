import { Injectable } from '@angular/core';
import FileSaver, {  saveAs } from 'file-saver'; // Import specific function
import { Workbook } from 'exceljs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ExcelService {

  constructor(private http: HttpClient) {}

  async generateExcelFile(): Promise<void> {
    const products:any = await this.http.get('https://fakestoreapi.com/products').toPromise();
    const workbook = new Workbook();
    const worksheet = workbook.addWorksheet('Productos');

    // Escribir los encabezados
    worksheet.columns = [
      { header: 'ID', key: 'id', width: 10 },
      { header: 'Título', key: 'title', width: 30 },
      { header: 'Precio', key: 'price', width: 15 },
      { header: 'Descripción', key: 'description', width: 50 },
    ];

    // Agregar los datos
    worksheet.addRows(products);

    // Aplicar formatos (opcional)
    worksheet.getRow(1).font = { bold: true };
    // ...

    const data:any = await workbook.xlsx.writeBuffer();
    const filename = 'productos.xlsx';
    
    const excelData = await workbook.xlsx.writeBuffer();
const blob = new Blob([excelData], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet' }); // Crea el Blob


    FileSaver.saveAs(data as Blob, filename);  // Define data como Blob
  }
}
