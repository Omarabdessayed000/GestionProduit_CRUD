	package com.omar.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.omar.produits.entities.Categorie;
import com.omar.produits.entities.Produit;
import com.omar.produits.service.ProduitService;
import com.omar.produits.Repository.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {
	
@Autowired
private ProduitRepository produitRepository;
@Autowired
private ProduitService produitService;

@Test
public void testCreateProduit() {
Produit prod = new Produit("PC LEGION",3200.500,new Date());
produitRepository.save(prod);

  }
@Test
public void testFindProduit()
{
Produit p = produitRepository.findById(1L).get();

System.out.println("Heeeeeeeeere we goo "+p);
}
@Test
public void testUpdateProduit()
{
Produit p = produitRepository.findById(1L).get();
p.setPrixProduit(99999.0);
produitRepository.save(p);
}
@Test
public void testDeleteProduit()
{
produitRepository.deleteById(1L);;
}
@Test
public void testListerTousProduits()
{
List<Produit> prods = produitRepository.findAll();
for (Produit p : prods)
{
System.out.println(p);
}

}
@Test
public void testFindByNomProduitContainss()
{
Page<Produit> prods = produitService.getAllProduitsParPage(0,2);
System.out.println(prods.getSize());
System.out.println(prods.getTotalElements());
System.out.println(prods.getTotalPages());
prods.getContent().forEach(p -> { System.out.println( p.toString()); });
}

@Test
public void testFindProduitByNom()
{
	List<Produit> prods = produitRepository.findByNomProduit("Razer Mouse");
	
	for( Produit p:prods)
		System.out.println("This Methode has done it's Job "+p);
}

@Test
public void testFindProduitByNomContains()
{
	List<Produit> prods = (List<Produit>) produitRepository.findByNomProduitContains("z", null);
	
	for( Produit p:prods)
		System.out.println("This Contain Methode has done it's Job "+p);
}

@Test
public void testfindByNomPrix()
{
	List<Produit> prods = produitRepository.findByNomPrix("Razer Mouse",250.5);
	
	for( Produit p:prods)
		System.out.println("This Sereach Methode has done it's Job "+p);
}

@Test
public void testfindByCategorie()
	{
		Categorie cat = new Categorie();
		cat.setIdCat(1L);
		
		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p : prods)
			{
				System.out.println("Search by Categorie"+p);
			}

	}

@Test
public void findByCategorieIdCat()
 {
	List<Produit> prods = produitRepository.findByCategorieIdCat(1L);
		for (Produit p : prods)
			{
				System.out.println("findByCategorieIdCat"+p);
			}

 }

@Test
public void testfindByOrderByNomProduitAsc()
 {
	List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		for (Produit p : prods)
          {
			System.out.println("testfindByOrderByNomProduitAsc"+p);
          }

 }

@Test
public void testTrierProduitsNomsPrix()
 {
	List<Produit> prods = produitRepository.TrierProduitsNomsPrix();
	for (Produit p : prods)
     {
		System.out.println("testTrierProduitsNomsPrix  :"+p);
     }

 }

}