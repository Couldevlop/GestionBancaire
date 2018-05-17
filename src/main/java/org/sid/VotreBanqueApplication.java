package org.sid;

import org.sid.DAO.ClientRepository;
import org.sid.DAO.CompteRepository;
import org.sid.DAO.OperationRepository;
import org.sid.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Date;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner{

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private OperationRepository operationRepository;
	public static void main(String[] args) {
		SpringApplication.run(VotreBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
    Client C1 =clientRepository.save(new Client("Thomas Coulibaly","coulwao@gmail.com"));
	Client C2=clientRepository.save(new Client("Touré JAFFAR","tjaffar@gmail.com"));
	Client C3=	clientRepository.save(new Client("Jean-Christ Coulibaly","jchrist@hotmail.com"));
	Client C4=	clientRepository.save(new Client("Irié-bi Antoine","ctonio@gmail.com"));


	//---------------CREATION DE COMPTES------------------------

		Compte cp1=compteRepository.save(new CompteCourant("C1", new Date(), 90000, C1,20000));
		Compte cp2=compteRepository.save(new CompteEpargne("C2", new Date(), 100000, C2,5.5));
		Compte cp3=compteRepository.save(new CompteCourant("C3", new Date(), 80000, C3,10000));
		Compte cp4=compteRepository.save(new CompteEpargne("C4", new Date(), 120000, C1,4.6));

		//--------------------CREATION D'OPERATIONS---------------

		operationRepository.save(new Versement(new Date(), 20000, cp1));
		operationRepository.save(new Versement(new Date(), 60000, cp1));
		operationRepository.save(new Versement(new Date(), 23000, cp1));
		operationRepository.save(new Retrait(new Date(), 40000, cp1));

		operationRepository.save(new Versement(new Date(), 60000, cp2));
		operationRepository.save(new Versement(new Date(), 30000, cp2));
		operationRepository.save(new Versement(new Date(), 2000, cp2));
		operationRepository.save(new Retrait(new Date(), 80000, cp2));
	}
}
