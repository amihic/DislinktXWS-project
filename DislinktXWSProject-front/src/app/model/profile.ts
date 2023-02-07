import { FollowRequest } from "./followRequest";
import { Post } from "./post";
import { User } from "./user";

interface ProfileInterface{
    id?:number;
    user: User;
    posts:Post[];
    followRequests:FollowRequest[];
    experience:string[];
    education:string[];
    interests:string[];
    skills:string[];
    privateProfile: boolean;
    followers:Profile[];
    followings:Profile[];
    
}
export class Profile implements ProfileInterface{
    id?:number;
    user: User;
    posts:Post[];
    followRequests:FollowRequest[];
    experience:string[];
    education:string[];
    interests:string[];
    skills:string[];
    privateProfile: boolean;
    followers:Profile[];
    followings:Profile[];
   
    constructor(obj:ProfileInterface){
        this.id=obj.id;
        this.user=obj.user;
        this.posts=obj.posts;
        this.followRequests=obj.followRequests;
        this.experience=obj.experience;
        this.education=obj.education;
        this.interests=obj.interests;
        this.skills=obj.skills;
        this.privateProfile=obj.privateProfile;
        this.followers=obj.followers;
        this.followings=obj.followings;
        
    } 
}