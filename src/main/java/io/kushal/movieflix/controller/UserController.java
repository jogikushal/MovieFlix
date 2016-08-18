package io.kushal.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kushal.movieflix.entity.User;
import io.kushal.movieflix.service.UserService;


	@RestController
	@RequestMapping("/users")
	public class UserController {
		
		@Autowired
		private UserService service;
		
		@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public List<User> findAll(){
			
			return service.findAll();
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public User findOne(@PathVariable("id") String userId){
			
			return service.findOne(userId);
		}
		
		@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public User create(@RequestBody User user){
			return service.create(user);
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/{id}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
		public User Update(@PathVariable("id") String userId, @RequestBody User user){
			return service.update(userId, user);
		}

		@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
		public void delete(@PathVariable("id") String userId){
			service.delete(userId);
		}
}
