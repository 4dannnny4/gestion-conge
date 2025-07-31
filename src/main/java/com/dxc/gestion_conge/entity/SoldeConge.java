package com.dxc.gestion_conge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "soldeC")
public class SoldeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private int totalAnnuel;
    private int restant;
    private int utilise ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTotalAnnuel() {
        return totalAnnuel;
    }

    public void setTotalAnnuel(int totalAnnuel) {
        this.totalAnnuel = totalAnnuel;
    }

    public int getRestant() {
        return restant;
    }

    public void setRestant(int restant) {
        this.restant = restant;
    }

    public int getUtilise() {
        return utilise;
    }

    public void setUtilise(int utilise) {
        this.utilise = utilise;
    }
}
