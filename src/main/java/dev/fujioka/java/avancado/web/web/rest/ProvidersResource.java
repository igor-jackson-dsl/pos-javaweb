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

import dev.fujioka.java.avancado.web.domain.Providers;
import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;
import dev.fujioka.java.avancado.web.service.ProvidersService;
import dev.fujioka.java.avancado.web.service.dto.ProvidersDto;
import dev.fujioka.java.avancado.web.service.dto.UserDto;

@RestController
@RequestMapping("/api")
public class ProvidersResource {
	
	@Autowired
	private ProvidersService providerService;
	
	@GetMapping("providers")
	public List<Providers>getAll(){
		return providerService.findAll();
	}
	
	@GetMapping("providers/{id}")
	public ResponseEntity<ProvidersDto>getProviderById(@PathVariable Long id){
		ProvidersDto pDto =new ProvidersDto(providerService.findById(id)
				.orElseThrow(() -> new EntityPersistUpdateFindException("Provider", "id", id.toString())));
		return ResponseEntity.ok(pDto) ;
	}
	
	@PostMapping("/providers")
	public ResponseEntity<ProvidersDto>save(@Valid @RequestBody Providers providers){
		ProvidersDto pDto = new ProvidersDto(providerService.save(providers).orElseThrow(() -> new EntityPersistUpdateFindException("Provider", "id", providers.toString())));
		
		return ResponseEntity.ok(pDto);
	}
	
	@PutMapping("/providers")
    public ResponseEntity<ProvidersDto> update(@Valid @RequestBody Providers providers) {
        if(providers.getId()!=null){
            ProvidersDto providersDto = new ProvidersDto(providerService.save(providers)
                .orElseThrow(() -> new EntityPersistUpdateFindException("Person", "Not Update", providers.toString())));
            return ResponseEntity.ok(providersDto);
        }
        return ResponseEntity.notFound().build();
    }
	
	@DeleteMapping("/providers")
    public ResponseEntity delete(@Valid @RequestBody Providers providers) {
        providerService.delete(providers);
        return ResponseEntity.ok().build();
    }
	
	@DeleteMapping("/providers/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Providers providersDelete = providerService.findById(id)
                .orElseThrow(() -> new EntityPersistUpdateFindException("Person", "id", id.toString()));
        providerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
	


}
