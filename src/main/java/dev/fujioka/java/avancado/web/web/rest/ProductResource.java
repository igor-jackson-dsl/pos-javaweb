package dev.fujioka.java.avancado.web.web.rest;

import dev.fujioka.java.avancado.web.domain.Product;
import dev.fujioka.java.avancado.web.domain.User;
import dev.fujioka.java.avancado.web.exception.EntityPersistUpdateFindException;
import dev.fujioka.java.avancado.web.repository.ProductRepository;
import dev.fujioka.java.avancado.web.service.ProductService;
import dev.fujioka.java.avancado.web.service.ProvidersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private ProductService productService;
    @Autowired 
    private ProvidersService providersService;


    @GetMapping("/product")
    public List<Product> getProductList() {

        return productService.findAll();
    }

    @PostMapping("/product/{provider}")
    public ResponseEntity<Product> save(@PathVariable Long provider, @RequestBody Product product) {
    	product.setProviderProduct(providersService.findById(provider).get());
        product = productService.save(product).get() ;
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> update(
            @RequestBody Product product) {

        product = productService.save(product).get();

        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> delete(
            @RequestBody Product product) {

        productService.delete(product);
        return ResponseEntity.ok().body("Product excluded " + product.getId());
    }
    @DeleteMapping("/product/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        Product productDelete = productService.findById(id)
                .orElseThrow(() -> new EntityPersistUpdateFindException("Person", "id", id.toString()));
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
