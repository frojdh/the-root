import { Component, OnInit } from '@angular/core';
import {HelloworldService} from "../../service/helloworld.service";
import {HelloMessage} from "./message";

@Component({
  selector: 'app-helloworld',
  templateUrl: './helloworld.component.html',
  styleUrls: ['./helloworld.component.css']
})
export class HelloworldComponent implements OnInit {
  name: string | undefined
  receivedMessage: string | undefined

  constructor(private helloworldService: HelloworldService) { }

  ngOnInit(): void {
  }

  sayHello() {
    this.helloworldService.sayHello(this.name).subscribe(
      (helloMessage: HelloMessage) => { this.receivedMessage = helloMessage.message},
      error => {
        this.receivedMessage = undefined
        console.error(error)
      })
  }

  receivedMessageExist(): boolean {
    return this.receivedMessage ? true : false
  }
}
