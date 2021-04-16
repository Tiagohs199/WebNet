package com.example.WebRede.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.WebRede.entities.Local;
import com.example.WebRede.repositories.LocalRepository;
import com.example.WebRede.services.exceptions.DatabaseException;
import com.example.WebRede.services.exceptions.ResourceNotFoundException;

@Service  //registra como componente do spring
public class LocalService  {
	
	@Autowired
	private LocalRepository repository;
	
	public List<Local> findAll(){
		return repository.findAll();
	}
	
	public Local findById(Long id) {
		Optional<Local> obj = repository.findById(id);
		return obj.get();
	}
	public Local insert (Local obj) {
		return repository.save(obj);
	}
	public void delete(Long id) {
		try {
		repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	public Local update(Long id, Local obj) {
		try {
		Local entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		} 
	}

	private void updateData(Local entity, Local obj) {
		entity.setName(obj.getName());
	}
}
