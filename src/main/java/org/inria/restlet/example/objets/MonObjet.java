package org.inria.restlet.example.objets;

/**
 * 
 * MonObjet.
 * Représenation Java de l'objet exposé par MaResource.
 * 
 * @author msimonin
 *
 */
public class MonObjet 
{

    /** Nom de l'objet. */
    private String nom_;
    
    /** Couleur de l'objet. */
    private String couleur_;

    public MonObjet(String nom, String couleur) 
    {
        super();
        this.nom_ = nom;
        this.couleur_ = couleur;
    }

    public String getNom() 
    {
        return nom_;
    }

    public void setNom(String nom) 
    {
        nom_ = nom;
    }

    public String getCouleur() 
    {
        return couleur_;
    }

    public void setCouleur(String couleur) 
    {
        couleur_ = couleur;
    }
    
    
    
}
