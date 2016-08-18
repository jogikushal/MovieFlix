package io.kushal.movieflix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kushal.movieflix.entity.UserRating;
import io.kushal.movieflix.service.TitleService;

@RestController
@RequestMapping(value="/titles")
public class UserRatingController {
	
	@Autowired
	TitleService service;
	
	//Rate a title
			@RequestMapping(method=RequestMethod.POST, 
					value="/rate",
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE, 
					consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
			public UserRating rateTitle(@RequestBody UserRating rating){
				return service.rateTitle(rating);
			}
			
			//View average user rating of a title
			@RequestMapping(method=RequestMethod.GET, 
					value="/{title}/viewRating",
					produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
			public String viewRatingOnTitle(@PathVariable("title") String title){
				return service.viewRatingOnTitle(title);
			}
}
