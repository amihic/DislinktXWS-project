import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService 
{
  //url="http://localhost:8080/api/registration";
  url="http://localhost:8082/auth/signup";
  url1 = "http://localhost:8082/api/users";


  constructor(private http:HttpClient) {}
   
  getUsers():Observable<User[]>
  {
    return this.http.get<User[]>(this.url1);
  }
  
  registration(newUser:User):Observable<User>
  {
    return this.http.post<User>(this.url,newUser);
  }



}