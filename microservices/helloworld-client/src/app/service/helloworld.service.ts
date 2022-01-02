import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HelloMessage} from "../component/helloworld/message";
import {helloworldEndpoint} from "./endpoints";

@Injectable({
  providedIn: 'root'
})
export class HelloworldService {

  constructor(private http: HttpClient) { }

  sayHello(name: string | undefined): Observable<HelloMessage> {
    //return this.http.get<HelloMessage>('assets/data/hello-message.json')
    return this.http.get<HelloMessage>(helloworldEndpoint(name))
  }
}
