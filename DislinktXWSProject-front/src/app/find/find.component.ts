import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post';
import { User } from '../model/user';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent implements OnInit {

  users:User[];
  posts:Post[];
  user:User;
  userName:String;
  constructor(private userService: UserService) {
    this.users=[];
    this.posts=[];
    this.userName = "";
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
    this.userService.getPostsByUsername(this.userName)
    .subscribe((res: Post[]) => this.posts=res)
    this.userService.getByUsername(this.userName)
    .subscribe((res: User) => this.user=res)
    
  }

  seeProfile(){}
}
