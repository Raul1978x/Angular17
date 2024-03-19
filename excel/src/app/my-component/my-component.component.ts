import { Component } from '@angular/core';
import { ExcelService } from './../service/excel.service';
@Component({
  selector: 'app-my-component',
  standalone: true,
  imports: [],
templateUrl: './my-component.component.html',
  styleUrl: './my-component.component.scss'
})
export class MyComponentComponent {
  constructor(private excelService: ExcelService) {}

  descargarExcel() {
    this.excelService.generateExcelFile();
  }
}
