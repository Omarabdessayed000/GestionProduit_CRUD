package com.omar.produits.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omar.produits.entities.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

}