import {HttpClient} from '@angular/common/http';
import {Inject, Injectable, Injector} from '@angular/core';

import {ConfigService} from "./config.service";
import {MOCHI_API} from "../mochi-api/mochi-api";

export interface MochiConfig {
    mochiIn: boolean;
}

@Injectable()
export class StartupService {

    constructor(@Inject(MOCHI_API) private http: HttpClient, private injector: Injector) {
    }


    configure(): Promise<any> {

        const configService = this.injector.get(ConfigService);

        const promise = this.http.get<MochiConfig>('/api/config')
        .toPromise()
        .then(data => {
          console.log(data);
            configService.mochiIn = data.mochiIn;
            return data;
        });

        return promise;
    }
}
