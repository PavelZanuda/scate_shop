package reu.pavel.attestationspringapp.dto.dtoo;

import java.math.BigDecimal;

public class ProductDTOO {
    private int id;
    private String fileName;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;

    public ProductDTOO() {

    }

    public ProductDTOO(int id, String fileName, String title, BigDecimal price, String description, String category) {
        this.id = id;
        this.fileName = fileName;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
