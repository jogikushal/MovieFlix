package io.kushal.movieflix.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.kushal.movieflix.entity.Title;
import io.kushal.movieflix.entity.TitleComment;
import io.kushal.movieflix.entity.UserRating;

@Repository
public class TitleRepositoryImpl implements TitleRepository {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Title> sort(String sortBy) {
		// TODO Auto-generated method stub
		TypedQuery<Title> query = null;
		if(sortBy.equals("votes")){
			query = em.createNamedQuery("Title.sortByVotes", Title.class);
		}else if(sortBy.equals("year")){
			query = em.createNamedQuery("Title.sortByYear", Title.class);
		}else if(sortBy.equals("rating")){
			query = em.createNamedQuery("Title.sortByRating", Title.class);
		}
		return query.getResultList();
	}

	
	
	@Override
	public Title addTitle(Title title) {
		// TODO Auto-generated method stub
		em.persist(title);
		return title;
	}



	@Override
	public List<Title> filter(String filterBy, String filterValue) {
		TypedQuery<Title> query = null;
		if(filterBy.equals("year")){
			query = em.createNamedQuery("Title.filterByYear", Title.class);
			query.setParameter("pYear", filterValue);
		}else if(filterBy.equals("genre")){
			query = em.createNamedQuery("Title.filterByGenre", Title.class);
			query.setParameter("pGenre", "%"+filterValue+"%");
		}else if(filterBy.equals("type")){
			query = em.createNamedQuery("Title.filterByType", Title.class);
			query.setParameter("pType", filterValue);
		}
		return query.getResultList();
	}



	@Override
	public List<TitleComment> viewComment(String title) {
		TypedQuery<TitleComment> query = null;
		query = em.createNamedQuery("TitleComment.ViewComment", TitleComment.class);
		query.setParameter("pTitle", title);
		return query.getResultList();
	}



	@Override
	public TitleComment addComment(TitleComment titleComment) {
		em.persist(titleComment);
		return titleComment;
	}



	@Override
	public void deleteTitle(Title title) {
		// TODO Auto-generated method stub
		em.remove(title);
	}



	@Override
	public Title findOne(String title) {
		// TODO Auto-generated method stub
		return em.find(Title.class, title);
	}



	@Override
	public Title findByTitle(String title) {
		TypedQuery<Title> query = em.createNamedQuery("Title.findByTitle",Title.class);
		query.setParameter("pTitle", title);
		List<Title> titles = query.getResultList();
		if(titles != null && titles.size()==1){
			return titles.get(0);
		}
		else{
			return null;
		}
	}



	@Override
	public Title editTitle(Title title) {
		// TODO Auto-generated method stub
		return em.merge(title);
	}



	@Override
	public UserRating rateTitle(UserRating rating) {
		// TODO Auto-generated method stub
		em.persist(rating);
		return rating;
	}



	@Override
	public String viewRatingOnTitle(String title) {
		// TODO Auto-generated method stub
		TypedQuery<String> query = em.createNamedQuery("UserRating.AvgRating", String.class); 
		query.setParameter("pTitle", title);
		String rating = query.getSingleResult();
		if(rating != null)
			return rating;
		return null;
	}



	@Override
	public List<Title> viewTopRatedTitle(String type) {
		// TODO Auto-generated method stub
		TypedQuery<Title> query = em.createNamedQuery("Title.topTitles", Title.class); 
		query.setParameter("pType", type);
		query.setMaxResults(10);
		return query.getResultList();
	}
	
	
}
