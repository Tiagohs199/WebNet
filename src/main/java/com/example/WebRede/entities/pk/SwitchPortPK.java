package com.example.WebRede.entities.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.WebRede.entities.Local;
import com.example.WebRede.entities.Switch;

@Embeddable
public class SwitchPortPK  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
//	@ManyToOne
//	@JoinColumn(name= "order_id")
	private Switch switcher;
	
//	@ManyToOne
//	@JoinColumn(name= "product_id")
	private Local local;
	
	
	public Switch getOrder() {
		return switcher;
	}
	public void setOrder(Switch order) {
		this.switcher = order;
	}
	public Local getProduct() {
		return local;
	}
	public void setProduct(Local product) {
		this.local = product;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((switcher == null) ? 0 : switcher.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
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
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}
}
