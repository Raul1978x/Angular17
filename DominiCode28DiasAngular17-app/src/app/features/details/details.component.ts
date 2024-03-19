import { Component, Input, inject } from '@angular/core';
import { ActivatedRoute, Params, RouterLink } from '@angular/router';

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './details.component.html',
  styleUrl: './details.component.scss'
})
export class DetailsComponent {
@Input({alias:'id'}) productId!: string; //funciona todo igual con solo esta linea
  // public productId: string | null = '';
  // private route = inject(ActivatedRoute)

  // ngOnInit(): void {
  //  this.productId = this.route.snapshot.paramMap.get('id');// Este como el siguiente necesitan las lineas 13-14 para funcionar pero no actualizan el estado si lo ocupamos con el otro link (testing)
  // this.productId = this.route.snapshot.params?.['id']
  // this.route.params.subscribe((params: Params)=>this.productId = params['id'])//forma anterior con observable(funciona igual que con el imput pero con las lineas 13-14 activadas) 
  }
// }
