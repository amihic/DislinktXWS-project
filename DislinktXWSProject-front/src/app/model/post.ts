import { Comment } from "./comment";
import { User } from "./user";

interface PostInterface{
    id?:number;
    owner:User;
    text:string;
    userIdWhoLikes:number[];
    userIdWhoDislikes:number[];
    comments:Comment[];
    picture?:string;
    numberOfLikes:number;
    //numberOfDislikes:number;
}
export class Post implements PostInterface{
    id?:number;
    owner:User;
    text:string;
    userIdWhoLikes:number[];
    userIdWhoDislikes:number[];
    comments:Comment[];
    picture?:string;
    numberOfLikes:number;
    //numberOfDislikes:number;

    constructor(obj:PostInterface){
        this.id=obj.id;
        this.owner=obj.owner;
        this.text=obj.text;
        this.userIdWhoLikes=obj.userIdWhoLikes;
        this.userIdWhoDislikes=obj.userIdWhoDislikes;
        this.comments=obj.comments;
        this.picture = obj.picture;
        this.numberOfLikes = obj.numberOfLikes;
        //this.numberOfDislikes = obj.numberOfDislikes;
    } 
}