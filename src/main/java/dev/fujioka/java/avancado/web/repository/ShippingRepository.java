package dev.fujioka.java.avancado.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.fujioka.java.avancado.web.domain.Shipping;


@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
