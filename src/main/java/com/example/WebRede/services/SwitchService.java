package com.example.WebRede.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.WebRede.entities.Switch;
import com.example.WebRede.repositories.SwitchRepository;
import com.example.WebRede.services.exceptions.DatabaseException;
import com.example.WebRede.services.exceptions.ResourceNotFoundException;

@Service  //registra como componente do spring
public class SwitchService  {
	
	@Autowired
	private SwitchRepository repository;
	
	public List<Switch> findAll(){
		return repository.findAll();
	}
	
	public Switch findById(Long id) {
		Optional<Switch> obj = repository.findById(id);
		return obj.get();
	}
	public Switch insert (Switch obj) {
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
	public Switch update(Long id, Switch obj) {
		try {
		Switch entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		} 
	}

	private void updateData(Switch entity, Switch obj) {
		entity.setName(obj.getName());
		entity.setId(obj.getId());
		
	}
}
