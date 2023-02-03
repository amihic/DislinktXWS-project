interface AuthenticatedUserDTOInterface{
    email:string;
    password:string;
}
export class AuthenticatedUserDTO implements AuthenticatedUserDTOInterface{
    email:string;
    password:string;

    constructor(obj:AuthenticatedUserDTOInterface){
        this.email=obj.email;
        this.password=obj.password;
    } 
}