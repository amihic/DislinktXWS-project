import { Component, EventEmitter, Injectable, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../model/user';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})


export class LoginComponent implements OnInit {

  newUser: User | undefined;
  username: any;
  password = '';
  invalidLogin = false;
  error:string='';
  idLoginUser:any;
  loggedUser: Boolean | undefined;

  @Output()
  LogIn: EventEmitter<void> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  login() {
    
  }

}
