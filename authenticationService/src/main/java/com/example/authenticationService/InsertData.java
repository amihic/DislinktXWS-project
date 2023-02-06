package com.example.authenticationService;

import com.example.authenticationService.model.Post;
import com.example.authenticationService.model.Profile;
import com.example.authenticationService.model.Role;
import com.example.authenticationService.model.User;
import com.example.authenticationService.service.PostService;
import com.example.authenticationService.service.ProfileService;
import com.example.authenticationService.service.RoleService;
import com.example.authenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InsertData {

    private final UserService userService;
    private final RoleService roleService;
    
    
    @Autowired
    private  ProfileService profileService;
    @Autowired
    private PostService postService;

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
        
        
        
        Post post1 = new Post((long) 1, u2, "pisem pisem", null, null, null, null, (long)  0,(long)  0);
        Post post2 = new Post((long) 2, u2, "napisan post", null, null, null, null, (long)  0,(long)  0);
        Post post3 = new Post((long) 3, u3, "lep post", null, null, null, null, (long)  0,(long)  0);
        Post post4 = new Post((long) 4, u3, "jedan post", null, null, null, null, (long)  0,(long)  0);
        Post post5 = new Post((long) 4, u3, "nesto", null, null, null, null, (long)  0,(long)  0);
        Post post6 = new Post((long) 4, u4, "nista", null, null, null, null, (long)  0,(long)  0);
        Post post7 = new Post((long) 4, u4, "svasta", null, null, null, null, (long)  0,(long)  0);
        Post post8 = new Post((long) 4, u4, "svasta nesto", null, null, null, null, (long)  0,(long)  0);
        
        postService.save(post1);
        postService.save(post2);
        postService.save(post3);
        postService.save(post4);
        postService.save(post5);
        postService.save(post6);
        postService.save(post7);
        
        
        Set<Post> posts1 = new HashSet<>();
        Set<Post> posts2 = new HashSet<>();
        Set<Post> posts3 = new HashSet<>();
        Set<Post> posts4 = new HashSet<>();
        
        posts1.add(post8);
        
        posts2.add(post1);
        posts2.add(post2);
        
        posts3.add(post3);
        posts3.add(post4);
        posts3.add(post5);
        
        posts4.add(post6);
        posts4.add(post7);
        
        
        Profile p1 = new Profile((long) 1, u1, posts1, null,null,null,null,false, null, null);
        Profile p2 = new Profile((long) 2, u2, posts2, null,null,null,null,false, null, null);
        Profile p3 = new Profile((long) 3, u3, posts3, null,null,null,null,false, null, null);
        Profile p4 = new Profile((long) 4, u4, posts4, null,null,null,null,false, null, null);
        
       /* profileService.save(p1);
        profileService.save(p2);
        profileService.save(p3);
        profileService.save(p4);*/
        
        Set<Profile> followers1 = new HashSet<>();
        Set<Profile> followers2 = new HashSet<>();
        Set<Profile> followers3 = new HashSet<>();
        Set<Profile> followers4 = new HashSet<>();
        
        followers1.add(p2);
        followers1.add(p3);
        followers1.add(p4);
        
        followers2.add(p3);
        followers2.add(p4);
        
        followers3.add(p1);
        followers3.add(p2);
        
        followers4.add(p2);
        followers4.add(p3);
        followers4.add(p1);
        
        Set<Profile> followings1 = new HashSet<>();
        Set<Profile> followings2 = new HashSet<>();
        Set<Profile> followings3 = new HashSet<>();
        Set<Profile> followings4 = new HashSet<>();
        
        followings1.add(p3);
        followings1.add(p4);
        
        followings2.add(p1);
        followings2.add(p3);
        followings2.add(p4);
        
        followings3.add(p1);
        followings3.add(p2);
        followings3.add(p4);
        
        followings4.add(p1);
        followings4.add(p2);
        
        /*p1.setFollowers(followers1);
        p2.setFollowers(followers2);
        p3.setFollowers(followers3);
        p4.setFollowers(followers4);
        
        p1.setFollowings(followings1);
        p2.setFollowings(followings2);
        p3.setFollowings(followings3);
        p4.setFollowings(followings4);*/
        
        Profile pp1 = new Profile((long) 1, u1, posts1, null,null,null,null,true, followers1, followings1);
        Profile pp2 = new Profile((long) 2, u2, posts2, null,null,null,null,false, followers2, followings2);
        Profile pp3 = new Profile((long) 3, u3, posts3, null,null,null,null,true, followers3, followings3);
        Profile pp4 = new Profile((long) 4, u4, posts4, null,null,null,null,false, followers4, followings4);
     
        profileService.save(pp1);
        profileService.save(pp2);
        profileService.save(pp3);
        profileService.save(pp4);
        
    }
}