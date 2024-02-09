package com.ghulam.store.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_cart")
public class Cart implements Serializable {

    @Id
    private String cartId;

    @ElementCollection
    @CollectionTable(name = "cart_items", joinColumns = @JoinColumn(name = "cart_id"))
    @MapKeyJoinColumn(name = "book_id")
    @Column(name = "quantity")
    private Map<Book, Integer> books = new HashMap<>();

    @Column(name = "grand_total")
    private long grandTotal;

}
