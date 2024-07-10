import { HttpClient, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Place } from '../place';
@Injectable({
  providedIn: 'root'
})
export class PlacesService {
  url:string = 'http://localhost:8080/place/all'
  constructor(private http:HttpClient){}

  getPlaces(x: number, y: number, radius: number): Observable<Place[]> {
    const params = `x=${x}&y=${y}&radius=${radius}`;
    const url = `${this.url}?${params}`;
    return this.http.get<Place[]>(url);
  }
}
