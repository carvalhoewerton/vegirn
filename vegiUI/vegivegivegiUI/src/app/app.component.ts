import { Component, Input } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { PlacesService } from '../services/places.service';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';

import { Place } from '../place';
import { PlaceComponent } from "../place/place.component";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  imports: [RouterOutlet, FormsModule, ReactiveFormsModule, PlaceComponent, CommonModule]
})
export class AppComponent {
  title = 'vegivegivegiUI';
  @Input() x!: number;
  @Input() y!: number;
  distance!: string;
  places!: Place[];
  @Input() pre!: number;

  constructor(private service: PlacesService) {}

  click() {
    if ('geolocation' in navigator) {
      navigator.geolocation.getCurrentPosition((position) => {
        this.x = position.coords.latitude;
        this.y = position.coords.longitude;

        this.fetchPlaces();
      });
    } else {
      console.error('Geolocalização não é suportada pelo navegador.');
    }
  }

  fetchPlaces() {
    this.service.getPlaces(this.x, this.y, this.pre).subscribe(
      (pl: Place[]) => {
        this.places = pl;
        console.log(this.places);
      },
      (error) => {
        console.error('Erro ao buscar lugares:', error);
      }
    );
  }
  formatDistance(distance: number | string): string {
    if (distance === '-') {
      return '-';
    } else {
      const numericDistance = typeof distance === 'string' ? parseFloat(distance) : distance;
      if (isNaN(numericDistance)) {
        return '-';
      } else {
        return numericDistance.toFixed(2) + " km";
      }
    }
  }


}
