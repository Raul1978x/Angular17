import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HerosService } from './services/heros.service';
import { ExcelService } from './services/excel.service';
import { TablaComponent } from './components/tabla/tabla.component';
import { ProductsComponent } from './products/products.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,TablaComponent, ProductsComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  constructor(
    private _herosService: HerosService,
    private _excelService: ExcelService
  ) {}
  download(): void {
    this._herosService.getHeros().subscribe((response) => {
      this._excelService.dowloadExcel(response);
    });
  }
}