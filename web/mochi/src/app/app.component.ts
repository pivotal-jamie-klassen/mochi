import { Component } from '@angular/core';
import {ConfigService} from "./service/config.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'mochi';
  mochiIsIn = false;
  nextIn:string = null;

  constructor(private configService: ConfigService) {
    this.mochiIsIn = configService.mochiIn;
    this.nextIn = configService.nextIn;
  }

  getTitleStyle() {
    return this.mochiIsIn ? "title in" : "title";
  }

  getBackgroundStyle() {
    return this.mochiIsIn ? "main in" : "main";
  }

  getHeaderStyle() {
    return this.mochiIsIn ? "header in" : "header out";
  }

  statusText() {
    return this.mochiIsIn ? "YEA :D" : "NO :(";
  }
}
