package com.ghulam.store.models;

import com.ghulam.store.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_customer")
public class Customer implements Serializable {

    @Id
    @Column(name = "customer_id", nullable = false, unique = true)
    private String customerId;

    @Column(name = "firstName", nullable = true)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "customer_roles", joinColumns = @JoinColumn(name = "customer_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @Column(name = "contact_no", nullable = false)
    private String contactNo;
}