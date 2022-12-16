package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.User;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/home")
	public String home() {
		
		return "index";
	}
	
	@GetMapping("/users")
     public String showUserList(Model model) {
		
		List<User> listUsers = userService.listAll();
		model.addAttribute( "listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/users/new")
	public String showNewForm(Model model) {
		model.addAttribute( "user", new User());
		model.addAttribute("pageTitle", "Add New User");
		return "user_form";
	}
	
	@PostMapping("/users/save")
	public String saveUser(@RequestBody User user , RedirectAttributes redirectAttributes) {
		
		userService.saveUser(user);
		redirectAttributes.addFlashAttribute("message","the user has saved Succesfully");
	
		return  "redirect:/users";
	}
	
	@GetMapping("/users/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model , RedirectAttributes redirectAttributes) {
		
		try {
	      User user2=userService.getUser(id);
	      model.addAttribute("user", user2);
	      model.addAttribute("pageTitle", "Edit User(ID: "+ id +")");
	  	
	  	return "user_form";
		}
		catch (UserNotFoundException e) {
			redirectAttributes.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/users";
			}
	
	@DeleteMapping("/users/delete/{id}")
	public String deleteUser(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
		
		try {
	   userService.deleteUser(id);
		}
		catch (UserNotFoundException e) {
			redirectAttributes.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/users";
			}
}
