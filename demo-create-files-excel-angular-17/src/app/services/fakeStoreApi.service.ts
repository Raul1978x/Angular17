import { Injectable, inject } from "@angular/core";
import { Workbook, Worksheet } from "exceljs";
import { HttpClient } from "@angular/common/http";
import { catchError, Observable, of } from 'rxjs';
import { IDataProductExcel, IProduct, IProductTable } from "../models/fakeStore.interface";
import FileSaver from "file-saver";

@Injectable({ providedIn: 'root' })
export class FakeStoreApiService {
    private readonly _http = inject(HttpClient);
    private readonly _apiFakeUrl = 'https://fakestoreapi.com/products'
    private _workook!: Workbook;

    async downloadExcel(dataExcel: IDataProductExcel): Promise<void> {
        this._workook = new Workbook();

        this._workook.creator = 'Raúl Gómez'

        await this._createProductTable(dataExcel.productTable);
        this._workook.xlsx.writeBuffer().then((data) => {
            const blob = new Blob([data]);
            console.log(data)
            FileSaver.saveAs(blob, 'Facturacion.xlsx')
        })
    }

    // private _aplyStyleDataSection(
    //     sheet: Worksheet,
    //     dataSection: IDataSection[]
    // ){

    // }

    private async _createProductTable(productsItems: IProductTable[]): Promise<void> {
        const sheet = this._workook.addWorksheet('Productos')

        sheet.getColumn('A').width = 21;
        sheet.getColumn('B').width = 21;
        sheet.getColumn('C').width = 38;
        sheet.getColumn('D').width = 20;
        sheet.getColumn('E').width = 29;

        sheet.columns.forEach((column) => {
            column.alignment = { vertical: 'middle', wrapText: true };
        });

        const titleCell = sheet.getCell('C5');
        titleCell.value = 'Productos';
        titleCell.style.font = { bold: true, size: 24 };

        const headerRow = sheet.getRow(10);

        headerRow.values = [
            'id',
            'image',
            'title',
            'description',
            'price'
        ];
        headerRow.font = { bold: true, size: 12 };

        const rowsToInsert = sheet.getRows(11, productsItems?.length)!;
        for (let index = 0; index < rowsToInsert.length; index++) {
            const itemData = productsItems[index];
            const row = rowsToInsert[index];

            row.values = [
                '',
                itemData.id,
                itemData.urlImage,
                itemData.title,
                itemData.description,
                itemData.price
            ];
            const idImage = await this._getIdImage(itemData.urlImage);
            sheet.addImage(idImage, {
                tl: { col: 1, row: row.number - 1 },
                ext: { width: 109, height: 110 },
            });
            row.height = 92;

        }
    };


    private async _getIdImage(url: string): Promise<number> {
        const response = await fetch(url);
        const image = this._workook.addImage({
            buffer: await response.arrayBuffer(),
            extension: 'jpeg',
        });
        return image;
    }

    getProducts(): Observable<any[]> {
        return this._http.get<IDataProductExcel[]>(this._apiFakeUrl);
    }

    getAllProducts(): Observable<IDataProductExcel[]> {
        return this._http.get<IDataProductExcel[]>(this._apiFakeUrl)
            .pipe(
                catchError(error => {
                    console.error('Error fetching products:', error);
                    return of([]); // Return an empty observable on error
                })
            );
    }


}

export { IProductTable, IDataProductExcel }