package org.inria.restlet.example.resources;

import java.io.IOException;

import org.inria.restlet.example.objets.MonObjet;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.ext.xml.DomRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * 
 * @author msimonin
 *
 */
public class MaResource extends ServerResource 
{
        
    @Get("json")
    public Representation toJson() throws JSONException
    {
        // D'habitude on recupère l'object depuis un BD.
        MonObjet monObjet = new MonObjet("stylo", "bleue");
        
        // On crée un JSON
        JSONObject json = new JSONObject();
        json.put("nom", monObjet.getNom());
        json.put("couleur", monObjet.getCouleur());
        json.put("timestamp", System.currentTimeMillis());
        
        // on retourne la représentation
        return new JsonRepresentation(json);
    }
    
    @Get("xml")
    public Representation toHTML() throws IOException
    {
        // D'habitude on recupère l'object depuis un BD.
        MonObjet monObjet = new MonObjet("stylo", "bleue");
        
        DomRepresentation representation = new DomRepresentation();
        representation.setIndenting(true);
        Document doc = representation.getDocument();
        Node objet = doc.createElement("objet");
        doc.appendChild(objet);
        Node nom = doc.createElement("nom");
        nom.setTextContent(monObjet.getNom());
        objet.appendChild(nom);
        Node couleur = doc.createElement("couleur");
        couleur.setTextContent(monObjet.getCouleur());
        objet.appendChild(couleur);
        Node timestamp = doc.createElement("timestamp");
        timestamp.setTextContent(String.valueOf(System.currentTimeMillis()));
        objet.appendChild(timestamp);
        
        return representation;
    }
}
