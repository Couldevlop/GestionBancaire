package org.sid.metier;

import org.sid.DAO.CompteRepository;
import org.sid.DAO.OperationRepository;
import org.sid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;


@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {
    @Autowired
    private CompteRepository compteRepository;
    @Autowired
    private OperationRepository operationRepository;


    @Override
    public Optional<Compte> consulterCompte(String code) {
        Optional<Compte> cp=compteRepository.findById(code);
        if (cp==null) throw new RuntimeException("Compte introuvable");
        return cp;
    }

    @Override
    public void Verser(String code, double montant) {
       Optional<Compte> cp=consulterCompte(code);
       if(cp.isPresent())
       {
           Compte cpte =cp.get();
           Versement V= new Versement(new Date(),montant,cpte);
           operationRepository.save(V);
           cpte.setSolde(cpte.getSolde() + montant);
           compteRepository.save(cpte);
       }

    }

    @Override
    public void Retirer(String code, double montant) {
        Optional<Compte> cp=consulterCompte(code);
        if(cp.isPresent())
        {
            Compte cpte =cp.get();

            if(cpte instanceof CompteEpargne)
            {
                if(cpte.getSolde()> montant)
                {
                    Retrait R= new Retrait(new Date(),montant,cpte);
                    operationRepository.save(R);
                    cpte.setSolde(cpte.getSolde() - montant);
                    compteRepository.save(cpte);
                }
                else
                {
                    throw new RuntimeException("Votre solde est insuffisant");
                }
            }

            else
            {
              double decouvert=0;
              decouvert =((CompteCourant) cpte).getDecouvert();
                if(cpte.getSolde() + decouvert > montant)
                {
                    Retrait R= new Retrait(new Date(),montant,cpte);
                    operationRepository.save(R);
                    cpte.setSolde(cpte.getSolde() - montant);
                    compteRepository.save(cpte);
                }
                else
                {
                    throw new RuntimeException("Votre solde est insuffisant");
                }
            }

        }
    }

    @Override
    public void Virer(String codecp1, String codecp2, double montant) {
        Retirer(codecp1,montant);
        Verser(codecp2,montant);

    }

    @Override
    public Page<Operation> listeOperation(String code, int page, int size) {
        return operationRepository.listOperation(code, new PageRequest(page,size));
    }
}
