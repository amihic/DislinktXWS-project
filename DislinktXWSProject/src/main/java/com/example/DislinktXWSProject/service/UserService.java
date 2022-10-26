package com.example.DislinktXWSProject.service;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.DislinktXWSProject.model.User;
import com.example.DislinktXWSProject.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User findById(Long id)
    {
        Optional<User> opt=this.userRepository.findById(id);
        if(!opt.isPresent()) {
            return null;
        }
        return opt.get();
    }
	
}
