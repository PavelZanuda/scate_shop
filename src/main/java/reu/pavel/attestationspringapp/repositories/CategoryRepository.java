package reu.pavel.attestationspringapp.repositories;

import reu.pavel.attestationspringapp.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}
