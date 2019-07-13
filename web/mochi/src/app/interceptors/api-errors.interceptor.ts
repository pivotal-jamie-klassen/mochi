import {catchError} from 'rxjs/operators';
import {Injectable} from "@angular/core";
import {HttpEvent, HttpHandler, HttpInterceptor, HttpRequest, HttpErrorResponse} from "@angular/common/http";
import {EMPTY, Observable} from "rxjs";
import {ApiEventsService} from "../service/api-events.service";



@Injectable()
export class ApiErrorsInterceptor implements HttpInterceptor {
  constructor(private apiEventsService: ApiEventsService) {
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next
    .handle(request).pipe(
        catchError((err: HttpErrorResponse) => {
          if (this.shouldHandleServerError(err)) {
            return this.apiEventsService.processError(err);
          }
          return EMPTY;
        }));
  }

  shouldHandleServerError(err: HttpErrorResponse): boolean {
    if (err.status == 404) {
      if (err.url.endsWith("latest-status-note")) {
        return false;
      }
    }
    return true;
  }
}
