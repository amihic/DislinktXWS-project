import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthenticatedUserDTO } from "../model/authenticatedUserDTO";

@Injectable({
    providedIn: 'root'
  })
  export class LoginService 
  {
    url = "http://localhost:8082/auth/login";
     
    constructor(private http:HttpClient) {}
  
    login(authenticatedUser:AuthenticatedUserDTO):Observable<AuthenticatedUserDTO>
    {
      return this.http.post<AuthenticatedUserDTO>(this.url,authenticatedUser);
    }
  
  }