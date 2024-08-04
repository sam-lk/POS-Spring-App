package com.pos.system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name="batch")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Batch {
    @Id
    @Column(name="batch_id", length = 80)
    private String batchId;

    @Lob
    @Column(name="barcode", nullable = false)
    private Blob barcode;

    @Column(name="batch_number")
    private Long batchNumber;

    @Column(name="created_date", columnDefinition = "DATETIME")
    private Date createdDate;

    //Creating relation with ApplicationUser.java & Batch.java
    @ManyToOne
    @JoinColumn(name="created_by")
    private ApplicationUser createdBy;

    //Creating relation with ProductHasBatch.java & Batch.java
    @OneToMany(mappedBy = "batch")
    private Set<ProductHasBatch> batchData= new HashSet<>();

    @OneToMany(mappedBy = "batch")
    private Set<OrderItem> orderItems= new HashSet<>();
}
