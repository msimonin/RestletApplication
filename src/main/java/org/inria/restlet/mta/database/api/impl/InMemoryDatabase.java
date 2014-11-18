package org.inria.restlet.mta.database.api.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.inria.restlet.mta.database.api.Database;
import org.inria.restlet.mta.internals.Tweet;
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
    
    /** Tweets par utilisateur.*/
    Map<Integer, List<Tweet>> userTweets_;
    
    public InMemoryDatabase() 
    {
        users_ = new HashMap<Integer, User>();
        userTweets_ = new HashMap<Integer, List<Tweet>>();
    }


    /**
     * On protège la variable userCount.
     * 
     */
    @Override
    public synchronized User createUser(String name, int age) 
    {
        User user = new User(name, age);
        user.setId(userCount_);
        users_.put(userCount_, user);
        // initialisation des tweets.
        userTweets_.put(userCount_, new ArrayList<Tweet>());
        userCount_ ++;
        
        return user;
    }


    @Override
    public synchronized Collection<User> getUsers() 
    {
        return users_.values();
    }


    @Override
    public synchronized User getUser(int userId) 
    {               
        return users_.get(userId);
    }


    @Override
    public synchronized List<Tweet> getUserTweets(int userId) 
    {
        return userTweets_.get(userId);
    }


    @Override
    public synchronized Tweet createUserTweet(int userId, String message) 
    {
        List<Tweet> tweets = userTweets_.get(userId);
        Tweet tweet = new Tweet(tweets.size(), message, userId);
        tweets.add(tweet);
        return tweet;
    }
    
}
