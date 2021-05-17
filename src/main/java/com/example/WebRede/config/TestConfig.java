package com.example.WebRede.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.WebRede.entities.Equipment;
import com.example.WebRede.entities.Local;
import com.example.WebRede.entities.Switch;
import com.example.WebRede.entities.SwitchPort;
import com.example.WebRede.entities.enums.Interface;
import com.example.WebRede.entities.enums.Type;
import com.example.WebRede.repositories.EquipmentRepository;
import com.example.WebRede.repositories.LocalRepository;
import com.example.WebRede.repositories.SwitchPortRepository;
import com.example.WebRede.repositories.SwitchRepository;

@Configuration
@Profile("dev")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private EquipmentRepository equipRepository;
	@Autowired
	private SwitchRepository switRepository;
	@Autowired 
	private SwitchPortRepository portsRepository;
	@Autowired
	private LocalRepository localRepository;
	

	@Override
	public void run(String... args) throws Exception {
		
		Local l1 = new Local(null, "CT-E");
		Local l2 = new Local(null, "CT-B");
		localRepository.saveAll(Arrays.asList(l1,l2));
		
		Switch s1 = new Switch(null, "Switcher dell", "modelo", "Login","password",l1);
		Switch s2 = new Switch(null, "Switcher name", "modelo X", "Login", "mnt@3ng",l2);
		
		switRepository.saveAll(Arrays.asList(s1,s2));
		
	
		Equipment u1 = new Equipment(null, "192.168.0.1", "pc dell", "tiago", "123456",s1);
		Equipment u2 = new Equipment(null, "100.1.1.08", "pc hp", "teste", "123456",s1);
		Equipment u3 = new Equipment(null, "100.1.1.09", "monitorit", "gfadss", "123456",s1);
		Equipment u4 = new Equipment(null, "100.1.1.10", "pc cronometro", "cxvxce", "123456",s2);
		Equipment u5 = new Equipment(null, "100.1.1.11", "pc audio", "teste", "123456",s2);
		Equipment u6 = new Equipment(null, "100.1.1.11", "pc audio", "teste", "123456",s2);
		Equipment u7 = new Equipment(null, "100.1.1.11", "pc audio", "teste", "123456",s2);
		Equipment u8 = new Equipment(null, "100.1.1.11", "pc audio", "teste", "123456",s2);
		
	
	
		equipRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6,u7,u8));
		
		SwitchPort sw1 = new SwitchPort(u1,s1,1,Type.ACESSO,Interface.GE,null,null);
		SwitchPort sw2 = new SwitchPort(u2,s1,2,Type.ACESSO,Interface.GE,null,null);
		SwitchPort sw3 = new SwitchPort(u3,s1,3,Type.ACESSO,Interface.GE,null,null);
		SwitchPort sw4 = new SwitchPort(u4,s1,4,Type.ACESSO,Interface.GE,null,null);
		
		portsRepository.saveAll(Arrays.asList(sw1,sw2,sw3,sw4));
	
		
		
	
	
		
		
	}
}
