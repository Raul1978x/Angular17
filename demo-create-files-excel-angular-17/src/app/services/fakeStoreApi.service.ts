import { HttpClient } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class FakeStoreApiService {
    private readonly _http = inject(HttpClient);
    private readonly _apiFakeUrl = 'https://fakestoreapi.com/products'

    getAllProducts():Observable<any[]>{
        return this._http.get<any[]>(this._apiFakeUrl);
    }

}
