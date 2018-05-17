package org.sid.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
import java.util.Collection;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {
    public Retrait() {
    }

    public Retrait(Date dateOperation, double solde, double montant, Compte compte) {
        super(dateOperation, solde, montant, compte);
    }

    public Retrait(Date dateOperation, double montant, Compte compte) {
        super(dateOperation, montant, compte);
    }
}
