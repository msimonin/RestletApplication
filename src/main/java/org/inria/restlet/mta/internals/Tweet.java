package org.inria.restlet.mta.internals;

public class Tweet 
{

    /** Id du tweet.*/
    private int id_;
    
    /** Message du tweet.*/
    private String message_;
    
    /** UserId */
    private int userId_;


    public Tweet(int id, String message, int userId)
    {
        id_ = id;
        message_ = message;
        userId_ = userId;
    }

    public int getId() {
        return id_;
    }

    public void setId(int id) 
    {
        id_ = id;
    }

    public String getMessage() 
    {
        return message_;
    }

    public void setMessage(String message) 
    {
        message_ = message;
    }

    public int getUserId() 
    {
        return userId_;
    }

    public void setUserId(int userId) 
    {
        userId_ = userId;
    }
    
    
}
