package org.example.backtpfinal.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private UUID id;
    private int number;
    private String street;
    private String complement;
    private String postalCode;
    private String town;
    private String country;
    @OneToMany(mappedBy = "adress", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Salarie> salarieList;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
