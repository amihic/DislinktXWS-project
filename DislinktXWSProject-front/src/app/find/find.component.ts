import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Post } from '../model/post';
import { Profile } from '../model/profile';
import { User } from '../model/user';
import { ProfileService } from '../service/profile.service';
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
  profile:Profile;
  
  constructor(private userService: UserService, private profileService: ProfileService) {
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
      this.profile = new Profile
      (
        {
          id: 0,
          user: {
            id: 0,
            email: "",
            username: "",
            password:"",
            firstName:"",
            lastName: "",
            dateOfBirth: ""
  
          },
          posts:[],
          followRequests:[],
          experience:[],
          education:[],
          interests:[],
          skills:[],
          privateProfile: false,
          followers:[],
          followings:[],

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

  followRequest(username:String){
    this.profileService.follow(username)
    .subscribe((res: Profile) => this.profile=res);
    
  }

}
