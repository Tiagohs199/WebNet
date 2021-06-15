package com.example.WebRede.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.WebRede.entities.Equipment;
import com.example.WebRede.repositories.EquipmentRepository;
import com.example.WebRede.services.exceptions.DatabaseException;
import com.example.WebRede.services.exceptions.ResourceNotFoundException;

@Service  //registra como componente do spring
public class EquipmentService  {
	
	@Autowired
	private EquipmentRepository repository;
	
	public List<Equipment> findAll(){
		return repository.findAll();
	}
	
	public Equipment findById(Long id) {
		Optional<Equipment> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	public Equipment insert (Equipment obj) {
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
	public Equipment update(Long id, Equipment obj) {
		try {
		Equipment entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(e);
		} 
	}

	private void updateData(Equipment entity, Equipment obj) {
		entity.setName(obj.getName());
		entity.setIp(obj.getIp());
		entity.setLogin(obj.getLogin());
		entity.setPassword(obj.getPassword());
	}
	
	public List<Equipment> findByName(String text){
		return repository.findByNameContainingIgnoreCase(text);
	}
	public List<Equipment> findByIp(String text){
		return repository.findByIpContainingIgnoreCase(text);
	}
}
