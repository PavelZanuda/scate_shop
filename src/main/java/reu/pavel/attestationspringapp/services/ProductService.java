package reu.pavel.attestationspringapp.services;

import reu.pavel.attestationspringapp.dto.dtio.ProductDTIO;
import reu.pavel.attestationspringapp.dto.dtoo.ProductDTOO;
import reu.pavel.attestationspringapp.entities.CategoryEntity;
import reu.pavel.attestationspringapp.entities.ProductEntity;
import reu.pavel.attestationspringapp.repositories.ProductRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public List<ProductDTOO> findAll(String search, String from, String to, String sort, String category) {
        List<ProductDTOO> productDTOOS = new ArrayList<>();

        if (category == null) category = "";

        if (search != null) {
            if (from != null) {
                if (to != null) {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromToCategory(search, from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromToCategory(search, from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromToCategory(search, from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromTo(search, from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromToCategory(search, from, to, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromToCategory(search, from, to, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromToCategory(search, from, to, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromTo(search, from, to))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                } else {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromCategory(search, from, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromCategory(search, from, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromCategory(search, from, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFrom(search, from, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromCategory(search, from, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromCategory(search, from, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFromCategory(search, from, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceFrom(search, from))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                }
            } else {
                if (to != null) {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceToCategory(search, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceToCategory(search, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceToCategory(search, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceTo(search, to, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceToCategory(search, to, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceToCategory(search, to, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceToCategory(search, to, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsWherePriceTo(search, to))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }

                    }
                } else {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsCategory(search, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsCategory(search, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsCategory(search, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContains(search, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsCategory(search, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsCategory(search, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContainsCategory(search, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByTitleContains(search))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                }
            }
        } else {
            if (from != null) {
                if (to != null) {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromToCategory(from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromToCategory(from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromToCategory(from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByPriceBetween(from, to, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromToCategory(from, to, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromToCategory(from, to, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromToCategory(from, to, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByPriceBetween(from, to))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                } else {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromCategory(from, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromCategory(from, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromCategory(from, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByPriceGreaterThan(from, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromCategory(from, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromCategory(from, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceFromCategory(from, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByPriceGreaterThan(from))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                }
            } else {
                if (to != null) {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceToCategory(to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceToCategory(to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceToCategory(to, Sort.by(Sort.DEFAULT_DIRECTION, sort), categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByPriceLessThan(to, Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceToCategory(to, categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceToCategory(to, categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findWherePriceToCategory(to, categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findByPriceLessThan(to))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                } else {
                    if (sort != null) {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByCategoryEntity(categoryService.findById(1), Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByCategoryEntity(categoryService.findById(2), Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByCategoryEntity(categoryService.findById(3), Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findAll(Sort.by(Sort.DEFAULT_DIRECTION, sort)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    } else {
                        switch (category) {
                            case "shoes" -> {
                                for (ProductEntity productEntity : productRepository.findByCategoryEntity(categoryService.findById(1)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "blades" -> {
                                for (ProductEntity productEntity : productRepository.findByCategoryEntity(categoryService.findById(2)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            case "clothes" -> {
                                for (ProductEntity productEntity : productRepository.findByCategoryEntity(categoryService.findById(3)))
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                            default -> {
                                for (ProductEntity productEntity : productRepository.findAll())
                                    productDTOOS.add(ProductEntity.convertToProductDTOO(productEntity));
                            }
                        }
                    }
                }
            }
        }

        return productDTOOS;
    }

    @Transactional
    public void save(@NotNull ProductDTIO productDTIO) throws IOException {
        MultipartFile multipartFile = productDTIO.getMultipartFile();
        CategoryEntity categoryEntity = categoryService.findById(productDTIO.getCategory());

        multipartFile.transferTo(new File(ProductDTIO.PRODUCTS_IMAGES_PATH + multipartFile.getOriginalFilename()));
        productRepository.save(ProductDTIO.convertToProductEntity(productDTIO, categoryEntity));
    }

    public ProductDTOO findById(int id) {
        Optional<ProductEntity> productEntityOptional = productRepository.findById(id);

        return productEntityOptional.map(ProductEntity::convertToProductDTOO).orElse(null);

    }

    public Optional<ProductEntity> findByIdOpt(int id) {
        return productRepository.findById(id);
    }

    @Transactional
    public void edit(int id, @NotNull ProductDTIO productDTIO) throws IOException {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow();
        File oldFile = new File(productEntity.getFilePath());
        MultipartFile multipartFile = productDTIO.getMultipartFile();
        File newFile = new File(ProductDTIO.PRODUCTS_IMAGES_PATH + multipartFile.getOriginalFilename());

        if (!multipartFile.isEmpty()) {
            multipartFile.transferTo(newFile);
            productRepository.save(ProductDTIO.convertToProductEntity(productDTIO, id));

            if (!oldFile.getPath().equals(newFile.getPath()))
                if (!oldFile.delete()) throw new IOException();
        } else {
            productEntity.setTitle(productDTIO.getTitle());
            productEntity.setPrice(productDTIO.getPrice());
            productRepository.save(productEntity);
        }
    }

    @Transactional
    public void deleteById(int id) throws IOException {
        ProductEntity productEntity = productRepository.findById(id).orElse(null);

        if (productEntity != null) {
            File file = new File(productEntity.getFilePath());

            if (!file.delete()) throw new IOException();
        }

        productRepository.deleteById(id);
    }
}
