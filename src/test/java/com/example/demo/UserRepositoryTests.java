package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void toAddNew() {
		
		User user = new User();
		
		user.setEmail("satish@123");
		user.setPassword("12345");
		user.setFirstname("Satish");
		user.setLastname("Nirmal");
		
	User saveUser =	userRepository.save(user);
	
	Assertions.assertThat(saveUser).isNotNull();
	Assertions.assertThat(saveUser.getId()).isGreaterThan(0);
	
//	System.out.println(saveUser);
	}
	
	@Test
    public void testListAll() {
    	
     List<User> users = (List<User>) userRepository.findAll();
     
     Assertions.assertThat(users).hasSizeGreaterThan(0);
    
     for(User user:users) {
    	 System.out.println(user);
     }
	}
     public void testUpdateUser() {
    	 
     Integer userId=1;
     
    Optional<User> optionalUser = userRepository.findById(userId);
     
    User user =optionalUser.get();
    
    user.setPassword("satish@111");
    userRepository.save(user);
    
    User updateUser =userRepository.findById(userId).get();

    Assertions.assertThat(updateUser.getPassword()).isEqualTo("satish@111");
    
	}
     
     public void testGet() {
    	 
    	 Integer userId=1;
    	 
    	    Optional<User> optionalUser = userRepository.findById(userId);
    	    
    	    Assertions.assertThat(optionalUser).isPresent();
    	    
    	    System.out.println(optionalUser.get());
     }
     public void deleteUser() {
    	 
    	 Integer userId=2;
    	 
    	 userRepository.deleteById(userId);
    	 
    	 Optional<User> optionalUser = userRepository.findById(userId);
    	 
    	 Assertions.assertThat(optionalUser).isNotPresent();
     }
     
}



