import { Component, OnInit, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProductsService } from '../../api/products.service';
import { AsyncPipe, } from '@angular/common';
import { CardComponent } from './card/card.component';

@Component({
    selector: 'app-products',
    standalone: true,
    templateUrl: './products.component.html',
    styleUrl: './products.component.scss',
    imports: [RouterLink, AsyncPipe, CardComponent]
})
export class ProductsComponent implements OnInit {
    productSvc = inject(ProductsService);
    products$ = this.productSvc.getAllProducts();
    ngOnInit(): void {
        throw new Error('Method not implemented.');
    }
}
