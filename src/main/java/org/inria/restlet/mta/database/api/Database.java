package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

import org.inria.restlet.mta.internals.Tweet;
import org.inria.restlet.mta.internals.User;

/**
 * 
 * Interface d'accès à la base de donnée.
 * 
 * @author msimonin
 *
 */
public interface Database 
{

    /**
     * 
     * Crée un nouvel utilisateur dans la base de donnée.
     * 
     * @param name      Le nom de l'utilisateur
     * @param age       L'âge de l'utilisateur
     * @return  Le nouvel utilisateur.
     */
    User createUser(String name, int age);
    
    
    /**
     * 
     * Retourne la liste des utilisateurs.
     * 
     * @return l'ensemble des utilisateurs 
     */
    Collection<User> getUsers();


    /**
     * 
     * Retourne un utilisateur
     *      
     * @param userId    l'id de l'utilisateur
     * @return L'utilisateur ssi il existe, null sinon
     */
    User getUser(int userId);


    /**
     * 
     * Retourne les tweets d'un utilisateur (supposé existant)
     * 
     * @param userId    L'id de l'utilisateur
     * @return  une list de tweet.
     */
    List<Tweet> getUserTweets(int userId);


    /**
     * 
     * Créé un tweet pour un utiilisateur donné.
     * 
     * @param userId    Id de l'utilisateur
     * @param message   Le message
     * @return le tweet 
     */
    Tweet createUserTweet(int userId, String message);

}
