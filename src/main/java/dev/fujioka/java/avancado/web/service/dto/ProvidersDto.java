package dev.fujioka.java.avancado.web.service.dto;

import java.util.Objects;

import dev.fujioka.java.avancado.web.domain.Providers;

public class ProvidersDto {

	private Long id;
	private String name;
	private String email;
	private String contato;
	
	public ProvidersDto(Providers providers) {
		this.id = providers.getId();
		this.name = providers.getName();
		this.email = providers.getEmail();
		this.contato = providers.getContato();	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		return Objects.hash(contato, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof ProvidersDto))
			return false;
		ProvidersDto other = (ProvidersDto) obj;
		return Objects.equals(contato, other.contato) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "ProvidersDto [id=" + id + ", name=" + name + ", email=" + email + ", contato=" + contato + "]";
	}

}
