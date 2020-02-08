package dev.fujioka.java.avancado.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.fujioka.java.avancado.web.domain.SalesOrder;
import dev.fujioka.java.avancado.web.repository.SalesOrderRepository;

@Service
public class SalesOrderService implements CrudInterface<SalesOrder> {

	@Autowired
	private SalesOrderRepository repository;
	
	@Override
	public List<SalesOrder> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<SalesOrder> save(SalesOrder entity) {
		return Optional.of(repository.save(entity));
	}

	@Override
	public Optional<SalesOrder> findById(long id) {
		return repository.findById(id);
	}

	@Override
	public void delete(SalesOrder entity) {
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
