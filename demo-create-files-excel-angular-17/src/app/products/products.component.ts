import { Component, inject } from '@angular/core';
import { FakeStoreApiService } from '../services/fakeStoreApi.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './products.component.html',
  styleUrl: './products.component.css'
})
export class ProductsComponent {
private readonly ProductsSvc = inject(FakeStoreApiService);
products$ = this.ProductsSvc.getProducts();

}
