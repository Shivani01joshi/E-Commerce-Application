package com.dto;

import java.util.Optional;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.model.Category;


public class ProductDTO {
    private Long id;
    private String name;
    private int categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;
	public Long getId() {
		return null;
	}
    public String getName() {
        return null;
    }
    public Optional<Category> getCategoryById() {
        return null;
    }
    public double getPrice() {
        return 0;
    }
    public double getWeight() {
        return 0;
    }
    public String getDescription() {
        return null;
    }
	public void setName(String name2) {
	}
    public void setId(Long id2) {
    }
    public void setCategory(Category categoryById) {
    }
    public void setPrice(double price2) {
    }
    public void setWeight(double weight2) {
    }
    public void setDescription(String description2) {
    }
    public void setCategoryId(int id2) {
    }
    public void setImageName(String imageName2) {
    }
}
