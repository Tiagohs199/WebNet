package com.example.WebRede.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "switch")
public class Switch implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int port;
	private  String type;
	private String interf;
	private String tag;
	private String untag;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
//	private Instant moment;
	
//	@ManyToOne
//	@JoinColumn(name = "equip_id")
//	private Equipment equip;

//	@OneToMany(mappedBy = "id.switch")
//	private Set<SwitchPort> itens = new HashSet<>();
	
	
	public Switch() {
	}
	public Switch(Long id, String name, int port, String type, String interf, String tag, String untag) {
		this.id = id;
		this.name = name;
		this.port = port;
		this.type = type;
		this.interf = interf;
		this.tag = tag;
		this.untag = untag;
		
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
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInterf() {
		return interf;
	}
	public void setInterf(String interf) {
		this.interf = interf;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getUntag() {
		return untag;
	}
	public void setUntag(String untag) {
		this.untag = untag;
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
