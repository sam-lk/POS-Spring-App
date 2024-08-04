package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @Column(name = "product_id", length = 80)
    private String productId;

    @Column(name="name")
    private String name;
    //description eka Blob walin save karanne, smart text area eke karana style ee akarayen save & retrive karanna
    @Lob
    @Column(name="description")
    private Blob description;
    @Column(name="price", precision = 2)
    private BigDecimal price;
    @Column(name="quantity")
    private int quantity;
    @Column(name="created_date",columnDefinition = "DATETIME")
    private Date createdDate;
    @Column(name="last_update",columnDefinition = "DATETIME")
    private Date lastUpdate;

    //Creating many-to-many relation with Product.java & ProductHasBatch.java
    @OneToMany(mappedBy = "product")
    private Set<ProductHasBatch> batchData= new HashSet<>();

    @OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems = new HashSet<>();

}
