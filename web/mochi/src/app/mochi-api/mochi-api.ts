import {InjectionToken} from '@angular/core';
import {HttpClient} from "@angular/common/http";

export const MOCHI_API = new InjectionToken<HttpClient>("mochi.api.client");
