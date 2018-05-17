package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends  Compte {
    private double taux;

    public CompteEpargne() {
    }

    public CompteEpargne(String code, Date dateCreation, double solde, Client clients, double taux) {
        super(code, dateCreation, solde, clients);
        this.taux = taux;
    }
}
