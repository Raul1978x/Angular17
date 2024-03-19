import { Component, inject } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HeroesService } from './service/heroes.service';
import { CommonModule } from '@angular/common';
import { ExcelService } from './service/excel.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  private readonly HeroesSvc = inject(HeroesService);
  private readonly ExcelSvc = inject(ExcelService);
  hero = this.HeroesSvc.getHeroes();

  download(): void {
    this.HeroesSvc.getHeroes().subscribe((response) => {
      this.ExcelSvc.downloadExcel(response);
    });

  }
}
