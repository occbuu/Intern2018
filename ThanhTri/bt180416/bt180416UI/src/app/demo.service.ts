import { Injectable } from '@angular/core';
import { Http } from '@angular/http';

const url = 'http://localhost:8080/';
@Injectable()
export class DemoService {

    constructor(private http: Http) { }

    create(vm: any) {
        return this.http.post(url + "create", vm);
    }
    save() {
        return this.http.get(url + "save");
    }
    read(vm: any) {
        return this.http.post(url + "read", vm);
    }
}
