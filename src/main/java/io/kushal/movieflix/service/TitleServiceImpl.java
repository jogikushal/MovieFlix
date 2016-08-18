package io.kushal.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.kushal.movieflix.entity.Title;
import io.kushal.movieflix.entity.TitleComment;
import io.kushal.movieflix.entity.User;
import io.kushal.movieflix.entity.UserRating;
import io.kushal.movieflix.exceptions.UserNotFound;
import io.kushal.movieflix.repository.TitleRepository;

@Service
@Transactional
public class TitleServiceImpl implements TitleService {
	
	@Autowired
	private TitleRepository repository;
	
	@Override
	public List<Title> sort(String sortBy) {
		// TODO Auto-generated method stub
		return repository.sort(sortBy);
	}

	@Override
	public Title addTitle(Title title) {
		return repository.addTitle(title);
	}

	@Override
	public List<Title> filter(String filterBy, String filterValue) {
		// TODO Auto-generated method stub
		return repository.filter(filterBy,filterValue);
	}

	@Override
	public List<TitleComment> viewComment(String title) {
		// TODO Auto-generated method stub
		return repository.viewComment(title);
	}

	@Override
	public TitleComment addComment(TitleComment titleComment) {
		// TODO Auto-generated method stub
		
		return repository.addComment(titleComment);
	}

	@Override
	public void deleteTitle(String title) {
		// TODO Auto-generated method stub
		Title existing = repository.findByTitle(title);
		if(existing == null){
			throw new UserNotFound("No title named "+title+" found");
		}
		
		repository.deleteTitle(existing);
		
	}

	@Override
	public Title findOne(String title) {
		Title existing = repository.findOne(title);
		if(existing == null){
			throw new UserNotFound("Title with totle ="+title+" not found");
		}
		
		return existing;
	}

	@Override
	public Title editTitle(String title, Title title1) {
		Title existing = repository.findByTitle(title);
		if(existing == null){
			throw new UserNotFound("No title with name "+title+" found");
		}
		
		return repository.editTitle(title1);
	}

	@Override
	public Title findByTitle(String title) {
		// TODO Auto-generated method stub
		return repository.findByTitle(title);
	}

	@Override
	public UserRating rateTitle(UserRating rating) {
		// TODO Auto-generated method stub
		return repository.rateTitle(rating);
	}

	@Override
	public String viewRatingOnTitle(String title) {
		// TODO Auto-generated method stub
		return repository.viewRatingOnTitle(title);
	}

	@Override
	public List<Title> viewTopRatedTitle(String type) {
		// TODO Auto-generated method stub
		return repository.viewTopRatedTitle(type);
	}
	
}
