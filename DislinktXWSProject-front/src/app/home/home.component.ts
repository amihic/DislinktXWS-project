import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  posts:Post[];
  constructor(private postService: PostService) {
    this.posts=[];
   }

  ngOnInit(): void {
    this.getAllPosts();
  }

  getAllPosts()
  {
    this.postService.getPosts()
    .subscribe(res => this.posts=res);
  }

}
