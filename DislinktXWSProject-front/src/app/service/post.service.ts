import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/post';


@Injectable({
  providedIn: 'root'
})
export class PostService {
  url="http://localhost:8090/api/postsFromUserHeFollows";

  constructor(private http:HttpClient) {}

  getPosts(id:Number):Observable<Post[]>{
    return this.http.get<Post[]>(`${this.url}/${id}`);
  }
  
  /*save(newPost:Post):Observable<Post>{
    return this.http.post<Post>(this.url,newPost);
  }
  findPostById(id:number):Observable<Post>{
    return this.http.get<Post>(`${this.url}/${id}`);
  }*/

  /*likePost(post:Post):Observable<Post>{
    return this.http.post<Post>(this.url+"/likePost",post);
  }*/

  checkIfPostIsDisliked(post:Post):Observable<number[]>{
    return this.http.post<number[]>(this.url+"/checkPost",post);
  } 

  findAllPostsFromProfilesYouFollow(idProfile:number):Observable<Post[]>
   {
    const params:HttpParams=new HttpParams().append('idProfile',idProfile);
    return this.http.get<Post[]>(this.url+"/profilesYouFollow",{params});
      
   }

}
