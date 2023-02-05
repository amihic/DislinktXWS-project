import { Post } from "./post";
import { User } from "./user";

interface ProfileInterface{
    id?:number;
    user: User;
    experience:string[];
    education:string[];
    interests:string[];
    skills:string[];
    privateProfile: boolean;
    followers:User[];
    
}
export class Profile implements ProfileInterface{
    id?:number;
    user: User;
    experience:string[];
    education:string[];
    interests:string[];
    skills:string[];
    privateProfile: boolean;
    followers:User[];
   
    constructor(obj:ProfileInterface){
        this.id=obj.id;
        this.user=obj.user;
        this.experience=obj.experience;
        this.education=obj.education;
        this.interests=obj.interests;
        this.skills=obj.skills;
        this.privateProfile=obj.privateProfile;
        this.followers=obj.followers;
        
    } 
}