package dev.fujioka.java.avancado.web.service.dto;

import java.util.Objects;

import dev.fujioka.java.avancado.web.domain.SalesOrder;

public class SalesOrderDto {
	
	
	
	private Long id;
	private String valor;
	
	public SalesOrderDto(SalesOrder salesOrder) {
		this.id = salesOrder.getId();
		this.valor = salesOrder.getValor();
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SalesOrderDto))
			return false;
		SalesOrderDto other = (SalesOrderDto) obj;
		return Objects.equals(id, other.id) && Objects.equals(valor, other.valor);
	}
	@Override
	public String toString() {
		return "SalesOrderDto [id=" + id + ", valor=" + valor + "]";
	}
	
	
	

}
