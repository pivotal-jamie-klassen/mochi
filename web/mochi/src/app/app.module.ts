import { BrowserModule } from '@angular/platform-browser';
import {APP_INITIALIZER, NgModule} from '@angular/core';

import { AppComponent } from './app.component';
import {StartupService} from "./service/startup.service";
import {MOCHI_API} from "./mochi-api/mochi-api";
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from "@angular/common/http";
import {ApiErrorsInterceptor} from "./interceptors/api-errors.interceptor";
import {ApiEventsService} from "./service/api-events.service";
import {ConfigService} from "./service/config.service";

export function startupServiceFactory(startupService: StartupService): Function {
  return () => startupService.configure();
}

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    ConfigService,
    {provide: MOCHI_API, useClass: HttpClient},
    {provide: HTTP_INTERCEPTORS, useClass: ApiErrorsInterceptor, multi: true},
    ApiEventsService,
    StartupService,
    {
      provide: APP_INITIALIZER,
      useFactory: startupServiceFactory,
      deps: [StartupService],
      multi: true
    },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
