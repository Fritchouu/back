package com.GestionTaxe.taxe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestionTaxe.taxe.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}