// import { Injectable } from '@angular/core';
// import { Workbook } from 'exceljs';
// import * as FileSaver from 'file-saver';


// @Injectable({ providedIn: 'root' })
// export class ExcelService {
//   private _workbook!: Workbook;

  // async dowloadExcel(dataExcel: any): Promise<void> {
  //   this._workbook = new Workbook();

  //   this._workbook.creator = 'DigiDev';

  //   // await this._createHeroTable(dataExcel.herosTable);
  //   // await this._createHeroDetail(dataExcel.herosDetail);

  //   this._workbook.xlsx.writeBuffer().then((data) => {
  //     const blob = new Blob([data]);
  //     fs.saveAs(blob, 'HEROS.xlsx');
  //   });
  // }

}
import { Injectable } from '@angular/core';
import * as FileSaver from 'file-saver';
import { Workbook } from 'exceljs';

@Injectable({
  providedIn: 'root'
})
export class ExcelService {

  constructor() {}

  async generateExcelFile(data: any[]): Promise<void> {
    const workbook = new Workbook();
    const worksheet = workbook.addWorksheet('Hoja1');

    // Escribir los datos en la hoja
    worksheet.addRows(data);

    // Aplicar formatos (opcional)
    worksheet.getColumn(1).width = 15;
    // ...

    const datos:Buffer = await workbook.xlsx.writeBuffer();
    const filename = 'my-file.xlsx';

    FileSaver.saveAs(datos, filename);
  }
}
