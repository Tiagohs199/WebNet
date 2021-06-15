package com.example.WebRede.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.WebRede.entities.Equipment;



public interface EquipmentRepository extends JpaRepository<Equipment, Long> {
	
	
//	@Query(value = "select * from Equipment * where name.name = ?1", nativeQuery = true)
//	List<Equipment> searchName(String text);

	List<Equipment> findByNameContainingIgnoreCase(String text);
	
	List<Equipment> findByIpContainingIgnoreCase(String text);
	

}
