package com.example.authenticationService;

import com.example.authenticationService.model.Role;
import com.example.authenticationService.model.User;
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

        Role r1 = new Role((long) 0, "ADMIN");
        Role r2 = new Role((long) 1, "USER");
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
    }
}