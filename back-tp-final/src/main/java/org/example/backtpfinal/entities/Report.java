package org.example.backtpfinal.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class Report {
    @Id
    private UUID id;
    private int workedHoursRate;

    @ManyToOne
    @JoinColumn(name="salarie_id")
    private Salarie salarie;


    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
