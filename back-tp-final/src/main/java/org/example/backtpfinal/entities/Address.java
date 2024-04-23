package org.example.backtpfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backtpfinal.dto.AddressDTO;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private String street;
    private String complement;
    private String zipCode;
    private String town;
    private String country;

    @OneToMany(mappedBy = "address")
    private List<Employee> employeesList;

    public AddressDTO toDTO(){
        return new AddressDTO(id,number,street,complement,zipCode,town,country);
    }
}
