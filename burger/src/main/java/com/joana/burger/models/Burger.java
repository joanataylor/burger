package com.joana.burger.models;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="burgers")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 40, message="Notes must be at least 3 characters.")
    private String name;
    @NotNull
    @Size(min = 3, max = 200)
    private String restaurant;
    @NotNull
    @Size(min = 3, max = 40)
    private String notes;
    @NotNull
    @Min(value=1, message="Must be at least 1 ratings.")
    private Integer ratings;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Burger() {
    }
    public Burger(String name, String restaurant, String notes, int ratings) {
        this.name = name;
        this.restaurant = restaurant;
        this.notes = notes;
        this.ratings = ratings;
    }
    
    // other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRestaurant() {
    return this.restaurant;
  }

  public void setRestaurant(String restaurant) {
    this.restaurant = restaurant;
  }

  public String getNotes() {
    return this.notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public Integer getRatings() {
    return this.ratings;
  }

  public void setRatings(Integer ratings) {
    this.ratings = ratings;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(Date updatedAt) {
    this.updatedAt = updatedAt;
  }
  @PreUpdate
  protected void onUpdate(){
      this.updatedAt = new Date();
  }

}

