package org.inria.restlet.mta.resources;

import java.util.List;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Tweet;
import org.inria.restlet.mta.internals.User;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
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
        // Note : a priori le cast ne passe pas en java6
        //int userId = (Integer) getRequest().getAttributes().get("userId");
        int userId = Integer.valueOf((String) getRequest().getAttributes().get("userId"));
        user_ = backend_.getDatabase().getUser(userId);
        if (user_ == null)
        {
            getResponse().setStatus(Status.CLIENT_ERROR_NOT_FOUND);
        }
    }
    
    @Get("json")
    public Representation getUser() throws JSONException
    {
        JSONObject userJson = new JSONObject();
        userJson.put("name", user_.getName());
        userJson.put("age", user_.getAge());
        List<Tweet> tweets = backend_.getDatabase().getUserTweets(user_.getId());
        userJson.put("tweets", tweets.size());
        return new JsonRepresentation(userJson);
    }
    
}
