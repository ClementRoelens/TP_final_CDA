package org.example.backtpfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backtpfinal.dto.AddressDTO;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String street;
    private String complement;
    private String zipCode;
    private String town;
    private String country;
    @OneToOne(mappedBy = "address")
    private Employee employee;

    public AddressDTO toDTO() {
        return new AddressDTO(id, number, street, complement, zipCode, town, country);
    }
}
