import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HerosService } from './services/heros.service';
import { ExcelService } from './services/excel.service';
import { TablaComponent } from './components/tabla/tabla.component';
import { ProductsComponent } from './products/products.component';
import { FakeStoreApiService} from './services/fakeStoreApi.service';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TablaComponent, ProductsComponent],
templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  private readonly _apiFake = inject(FakeStoreApiService)
  constructor(
    private _herosService: HerosService,
    private _excelService: ExcelService
  ) { }
  download(): void {
    this._herosService.getHeros().subscribe((response) => {
      this._excelService.dowloadExcel(response);
    });
  }
  downloadApi(): void {
    this._apiFake.getAllProducts().subscribe((response:any) => {
      this._apiFake.downloadExcel(response);
    })
  }
}
