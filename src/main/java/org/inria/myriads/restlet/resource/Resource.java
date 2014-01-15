package org.inria.myriads.restlet.resource;

import org.inria.myriads.restlet.Main;
import org.inria.myriads.restlet.backend.Backend;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Resource extends ServerResource 
{
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(Resource.class);
    
    /** Backend. */
    private Backend backend_;
    
    
    /**
     * Constructor.
     */
    public Resource() {
        log_.debug("Starting the resource");
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }

    
    /**
     * 
     *  Get resource
     * 
     * @return string
     */
    @Get
    public String hello()
    {
        return backend_.hello();
    }
}
