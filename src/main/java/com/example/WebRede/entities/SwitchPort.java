package com.example.WebRede.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.WebRede.entities.enums.Interface;
import com.example.WebRede.entities.enums.Type;
import com.example.WebRede.entities.pk.SwitchPortPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "switch_port")
public class SwitchPort implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SwitchPortPK id = new SwitchPortPK();
	
	
	private int port;
	private Type type;
	private Interface iFace;
	private Long untag;
	private Long tag;


	public SwitchPort() {
	}

	public SwitchPort(Equipment equipment, Switch switcher,int port, Type type, Interface iFace, Long untag, Long tag) {
		super();
		id.setEquip(equipment);
		id.setSwitch(switcher);
		this.port = port;
		this.type = type;
		this.iFace = iFace;
		this.untag = untag;
		this.tag = tag;
	}
	//@JsonIgnore
	public Equipment getEquip() {
		return id.getEquip();
	}
	public void setEquip(Equipment equipment) {
		id.setEquip(equipment);
	}
	@JsonIgnore
	public Switch getSwitcher() {
		return id.getSwitch();
	}
	public void setSwitcher(Switch switcher) {
		id.setSwitch(switcher);
	}
	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Interface getiFace() {
		return iFace;
	}

	public void setiFace(Interface iFace) {
		this.iFace = iFace;
	}

	public Long getUntag() {
		return untag;
	}

	public void setUntag(Long untag) {
		this.untag = untag;
	}

	public Long getTag() {
		return tag;
	}

	public void setTag(Long tag) {
		this.tag = tag;
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
		SwitchPort other = (SwitchPort) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}