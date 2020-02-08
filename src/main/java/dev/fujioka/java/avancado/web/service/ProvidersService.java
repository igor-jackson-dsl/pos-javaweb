package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.Providers;
import dev.fujioka.java.avancado.web.repository.ProvidersRepository;

@Service
public class ProvidersService implements CrudInterface<Providers> {
	
	@Autowired
	private ProvidersRepository repository;
	
	@Override
	public List<Providers> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Providers> save(Providers entity) {
		return Optional.of(repository.save(entity));
	}

	@Override
	public Optional<Providers> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public void delete(Providers entity) {
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
