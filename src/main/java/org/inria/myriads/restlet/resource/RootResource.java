package org.inria.myriads.restlet.resource;

import org.inria.myriads.grid.Grid;
import org.inria.myriads.rest.resource.grid.RESTfulGridResource;
import org.restlet.resource.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author msimonin
 *
 */
public class RootResource extends CommonServerResource
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(RootResource.class);
    
    /**
     * 
     *  Get root resource.
     * 
     * @return string
     */
    @Get
    public RESTfulGridResource root()
    {   
        setHeadersItem();
        Grid grid = getBackend().getGrid();        
        return new RESTfulGridResource(grid, getRequest().getResourceRef());
        
    }
    
    
}
