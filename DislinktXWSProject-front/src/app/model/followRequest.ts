interface FollowRequestInterface{
    id?:number;
    username:string;
    usernameWhichWantToFollow:string;
    followRequest:boolean;
}
export class FollowRequest implements FollowRequestInterface{
    id?: number ;
    username:string;
    usernameWhichWantToFollow:string;
    followRequest:boolean;

    constructor(obj:FollowRequestInterface){
        this.id=obj.id;
        this.username=obj.username;
        this.usernameWhichWantToFollow=obj.usernameWhichWantToFollow;
        this.followRequest=obj.followRequest;
    } 
}