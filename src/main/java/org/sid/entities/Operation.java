package org.sid.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP",discriminatorType = DiscriminatorType.STRING, length = 1)
public abstract class Operation {
    @Id
    @GeneratedValue
    private Long numero;
    private Date dateOperation;
    private double solde;
    private double montant;
    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    private Compte compte;

    public Operation() {
    }

    public Operation(Date dateOperation, double solde, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.solde = solde;
        this.montant = montant;
        this.compte = compte;
    }

    public Operation(Date dateOperation, double montant, Compte compte) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setComptes(Compte compte) {
        this.compte = compte;
    }
}
