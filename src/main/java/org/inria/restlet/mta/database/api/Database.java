package org.inria.restlet.mta.database.api;

import java.util.Collection;
import java.util.List;

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

}
