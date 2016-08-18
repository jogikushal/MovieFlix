package io.kushal.movieflix.repository;

import java.util.List;

import io.kushal.movieflix.entity.Title;
import io.kushal.movieflix.entity.TitleComment;
import io.kushal.movieflix.entity.UserRating;

public interface TitleRepository {
	public List<Title> sort(String sortBy);
	public List<Title> filter(String filterBy, String filterValue);
	public Title addTitle(Title title);
	public void deleteTitle(Title title);
	public Title findOne(String title);
	public Title findByTitle(String title);
	public Title editTitle(Title title);
	public List<TitleComment> viewComment(String title);
	public TitleComment addComment(TitleComment titleComment);
	
	public UserRating rateTitle(UserRating rating);
	public String viewRatingOnTitle(String title);
	public List<Title> viewTopRatedTitle(String type);
}
