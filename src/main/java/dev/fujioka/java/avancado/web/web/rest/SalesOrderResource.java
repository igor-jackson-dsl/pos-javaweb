package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.domain.Providers;
import dev.fujioka.java.avancado.web.domain.SalesOrder;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;
import dev.fujioka.java.avancado.web.service.ProductService;
import dev.fujioka.java.avancado.web.service.SalesOrderService;
import dev.fujioka.java.avancado.web.service.UserService;
import dev.fujioka.java.avancado.web.service.dto.ProvidersDto;
import dev.fujioka.java.avancado.web.service.dto.SalesOrderDto;

@RestController
@RequestMapping("/api")
public class SalesOrderResource {
	
	@Autowired
	private SalesOrderService SOService;
	@Autowired
	private ProductService pService;
	@Autowired
	private UserService uService;
	
	@GetMapping("salesOrder")
	public List<SalesOrder>getAll(){
		return SOService.findAll();
	}
	
	@GetMapping("salesOrder/{id}")
	public ResponseEntity<SalesOrderDto>getSalesOrderById(@PathVariable Long id){
		SalesOrderDto saleODto =new SalesOrderDto(SOService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("SalesOrder", "id", id.toString())));
		return ResponseEntity.ok(saleODto) ;
	}
	
	@PostMapping("/salesOrder/{idUser}/{idProduct}")
	public ResponseEntity<SalesOrderDto>save(@PathVariable Long idUser,@PathVariable Long idProduct ,@Valid @RequestBody SalesOrder salesOrder){
		salesOrder.setProductOrder(pService.findById(idProduct).get());
		salesOrder.setUserOrder(uService.findById(idUser).get());
		SalesOrderDto sDto = new SalesOrderDto(SOService.save(salesOrder).orElseThrow(() -> new EntityPersistUpdateFindException("Provider", "id", salesOrder.toString())));
		
		return ResponseEntity.ok(sDto);
	}
	
	 @DeleteMapping("/salesOrder/{id}")
	    public ResponseEntity deleteById(@PathVariable Long id) {
	        SalesOrder salesOrderDelete = SOService.findById(id)
	                .orElseThrow(() -> new EntityPersistUpdateFindException("Person", "id", id.toString()));
	        SOService.deleteById(id);
	        return ResponseEntity.ok().build();
	    }
	 
	 @PutMapping("/salesOrder")
	    public ResponseEntity<SalesOrder> update(
	            @RequestBody SalesOrder salesOrder) {

	        salesOrder = SOService.save(salesOrder).get();

	        return ResponseEntity.ok().body(salesOrder);
	    }
}
