package com.omar.produits;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.omar.produits.entities.Produit;
import com.omar.produits.service.ProduitService;

@SpringBootApplication
public class ProduitsApplication implements CommandLineRunner {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	
	@Autowired
	ProduitService produitService;
	public static void main(String[] args) {
		SpringApplication.run(ProduitsApplication.class, args);
	}

	@Override	
	public void run(String... args) throws Exception {
		/*produitService.saveProduit(new Produit("Razer Mouse",250.500,new Date()));
		produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
		produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
		produitService.saveProduit(new Produit("Imp Epson", 900.0, new Date()));
		produitService.saveProduit(new Produit("Canon E60S", 1700.50, new Date()));*/
		repositoryRestConfiguration.exposeIdsFor(Produit.class);
	}

}
