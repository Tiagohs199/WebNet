package com.example.WebRede.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.WebRede.entities.Equipment;
import com.example.WebRede.resources.exceptions.StandardError;
import com.example.WebRede.resources.util.URL;
import com.example.WebRede.services.EquipmentService;
import com.example.WebRede.services.exceptions.Utils;

@RestController
@RequestMapping(value = "/equipment")
public class EquipmentResource {
	
	Utils utils = new Utils();
	
	StandardError error;
	
	@Autowired
	private EquipmentService service; // autowired injeta automaticamente o userservice
	
	@GetMapping
	public ResponseEntity<List<Equipment>> findAll(){
		List<Equipment> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Equipment> findById(@PathVariable Long id){
		Equipment obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	@PostMapping
	public ResponseEntity<Equipment> insert(@RequestBody Equipment obj){	
		if(utils.ipValidate(obj)) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
	
		return ResponseEntity.created(uri).body(obj);
		}
		return ResponseEntity.badRequest().body(obj);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<Equipment> update(@PathVariable Long id, @RequestBody Equipment obj){
		if(utils.ipValidate(obj)) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
		}
		return ResponseEntity.badRequest().body(obj);
	}
	@RequestMapping(value="namesearch", method=RequestMethod.GET)
	public ResponseEntity<List<Equipment>> findByText(@RequestParam(value = "text", defaultValue = "") String text){	
		text = URL.decodeParam(text);
		List<Equipment> list = service.findByName(text);
		return ResponseEntity.ok().body(list);
	}
	@RequestMapping(value="ipsearch", method=RequestMethod.GET)
	public ResponseEntity<List<Equipment>> findByip(@RequestParam(value = "text", defaultValue = "") String text){	
		text = URL.decodeParam(text);
		List<Equipment> list = service.findByIp(text);
		return ResponseEntity.ok().body(list);
	}
	
}
