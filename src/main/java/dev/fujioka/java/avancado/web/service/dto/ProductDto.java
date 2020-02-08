package dev.fujioka.java.avancado.web.service.dto;

import java.util.Date;
import java.util.Objects;

import dev.fujioka.java.avancado.web.domain.Product;

public class ProductDto {

	private Long id;
	private String name;
	private String description;
	private Date dtCreation;
	private Date dtUpdate;

	public ProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.dtCreation = product.getDtCreation();
		this.dtUpdate = product.getDtUpdate();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDtCreation() {
		return dtCreation;
	}

	public void setDtCreation(Date dtCreation) {
		this.dtCreation = dtCreation;
	}

	public Date getDtUpdate() {
		return dtUpdate;
	}

	public void setDtUpdate(Date dtUpdate) {
		this.dtUpdate = dtUpdate;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ProductDto productDto = (ProductDto) o;
		return Objects.equals(id, productDto.id) && Objects.equals(name, productDto.name)
				&& Objects.equals(description, productDto.description)
				&& Objects.equals(dtCreation, productDto.dtCreation) && Objects.equals(dtUpdate, productDto.dtUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, dtCreation, dtUpdate);
	}

	@Override
	public String toString() {
		return "Product{" + "id=" + id + ", name='" + name + '\'' + ", description='" + description + '\''
				+ ", dtCreation=" + dtCreation + ", dtUpdate=" + dtUpdate + '}';
	}

}
