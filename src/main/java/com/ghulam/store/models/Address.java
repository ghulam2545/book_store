package com.ghulam.store.models;

import com.ghulam.store.enums.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @Column(name = "address_id", nullable = false, unique = true)
    private String addressId;

    @Column(name = "building_number", nullable = true)
    private String buildingNumber;

    @Column(name = "street_name", nullable = false)
    private String streetName;

    @Column(name = "village", nullable = true)
    private String village;

    @Column(name = "city", nullable = false)
    private String city;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "state", nullable = false)
    private State state;

    @Column(length = 6, name = "pincode", nullable = false)
    private String pincode;
}
