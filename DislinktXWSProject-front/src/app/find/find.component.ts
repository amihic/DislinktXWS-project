import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { Profile } from '../model/profile';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {

  followedUsername:String;
  myId:any;
  users:User[];
  posts:Post[];
  user:User;
  userName:String;
  constructor(private userService: UserService) {
    this.users=[];
    this.posts=[];
    this.userName = "";
    this.myId = 0;
    this.followedUsername = "";
    this.user = new User
      (
        {
          id: 0,
          email: "",
          username: "",
          password:"",
          firstName:"",
          lastName: "",
          dateOfBirth: ""

        }
      );
   }

  ngOnInit(): void {
  }

  getProfileByUsername(){
    this.myId = Number(sessionStorage.getItem('id'));
    this.userService.getPostsByUsername(this.userName)
    .subscribe((res: Post[]) => this.posts=res)
    this.userService.getByUsername(this.userName)
    .subscribe((res: User) => this.user=res);

    this.followedUsername = this.userName;
    

    console.log("Pokupljeni user: " + this.followedUsername);
    console.log("Ulogovani user: " + this.myId);
    
    
  }
/*
  .subscribe((res: User) => {this.user=res;
    this.followedUsername = this.userName});
    console.log(this.followedUsername);
    console.log("aaaa");
*/
  followRequest(){
   
  }

  seeProfile(){}
}
