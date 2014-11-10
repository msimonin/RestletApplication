package org.inria.restlet.mta.database.api.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.inria.restlet.mta.database.api.Database;
import org.inria.restlet.mta.internals.User;

/**
 * 
 * Base de donnée en mémoire.
 * 
 * @author msimonin
 *
 */
public class InMemoryDatabase implements Database 
{

    /** User count (next id to give).*/
    private int userCount_;
    
    /** User Hashmap*/
    Map<Integer, User> users_;
    
    
    public InMemoryDatabase() 
    {
        users_ = new HashMap<Integer, User>();
    }


    /**
     * Fix me !
     */
    @Override
    public User createUser(String name, int age) 
    {
        User user = new User(name, age);
        user.setId(userCount_);
        users_.put(userCount_, user);
        userCount_ ++;
        return user;
    }


    @Override
    public Collection<User> getUsers() 
    {
        return users_.values();
    }

}
