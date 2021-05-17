package com.example.WebRede.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "switch")
public class Switch implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String modelo;
	private String login;
	private String password;
	
	
	@ManyToOne
	@JoinColumn(name = "locais_id")
	private Local locais;

	
	@JsonIgnore
	@OneToMany(mappedBy = "switches")
	private List<Equipment> equip = new ArrayList<>();
	
	@OneToMany(mappedBy = "id.switcher")
	private Set<SwitchPort> ports = new HashSet<>();
	
	
	public Switch() {
	}

	public Switch(Long id, String name, String modelo, String login, String password, Local locais) {
		super();
		this.id = id;
		this.name = name;
		this.modelo = modelo;
		this.login = login;
		this.password = password;
		this.locais = locais;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Set<SwitchPort> getPorts(){
		return ports;
	}
	public List<Equipment> getEquip() {
		return equip;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Switch other = (Switch) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
