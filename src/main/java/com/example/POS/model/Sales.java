package com.example.POS.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sales {


    @Id
    @Column(name = "sales_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer salesId;

    //
    @Column(name = "order_id" , insertable = false, updatable = false)
//    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "product_id" , insertable = false, updatable = false)
    private Integer productId;


    @Column(name = "date")
    private java.sql.Timestamp date;


//        @jasonManagedReference
//    @jasonBackReference

    @ManyToOne
    @JsonIgnore // to avoid infinite recursion
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne
    @JsonIgnore // to avoid infinite recursion
    @JoinColumn(name = "order_id")
    private Order order;


}
