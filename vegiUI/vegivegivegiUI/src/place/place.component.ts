import { Component,Input } from '@angular/core';

@Component({
  selector: 'app-place',
  standalone: true,
  imports: [],
  templateUrl: './place.component.html',
  styleUrl: './place.component.css'
})
export class PlaceComponent {
  @Input() distance!:string;
  @Input() name!: string;
  @Input() link!: string;
  @Input() tripAdvisor!: string;
  @Input() address!: string;
  @Input() description!:string;
  @Input() img!:string;
}
