import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/post';
import { User } from '../model/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  url="http://localhost:8090/api/userN";
  url1="http://localhost:8090/api/posts";
  
  myId:any;

  constructor(private http:HttpClient) {
    this.myId= Number(sessionStorage.getItem('id'));
   }

  save(newUser:User):Observable<User>{
    return this.http.post<User>(this.url,newUser);
  }

  findUserById(id:number):Observable<User>{
    return this.http.get<User>(`${this.url}/${id}`);
  }
  /*
  //Dobavljanje svih Usera
  getUsers():Observable<User[]>
  {
    return this.http.get<User[]>(this.url2);
  }
*/
  //Pronalazenje Korisnika Po Korisnickom Imenu
  getByUsername(userName:String)
  {
    return this.http.get<User>(`${this.url}/${userName}`);
  }

  getPostsByUsername(userName:String):Observable<Post[]>
  {
    return this.http.get<Post[]>(`${this.url1}/${userName}/${this.myId}`)
  }
/*
  UpdateUser(user:User):Observable<User>
  {
    return this.http.put<User>(this.url3,user);
  }*/

  //Lista korisnika po delu korisnickog imena
  /*searchByPartUsername(username:string):Observable<User[]>
  {
    return this.http.get<User[]>(`${this.url1}/${username}`)
  }*/


}
