import { inject, Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { IResponseHero } from '../models/api.interface';
import {
    IDataHeroExcel,
    IHeroDetail,
    IHeroTable,
} from './excel.service';

@Injectable({ providedIn: 'root' })
export class HerosService {
    private readonly _http = inject(HttpClient)
    private readonly _apiUrl = 'https://akabab.github.io/superhero-api/api/all.json'

    getHeros(): Observable<IDataHeroExcel> {
        return this._http
            .get<IResponseHero[]>(
                this._apiUrl
            )
            .pipe(
                map((response) => {
                    response.length = 10;
                    const dataExcel: IDataHeroExcel = {
                        herosTable: this._getHerosTable(response),
                        herosDetail: this._getHerosDetail(response),
                    };

                    return dataExcel;
                })
            );
    }

    private _getHerosTable(response: IResponseHero[]): IHeroTable[] {
        return response.map((item) => ({
            urlImage: item.images.md,
            fullName: item.biography.fullName,
            eyeColor: item.appearance.eyeColor,
            hairColor: item.appearance.hairColor,
            work: item.work.base,
        }));
    }

    private _getHerosDetail(response: IResponseHero[]): IHeroDetail[] {
        return response.map((item) => ({
            name: item.name,
            urlImage: item.images.md,
            powerstats: item.powerstats,
            appearance: {
                ...item.appearance,
                height: item.appearance.height[1],
                weight: item.appearance.weight[1],
            },
        }));
    }
}
