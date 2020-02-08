package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Shipping;
import dev.fujioka.java.avancado.web.repository.ShippingRepository;

@Service
public class ShippingService implements CrudInterface<Shipping>{
	
	@Autowired
	private ShippingRepository repository;

	@Override
	public List<Shipping> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Shipping> save(Shipping entity) {
		return Optional.of(repository.save(entity));
	}

	@Override
	public Optional<Shipping> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Shipping entity) {
		repository.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		repository.deleteById(id);
	}

	@Override
	public long count() {
		return repository.count();
	}

}
