package reu.pavel.attestationspringapp.services;

import reu.pavel.attestationspringapp.entities.CategoryEntity;
import reu.pavel.attestationspringapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryEntity findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
