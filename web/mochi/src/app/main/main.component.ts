import { Component, OnInit } from '@angular/core';
import {ConfigService} from '../service/config.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent {

  mochiIsIn = false;

  constructor(private configService: ConfigService) {
    this.mochiIsIn = configService.mochiIn;

  }

  getTitleStyle() {
    return this.mochiIsIn ? 'title in' : 'title';
  }

  getBackgroundStyle() {
    return this.mochiIsIn ? 'main in' : 'main';
  }

  getHeaderStyle() {
    return this.mochiIsIn ? 'header in' : 'header out';
  }

  statusText() {
    return this.mochiIsIn ? 'YEA :D' : 'NO :(';
  }
}
