package dev.fujioka.java.avancado.web.service.dto;

import java.util.Objects;

import dev.fujioka.java.avancado.web.domain.Shipping;

public class ShippingDto {
	
	private Long id;
	private String status;
	private Long id_order;
	
	public ShippingDto (Shipping shipping) {
		this.id = shipping.getId();
		this.status = shipping.getStatus();
		this.id_order = shipping.getId_order();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public Long getId_order() {
		return id_order;
	}

	public void setId_order(Long id_order) {
		this.id_order = id_order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ShippingDto))
			return false;
		ShippingDto other = (ShippingDto) obj;
		return Objects.equals(id, other.id) && status == other.status;
	}
	@Override
	public String toString() {
		return "ShippingDto [id=" + id + ", status=" + status + "]";
	}
	
	
	

}
