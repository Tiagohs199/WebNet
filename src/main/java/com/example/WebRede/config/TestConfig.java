package com.example.WebRede.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.WebRede.entities.Equipment;
import com.example.WebRede.entities.Local;
import com.example.WebRede.entities.Switch;
import com.example.WebRede.repositories.EquipmentRepository;
import com.example.WebRede.repositories.LocalRepository;
import com.example.WebRede.repositories.SwitchRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private EquipmentRepository equipRepository;
	@Autowired
	private SwitchRepository switRepository;
//	@Autowired 
//	private CategoryRepository categoryRepository;
	@Autowired
	private LocalRepository localRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
	
		Equipment u1 = new Equipment(null, "192.168.0.1", "pc dell", "tiago", "123456");
		Equipment u2 = new Equipment(null, "100.1.1.08", "pc hp", "teste", "123456");
		Equipment u3 = new Equipment(null, "100.1.1.09", "pc hp", "gfadss", "123456");
		Equipment u4 = new Equipment(null, "100.1.1.10", "pc hp", "cxvxce", "123456");
		Equipment u5 = new Equipment(null, "100.1.1.11", "pc hp", "teste", "123456");
		
		
		
		Local l1 = new Local(null, "CT-E");
		
		equipRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5));
		
		
		
		localRepository.save(l1);
		
	
		
		
	}
}
