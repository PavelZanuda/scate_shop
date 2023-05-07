package reu.pavel.attestationspringapp.repositories;

import reu.pavel.attestationspringapp.embeddable.OrdersProductsKey;
import reu.pavel.attestationspringapp.entities.OrdersProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersProductsRepository extends JpaRepository<OrdersProductsEntity, OrdersProductsKey> {

}
