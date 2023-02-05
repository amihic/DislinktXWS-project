package com.example.authenticationService;

import com.example.authenticationService.model.Profile;
import com.example.authenticationService.model.Role;
import com.example.authenticationService.model.User;
import com.example.authenticationService.service.ProfileService;
import com.example.authenticationService.service.RoleService;
import com.example.authenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InsertData {

    private final UserService userService;
    private final RoleService roleService;
    
    @Autowired
    private  ProfileService profileService;

    @Autowired
    public InsertData(RoleService roleService, UserService userService) {
        this.userService = userService;
        this.roleService = roleService;
    }


    @PostConstruct
    public void init() {
        List<Role> role1 = new ArrayList<>();
        List<Role> role2 = new ArrayList<>();
        List<Role> role3 = new ArrayList<>();
        //List<Role> role4 = new ArrayList<>();

        Role r1 = new Role((long) 0, "ROLE_ADMIN");
        Role r2 = new Role((long) 1, "ROLE_USER");
        //Role r3 = new Role((long) 2, "ROLE_UNREG");
        roleService.save(r1);
        roleService.save(r2);
        //roleService.save(r3);
        role1.add(r1);
        role2.add(r2);
        role3.add(r1);
        //role4.add(r1);
        User u1 = new User((long) 1, "pera", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "Pera", "Peric", "perap@gmail.com", "20.08.1999",  true, role1, "User");
        User u2 = new User((long) 2, "jova", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "Jova", "Jovic", "jovica@gmail.com", "20.08.1999", true, role2, "User");
        User u3 = new User((long) 3, "steva", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "Stevan", "Stefanovic", "steva@gmail.com", "20.08.1999",  true, role3, "User");
        User u4 = new User((long) 4, "mile", "$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra", "Mile", "Milic", "mile@gmail.com", "20.08.1999",  true, role3, "User");

        userService.saveUser(u1);
        userService.saveUser(u2);
        userService.saveUser(u3);
        userService.saveUser(u4);
        
        List<User> users1 = new ArrayList<User>();
        List<User> users2 = new ArrayList<>();
        List<User> users3 = new ArrayList<>();
        List<User> users4 = new ArrayList<>();
        
        users1.add(u2);
        users1.add(u3);
        users1.add(u4);
        
        users2.add(u3);
        users2.add(u4);
        
        users3.add(u1);
        users3.add(u2);
        
        users4.add(u2);
        users4.add(u3);
        users4.add(u1);
        
        Profile p1 = new Profile((long) 1, u1, null,null,null,null,false, users1);
        Profile p2 = new Profile((long) 2, u2, null,null,null,null,false, users2);
        Profile p3 = new Profile((long) 3, u3, null,null,null,null,false, users3);
        Profile p4 = new Profile((long) 4, u4, null,null,null,null,false, users4);
        
        profileService.save(p1);
        profileService.save(p2);
        profileService.save(p3);
        profileService.save(p4);
    }
}