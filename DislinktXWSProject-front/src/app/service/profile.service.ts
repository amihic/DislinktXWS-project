import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Profile } from '../model/profile';



@Injectable({
  providedIn: 'root'
})
export class ProfileService {
  url = "http://localhost:8090/api/follow";
  url1 = "http://localhost:8090/api/profileId";
  myId:any;
  constructor(private http:HttpClient) {
    this.myId= Number(sessionStorage.getItem('id'));
  }

  follow(username:String)
  {
    return this.http.put<Profile>(`${this.url}/` + `${username}` + `/${this.myId}`, username);
  }
  getProfileById():Observable<Profile>
  {
    return this.http.get<Profile>(`${this.url1}/${this.myId}`)
  }
  

}
