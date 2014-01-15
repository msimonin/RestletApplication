package org.inria.myriads.restlet.backend;

import org.inria.myriads.restlet.configurator.api.Configuration;


/**
 * 
 * Backend.
 * 
 * @author msimonin
 *
 */
public class Backend 
{    
    /** Image repository settings. */
    private Configuration configuration_;
    
    /**
     * 
     * Constructor.
     * 
     * @param imageServiceConfiguration     Configuration.
     */
    public Backend(Configuration imageServiceConfiguration) 
    {
        configuration_ = imageServiceConfiguration;

    }

    public String hello() 
    {
        return "hello";
    }

}
