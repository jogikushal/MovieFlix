package io.kushal.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.kushal.movieflix.entity.Title;
import io.kushal.movieflix.entity.TitleComment;
import io.kushal.movieflix.entity.User;
import io.kushal.movieflix.service.TitleService;

@RestController
@RequestMapping("/titles")
public class TitleController {
	
	@Autowired
	private TitleService service;
	
//Add new title
	@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title addTitle(@RequestBody Title title){
		return service.addTitle(title);
	}
	
//View Comments
	
	@RequestMapping(method=RequestMethod.GET, value="/viewcomment/{pTitle}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TitleComment> viewComment(@PathVariable("pTitle") String pTitle ){
		return service.viewComment(pTitle);
	}
	
//Add Comment to a title
	
	@RequestMapping(method=RequestMethod.POST,value="/addComment" ,produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TitleComment addComment(@RequestBody TitleComment titleComment){
		return service.addComment(titleComment);
	}
	
//Delete Title
	@RequestMapping(method=RequestMethod.DELETE, value="/delete/{pTitle}")
	public void delete(@PathVariable("pTitle") String title){
		service.deleteTitle(title);
	}
	
//Edit Title Details
	@RequestMapping(method=RequestMethod.PUT, value="/{pTitle}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title Update(@PathVariable("pTitle") String title, @RequestBody Title title1){
		return service.editTitle(title, title1);
	}

//View Title Details
	@RequestMapping(method=RequestMethod.GET, value="/{title}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Title findOne(@PathVariable("title") String title){
		
		return service.findByTitle(title);
	}

//View Top 10 Rated Titles
	@RequestMapping(method=RequestMethod.GET, 
			value="/top={type}",
			produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> viewTopRatedTitle(@PathVariable("type") String type){
		return service.viewTopRatedTitle(type);
	}
	
}
