package org.inria.restlet.mta.resources;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.User;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;

/**
 * 
 * Resource exposant un utilisateur.
 * 
 * @author msimonin
 *
 */
public class UserResource extends ServerResource 
{

    /** Backend.*/
    private Backend backend_;

    /** Utilisateur géré par cette resource.*/
    private User user_;
    
    /**
     * Constructor.
     * Call for every single user request.
     */
    public UserResource() 
    {
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    @Override
    protected void doInit() throws ResourceException 
    {
        // On récupère l'id passée dans l'URL
        int userId = (Integer) getRequest().getAttributes().get("userId");
        // On récupère l'utilisateur depuis la base de donnée
        // user_ = backend_.getDatabase().getUser(userId); 
    }
    
    
    
}
