package reu.pavel.attestationspringapp.entities;

import reu.pavel.attestationspringapp.dto.dtoo.ProductDTOO;
import jakarta.persistence.*;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "file_name")
    private String fileName;
    @Column(name = "file_path")
    private String filePath;
    @Column(name = "file_type")
    private String fileType;
    @Column(name = "file_size")
    private long fileSize;
    @Column(name = "title")
    private String title;
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "productEntity")
    private List<CartEntity> cartEntities;
    @OneToMany(mappedBy = "productEntity")
    private List<OrdersProductsEntity> ordersProductsEntities;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    public ProductEntity() {
    }

    public ProductEntity(String fileName, String filePath, String fileType, long fileSize, String title, BigDecimal price, String description, CategoryEntity categoryEntity) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.title = title;
        this.price = price;
        this.description = description;
        this.categoryEntity = categoryEntity;
    }

    public ProductEntity(int id, String fileName, String filePath, String fileType, long fileSize, String title, BigDecimal price) {
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileSize = fileSize;
        this.title = title;
        this.price = price;
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull ProductDTOO convertToProductDTOO(@NotNull ProductEntity productEntity) {
        return new ProductDTOO(productEntity.id, productEntity.fileName, productEntity.title, productEntity.price, productEntity.description, productEntity.getCategoryEntity().getTitle());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CartEntity> getCartEntities() {
        return cartEntities;
    }

    public void setCartEntities(List<CartEntity> cartEntities) {
        this.cartEntities = cartEntities;
    }

    public List<OrdersProductsEntity> getOrdersProductsEntities() {
        return ordersProductsEntities;
    }

    public void setOrdersProductsEntities(List<OrdersProductsEntity> ordersProductsEntities) {
        this.ordersProductsEntities = ordersProductsEntities;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
