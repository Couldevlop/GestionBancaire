package org.sid.metier;

import org.sid.entities.Compte;
import org.sid.entities.Operation;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IBanqueMetier {
   public Optional<Compte> consulterCompte(String code);
   public void Verser(String code, double montant);
   public void Retirer(String code, double montant);
   public void Virer(String codecp1, String codecp2, double montant);
   public Page<Operation> listeOperation(String code, int page, int size);
}
