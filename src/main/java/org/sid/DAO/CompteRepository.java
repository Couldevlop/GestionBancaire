package org.sid.DAO;

import org.sid.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository  extends JpaRepository<Compte, String>{
}
