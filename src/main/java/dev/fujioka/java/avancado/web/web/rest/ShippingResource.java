package dev.fujioka.java.avancado.web.web.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.fujioka.java.avancado.web.domain.SalesOrder;
import dev.fujioka.java.avancado.web.domain.Shipping;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;
import dev.fujioka.java.avancado.web.service.SalesOrderService;
import dev.fujioka.java.avancado.web.service.ShippingService;
import dev.fujioka.java.avancado.web.service.dto.SalesOrderDto;
import dev.fujioka.java.avancado.web.service.dto.ShippingDto;

@RestController
@RequestMapping("/api")
public class ShippingResource {

		@Autowired
		private ShippingService shippingService;
		@Autowired
		private SalesOrderService sOService;
		
		
		@GetMapping("/shipping")
		public List<Shipping>getAll(){
			return shippingService.findAll();
		}
		
		@GetMapping("shipping/{id}")
		public ResponseEntity<ShippingDto>getSalesOrderById(@PathVariable Long id){
			ShippingDto shippingDto =new ShippingDto(shippingService.findById(id)
					.orElseThrow(() -> new EntityPersistUpdateFindException("shipping", "id", id.toString())));
			return ResponseEntity.ok(shippingDto) ;
		}
		
		
		@PostMapping("/shipping")
		public ResponseEntity<ShippingDto>save(@Valid @RequestBody Shipping shipping){
			ShippingDto sDto = new ShippingDto(shippingService.save(shipping).orElseThrow(() -> new EntityPersistUpdateFindException("Provider", "id", shipping.toString())));
			
			return ResponseEntity.ok(sDto);
		}
		
}
