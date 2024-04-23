package org.example.backtpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.backtpfinal.entities.Address;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private long id;
    private int number;
    private String street;
    private String complement;
    private String zipCode;
    private String town;
    private String country;

    public Address toEntity(){
        return Address.builder()
                .id(id)
                .number(number)
                .street(street)
                .complement(complement)
                .zipCode(zipCode)
                .town(town)
                .country(country)
                .build();
    }
}
