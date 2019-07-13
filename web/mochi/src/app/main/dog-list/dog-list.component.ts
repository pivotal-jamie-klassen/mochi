import { Component, OnInit } from '@angular/core';
import {Dog} from '../../model/dog';

@Component({
  selector: 'app-dog-list',
  templateUrl: './dog-list.component.html',
  styleUrls: ['./dog-list.component.scss']
})
export class DogListComponent implements OnInit {

  dogList = [];
  constructor() { }

  ngOnInit() {
    this.dogList.push({id: 1, name: 'Mochi', owner: 'Brenda'} as Dog);
    this.dogList.push({id: 2, name: 'Pixel', owner: 'Gab'} as Dog);
  }

}
