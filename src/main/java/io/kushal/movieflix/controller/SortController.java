package io.kushal.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.kushal.movieflix.entity.Title;
import io.kushal.movieflix.service.TitleService;

@RestController
@ResponseBody
@RequestMapping("/sort")
public class SortController {
	@Autowired
	private TitleService service;
	
	@RequestMapping(method=RequestMethod.GET, value="/votes", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByVotes(){
		return service.sort("votes");
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/year", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByYear(){
		return service.sort("year");
	}
	@RequestMapping(method=RequestMethod.GET, value="/rating", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> sortByRating(){
		return service.sort("rating");
	}
}
