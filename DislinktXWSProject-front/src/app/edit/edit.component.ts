import { Component, OnInit } from '@angular/core';
import { Profile } from '../model/profile';
import { ProfileService } from '../service/profile.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
profile:Profile;
  constructor(private profileService: ProfileService) {
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
          experiences:"",
          education:"",
          interests:"",
          skills:"",
          privateProfile: false,
          followers:[],
          followings:[],

        }
      );
   }

  ngOnInit(): void {
  }


  update(profile:Profile)
  {
    this.profileService.update(profile)
    .subscribe((res: Profile) => profile=res);
  }
}
