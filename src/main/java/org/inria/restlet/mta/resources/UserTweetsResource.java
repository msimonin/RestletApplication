package org.inria.restlet.mta.resources;

import java.util.List;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.Tweet;
import org.inria.restlet.mta.internals.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.data.Status;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ResourceException;
import org.restlet.resource.ServerResource;


public class UserTweetsResource extends ServerResource 
{
    /** Backend.*/
    private Backend backend_;

    /** Utilisateur géré par cette resource.*/
    private User user_;
    
    /**
     * Constructor.
     * Call for every single user request.
     */
    public UserTweetsResource() 
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
    
    /**
     * Représentation des tweets d'un utilisateur
     * 
     * @return un json array représentant les tweets d'un utilisateur.
     * @throws JSONException 
     */
    @Get("json")
    public Representation toJson() throws JSONException
    {
        JSONArray jsonTweets = new JSONArray();
        List<Tweet> tweets = backend_.getDatabase().getUserTweets(user_.getId());
        
        for (Tweet tweet : tweets)
        {
            JSONObject jsonTweet = new JSONObject();
            jsonTweet.put("id", tweet.getId());
            jsonTweet.put("message", tweet.getMessage());
            jsonTweets.put(jsonTweet);
        }
        
        return new JsonRepresentation(jsonTweets);
    }
 
    @Post("json")
    public Representation createTweet(JsonRepresentation representation) throws JSONException
    {
        JSONObject object = representation.getJsonObject();
        String message = object.getString("message");
        int userId = user_.getId();
        
        Tweet tweet = backend_.getDatabase().createUserTweet(userId, message);
        if (tweet == null)
        {
            // no content
            return null;
        }
        
        JSONObject jsonTweet = new JSONObject();
        jsonTweet.put("id", tweet.getId());
        jsonTweet.put("message", tweet.getMessage());
        jsonTweet.put("userId", tweet.getUserId());
        
        return new JsonRepresentation(jsonTweet);
    }
    
}
