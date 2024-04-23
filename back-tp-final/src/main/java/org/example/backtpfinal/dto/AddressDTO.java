package org.example.backtpfinal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {
    private int number;
    private String street;
    private String complement;
    private String zipCode;
    private String town;
    private String country;
}
