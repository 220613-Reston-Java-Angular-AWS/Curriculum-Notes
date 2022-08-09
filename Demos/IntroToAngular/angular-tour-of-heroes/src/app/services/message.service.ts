import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  messages: string[] = [];

  // this method will be called when we want to add a new message to our array
  add(message: string){
    this.messages.push(message);
  }

  // this method will be called when we want to clear out our messages array
  clear(){
    this.messages = [];
  }
  
  constructor() { }
}
