package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Collection;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {

    public Versement() {
    }

    public Versement(Date dateOperation, double solde, double montant, Compte compte) {
        super(dateOperation, solde, montant, compte);
    }

    public Versement(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }

}


