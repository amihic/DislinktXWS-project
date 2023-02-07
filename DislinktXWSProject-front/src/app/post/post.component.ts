import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { User } from '../model/user';
import { PostService } from '../service/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {

  postToAdd:Post;
  
  constructor(private postService: PostService) { 
    this.postToAdd=new Post(
      {
        id: 0,
        owner: {
          id: 0,
          email: "",
          username: "",
          password:"",
          firstName:"",
          lastName: "",
          dateOfBirth: ""

        },
        text:"",
        userIdWhoLikes:[],
        userIdWhoDislikes:[],
        comments:[],
        picture:"",
        numberOfLikes:0
      });
  }

  ngOnInit(): void {
  }

  /*public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
  }*/

  addPost(postToAdd:Post){
    this.postService.addPost(postToAdd)
    .subscribe((res: Post) => postToAdd=res);
  }

}
