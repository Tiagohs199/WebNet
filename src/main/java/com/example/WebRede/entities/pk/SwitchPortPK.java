package com.example.WebRede.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.WebRede.entities.Equipment;
import com.example.WebRede.entities.Switch;

@Embeddable
public class SwitchPortPK  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name= "switcher_id")
	private Switch switcher;
	
	@ManyToOne
	@JoinColumn(name= "equipment_id")
	private Equipment equipment;
	
	
	public Switch getSwitch() {
		return switcher;
	}
	public void setSwitch(Switch switcher) {
		this.switcher = switcher;
	}
	public Equipment getEquip() {
		return equipment;
	}
	public void setEquip(Equipment equipment) {
		this.equipment = equipment;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((switcher == null) ? 0 : switcher.hashCode());
		result = prime * result + ((equipment == null) ? 0 : equipment.hashCode());
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
		SwitchPortPK other = (SwitchPortPK) obj;
		if (switcher == null) {
			if (other.switcher != null)
				return false;
		} else if (!switcher.equals(other.switcher))
			return false;
		if (equipment == null) {
			if (other.equipment != null)
				return false;
		} else if (!equipment.equals(other.equipment))
			return false;
		return true;
	}
}
