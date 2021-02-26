package com.GestionTaxe.taxe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GestionTaxe.taxe.model.Article;
import com.GestionTaxe.taxe.repository.ArticleRepository;

import com.GestionTaxe.taxe.message.exception.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/auth")
public class ArticleController {
	@Autowired
	private ArticleRepository ArticleRepository;
	
	@GetMapping("/Article")
	public List<Article> getAllArtcile() {
		
		return ArticleRepository.findAll();
	}
		
	@GetMapping("/Article/{id}")
	public ResponseEntity<Article> getArticleById(@PathVariable(value = "id") Long ArticleId)
			throws ResourceNotFoundException {
		Article Article = ArticleRepository.findById(ArticleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + ArticleId));
		return ResponseEntity.ok().body(Article);
	}

	@PostMapping("/Article")
	public Article createArticle(@Valid @RequestBody Article Article) {	
		Article.setTaux_prestation(Article.getTaux_prestation());
		Article.setPrix(Article.getPrix());
		Article.setMontant_taxe(Article.getMontant_taxe());
		return ArticleRepository.save(Article);
	}

	@PutMapping("/Article/{id}")
	public ResponseEntity<Article> updateArticle(@PathVariable(value = "id") Long ArticleId,
			@Valid @RequestBody Article ArticleDetails) throws ResourceNotFoundException {
		Article Article = ArticleRepository.findById(ArticleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + ArticleId));	 
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date(); 
	    
		Article.setDate_creation(ArticleDetails.getDate_creation());
		
		Article.setAgent_controle(ArticleDetails.getAgent_controle());
		
		Article.setDate_debut_impo(ArticleDetails.getDate_debut_impo());
		
		
		
		Article.setNum_rue(ArticleDetails.getNum_rue());
		
		Article.setSurf_inf(ArticleDetails.getSurf_inf());
		
		Article.setSurf_sup(ArticleDetails.getSurf_sup());
	   
	    
	    Article.setNbr_prestation(ArticleDetails.getNbr_prestation());
	    
	    Article.setMontant_taxe(ArticleDetails.getMontant_taxe());
	    
	    Article.setSurface_couvert(ArticleDetails.getSurface_couvert());
	    
	    Article.setDate_creation(ArticleDetails.getDate_creation());
	    
	    Article.setDate_dernier_maj(formatter.format(date));
	    
	    Article.setPrix(ArticleDetails.getPrix());
	    
	    
		final Article updatedArticle = ArticleRepository.save(Article);
		return ResponseEntity.ok(updatedArticle);
	}

	@DeleteMapping("/Article/{id}")
	public Map<String, Boolean> deleteArticle(@PathVariable(value = "id") Long ArticleId)
			throws ResourceNotFoundException {
		Article Article = ArticleRepository.findById(ArticleId)
				.orElseThrow(() -> new ResourceNotFoundException("Article not found for this id :: " + ArticleId));

		ArticleRepository.delete(Article);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

	

}
