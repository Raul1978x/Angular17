import { Component, inject } from '@angular/core';
import { HerosService } from '../../services/heros.service';
import { AsyncPipe, JsonPipe } from '@angular/common';

@Component({
  selector: 'app-tabla',
  standalone: true,
  imports: [AsyncPipe, JsonPipe],
  templateUrl: './tabla.component.html',
  styleUrl: './tabla.component.css'
})
export class TablaComponent {
private readonly heroSvc = inject(HerosService);
heroes$ = this.heroSvc.getHeros();
}
