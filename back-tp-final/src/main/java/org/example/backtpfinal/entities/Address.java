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
@Builder
public class Address  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private String street;
    private String complement;
    private String zipCode;
    private String town;
    private String country;
  /*  @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employeesList;
*/
  @OneToOne(mappedBy = "address") // One-to-One relationship with Employee
  private Employee employee;
    public Address() {
    }

    public AddressDTO toDTO(){
        return new AddressDTO(id,number,street,complement,zipCode,town,country);
    }
}
