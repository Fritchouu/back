package com.GestionTaxe.taxe.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "`Article`")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String agent_saisie;
	
	private String agent_controle;
	
	private String date_creation;
	
	private String date_debut_impo;
	
	private double taux_prestation =   getTaux_prestation() ;

	private String num_rue;
	
	private double surf_sup;
	
	private double surf_inf;
	
	private String code_article ;
	
	private double montant_taxe = getMontant_taxe();
	
	private String arond;
	
	private String sect;
	
	private String code_commune;
	
	private  int nbr_prestation ;
	
	private double prix  =  getPrix();
	
	private String rue ;
	
	private String date_dernier_maj ;
	
	private double surface_couvert ;

	
	public Article ( ) {
		
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getAgent_saisie() {
		return agent_saisie;
	}


	public void setAgent_saisie(String agent_saisie) {
		this.agent_saisie = agent_saisie;
	}


	public String getAgent_controle() {
		return agent_controle;
	}


	public void setAgent_controle(String agent_controle) {
		this.agent_controle = agent_controle;
	}


	public String getDate_creation() {
		return date_creation;
	}


	public void setDate_creation(String date_creation) {
		this.date_creation = date_creation;
	}


	public String getDate_debut_impo() {
		return date_debut_impo;
	}


	public void setDate_debut_impo(String date_debut_impo) {
		this.date_debut_impo = date_debut_impo;
	}


	public String getNum_rue() {
		return num_rue;
	}


	public void setNum_rue(String num_rue) {
		this.num_rue = num_rue;
	}


	public double getSurf_sup() {
		return surf_sup;
	}


	public void setSurf_sup(double surf_sup) {
		this.surf_sup = surf_sup;
	}


	public double getSurf_inf() {
		return surf_inf;
	}


	public void setSurf_inf(double surf_inf) {
		this.surf_inf = surf_inf;
	}


	public String getCode_article() {
		return code_article;
	}


	public void setCode_article(String code_article) {
		this.code_article = code_article;
	}


	public double getMontant_taxe() {
		montant_taxe = getSurface_couvert() * getPrix() * 0.02 * getTaux_prestation();
		return montant_taxe;
	}


	public void setMontant_taxe(double montant_taxe) {
		this.montant_taxe = montant_taxe;
	}


	public String getArond() {
		return arond;
	}


	public void setArond(String arond) {
		this.arond = arond;
	}


	public String getSect() {
		return sect;
	}


	public void setSect(String sect) {
		this.sect = sect;
	}


	public String getCode_commune() {
		return code_commune;
	}


	public void setCode_commune(String code_commune) {
		this.code_commune = code_commune;
	}


	public int getNbr_prestation() {
		return nbr_prestation;
	}


	public void setNbr_prestation(int nbr_prestation) {
		this.nbr_prestation = nbr_prestation;
	}


	public double getPrix() {
		if (getSurf_inf() == 0 && getSurf_sup() == 100 ){
			prix = 150;			
		}else if (getSurf_inf() == 100 && getSurf_sup() == 200 ){
			prix = 200;
		}else if (getSurf_inf() == 200 && getSurf_sup() == 400 ){
			prix = 250;
		}else if (getSurf_inf() == 400 && getSurf_sup() == 10000){
			prix = 300;
		}
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getDate_dernier_maj() {
		return date_dernier_maj;
	}


	public void setDate_dernier_maj(String date_dernier_maj) {
		this.date_dernier_maj = date_dernier_maj;
	}


	public double getSurface_couvert() {
		return surface_couvert;
	}


	public void setSurface_couvert(double surface_couvert) {
		this.surface_couvert = surface_couvert;
	}


	public double getTaux_prestation() {
		
		if (getNbr_prestation() == 1 || getNbr_prestation() == 2 ){
			taux_prestation = 0.08;			
		}else if (getNbr_prestation() == 3 || getNbr_prestation() == 4){
			taux_prestation = 0.1;
		}else if (getNbr_prestation() == 5 || getNbr_prestation() == 6){
			taux_prestation = 0.12;
		}else if (getNbr_prestation() > 6){
			taux_prestation = 0.14;
		}
		return taux_prestation;
	}


	public void setTaux_prestation(double taux_prestation) {
		this.taux_prestation = taux_prestation;
	}

	
	

}
