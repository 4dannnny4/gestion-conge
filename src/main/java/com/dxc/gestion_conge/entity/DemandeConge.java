package com.dxc.gestion_conge.entity;

import com.dxc.gestion_conge.enums.StatutConge;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "demandeC")
public class DemandeConge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "type_conge_id")
    private TypeConge type;

    @Enumerated(EnumType.STRING)
    private StatutConge statut ;
    private String commentaire ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public TypeConge getType() {
        return type;
    }

    public void setType(TypeConge type) {
        this.type = type;
    }

    public StatutConge getStatut() {
        return statut;
    }

    public void setStatut(StatutConge statut) {
        this.statut = statut;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }
}
