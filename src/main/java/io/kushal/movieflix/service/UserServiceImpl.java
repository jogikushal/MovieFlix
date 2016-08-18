package io.kushal.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.kushal.movieflix.entity.User;
import io.kushal.movieflix.exceptions.UserAlreadyExistException;
import io.kushal.movieflix.exceptions.UserNotFound;
import io.kushal.movieflix.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository repository;
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public User findOne(String id) {
		// TODO Auto-generated method stub
		User existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFound("User with id ="+id+" not found");
		}
		
		return existing;
	}

	@Override
	public User create(User user) {
		// check for email duplicacy
		User existing = repository.findByEmail(user.getEmail());
		if(existing != null){
			throw new UserAlreadyExistException("The user with this email already exist");
		}
		
		return repository.create(user);
	}

	@Override
	public User update(String id, User user) {
		// TODO Auto-generated method stub
		User existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFound("User with id ="+id+" not found");
		}
		
		return repository.update(user);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		User existing = repository.findOne(id);
		if(existing == null){
			throw new UserNotFound("User with id ="+id+" not found");
		}
		
		repository.delete(existing);
		
	}

}

