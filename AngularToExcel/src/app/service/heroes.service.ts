import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Observable } from 'rxjs';
import { Hero } from '../interfaces/hero.interface';

@Injectable({
  providedIn: 'root'
})
export class HeroesService {
  private readonly _http = inject(HttpClient)
  private readonly _apiUrl = "https://akabab.github.io/superhero-api/api/all.json"
  getHeroes(): Observable<Hero[]> {
    return this._http.get<Hero[]>(this._apiUrl);
  }
}

