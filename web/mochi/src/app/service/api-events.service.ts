import {Subject, throwError as observableThrowError} from 'rxjs';
import {Injectable} from '@angular/core';
import {HttpErrorResponse} from "@angular/common/http/src/response";


type ApiRequestContext = { accountId: number };


@Injectable()
export class ApiEventsService {

  private authenticationNeededSrc = new Subject<any>();
  authenticationNeeded = this.authenticationNeededSrc.asObservable();

  private accessDeniedSrc = new Subject<ApiRequestContext>();
  accessDenied = this.accessDeniedSrc.asObservable();

  private serverErrorSrc = new Subject<any>();
  serverErrors = this.serverErrorSrc.asObservable();

  private noPermissionsErrorSrc = new Subject<any>();
  noPermissionsError = this.noPermissionsErrorSrc.asObservable();

  processError(err: HttpErrorResponse) {
    if (console && console.error) {
      console.error("api error", err);
    }

    if (err.status === 401) {
      this.authenticationNeededSrc.next();
      return observableThrowError("Authentication required");
    } else if (err.status === 403) {
      let context = this.examineContext(err);
      this.accessDeniedSrc.next(context);
      return observableThrowError("Authorization failure");
    } else if (err.status === 409) {
      this.noPermissionsErrorSrc.next();
      return observableThrowError("User permissions not synced");
    } else if(err.status === 422){
      if (err.url.endsWith("team-members")) {
        return observableThrowError("Team member not found");
      }
    } else {
      this.serverErrorSrc.next(err);
      return observableThrowError("Server error");
    }
  }


  private examineContext(err): ApiRequestContext {
    if (err && err.url) {
      const m = /\/api\/accounts\/(\d+).*/.exec(err.url);
      if (m) {
        return {accountId: Number.parseInt(m[1])};
      }
    }
    return {accountId: null};
  }
}
