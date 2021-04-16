package com.example.WebRede.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.WebRede.entities.pk.SwitchPortPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "switch_port")
public class SwitchPort implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private SwitchPortPK id = new SwitchPortPK();
	
	private Integer quantity;
	
	public SwitchPort() {
	}

	public SwitchPort(Switch switcher, Local local, Integer quantity) {
		super();
		id.setOrder(switcher);
		id.setProduct(local);
		this.quantity = quantity;
		
	}
	
	@JsonIgnore
	public Switch getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Switch order) {
		id.setOrder(order);
	}
	public Local getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Local product) {
		id.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
