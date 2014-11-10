package org.inria.restlet.mta.resources;


import java.util.ArrayList;
import java.util.Collection;

import org.inria.restlet.mta.backend.Backend;
import org.inria.restlet.mta.internals.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.ext.json.JsonRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 * Resource exposant les utilisateurs.
 * @author msimonin
 *
 */
public class UsersResource extends ServerResource 
{
        
    /** Backend.*/
    private Backend backend_;

    /**
     * Constructor.
     * Call for every single user request.
     */
    public UsersResource() 
    {
        super();
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    /**
     * 
     * Retourne la liste de tous les utilisateurs crée.
     * [
     *  {
     *      "id": _ 
     *      "name": _ 
     *      "href": (lien vers /users/{id})
     *  },
        {
     *      "id": _ 
     *      "name": _ 
     *      "href": (lien vers /users/{id})
     *  }
     * ]
     * 
     * @return
     * @throws JSONException
     */
    @Get("json")
    public Representation getUsers() throws JSONException 
    {
        Collection<User> users = backend_.getDatabase().getUsers();
        Collection<JSONObject> jsonUsers = new ArrayList<JSONObject>();
        
        for (User user : users)
        {
            JSONObject current = new JSONObject();
            current.put("id", user.getId());
            current.put("name", user.getName());
            current.put("url", getReference() + "/" + user.getId());
            jsonUsers.add(current);
            
        }
        JSONArray jsonArray = new JSONArray(jsonUsers);
        return new JsonRepresentation(jsonArray);
    }
    
    @Post("json")
    public Representation createUser(JsonRepresentation representation) throws Exception 
    {
        JSONObject object = representation.getJsonObject();
        String name = object.getString("name");
        int age = object.getInt("age");
        
        // Save the user.
        User user = backend_.getDatabase().createUser(name, age);
        
        // generate result.
        JSONObject resultObject = new JSONObject();
        resultObject.put("name", user.getName());
        resultObject.put("age", user.getAge());
        resultObject.put("id", user.getId());
        JsonRepresentation result = new JsonRepresentation(resultObject);
        return result;
    }
  
}
