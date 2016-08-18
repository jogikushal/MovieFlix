package io.kushal.movieflix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.kushal.movieflix.entity.Title;
import io.kushal.movieflix.service.TitleService;

@RestController
@ResponseBody
@RequestMapping("/filter")
public class FilterController {
	
	@Autowired
	private TitleService service;	
	
	@RequestMapping(method=RequestMethod.GET, value="/year/{pYear}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByYear(@PathVariable("pYear") String pYear){
		return service.filter("year",pYear);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/type/{pType}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByType(@PathVariable("pType") String pType){
		return service.filter("type",pType);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/genre/{pGenre}", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Title> filterByGenre(@PathVariable("pGenre") String pGenre){
		return service.filter("genre",pGenre);
	}
}
