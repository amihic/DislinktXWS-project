import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Post } from '../model/post';
import { Profile } from '../model/profile';
import { User } from '../model/user';
import { ProfileService } from '../service/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
 
  id:Number;
  profile:Profile;

  constructor(private router: Router, private route: ActivatedRoute,private profileService: ProfileService) {
    this.id=0;
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

  ngOnInit(): void 
  {
    this.loadPost();
  }
  loadPost(){
    this.profileService.getProfileById()
    .subscribe(res=>this.profile=res)
  }
}
