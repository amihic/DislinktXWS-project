import { identifierName } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { AnyCatcher } from 'rxjs/internal/AnyCatcher';
import { Post } from '../model/post';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  id:any;
  myId:any;
  posts:Post[];
  constructor(private postService: PostService) {
    this.posts=[];
    this.myId = 0;
    this.id = 0;
   }

  ngOnInit(): void {
    this.getAllPosts();
    
  }

  getAllPosts()
  {
    this.myId = Number(sessionStorage.getItem('id'));
    this.id = this.myId;
    this.postService.getPosts(this.id)
    .subscribe(res => this.posts=res);
    console.log("Ulogovani user: "+this.myId);
  }

}
