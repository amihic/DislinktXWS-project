import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../model/profile';



@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  url="http://localhost:8090/api/follow";
  myId:any;
  constructor(private http:HttpClient) {
    this.myId= Number(sessionStorage.getItem('id'));
  }

  follow(username:String)
    {
        return this.http.put<Profile>(`${this.url}/` + `${username}` + `/${this.myId}`, username);
    }
  
  

}
