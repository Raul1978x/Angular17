
import { CurrencyPipe } from '@angular/common';
import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-card',
  standalone: true,
  imports: [RouterLink,CurrencyPipe],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss'
})
export class CardComponent {
  @Input({ required: true, transform: addDiscountProperty }) product!: any;

}

function addDiscountProperty(product: any) {
  return { discount: false, ...product };
}