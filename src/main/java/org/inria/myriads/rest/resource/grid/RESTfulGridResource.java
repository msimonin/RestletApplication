package org.inria.myriads.rest.resource.grid;

import java.io.Serializable;

import org.inria.myriads.grid.Grid;
import org.inria.myriads.rest.resource.RESTfulItem;
import org.restlet.data.Reference;

/**
 * @author msimonin
 *
 */
public class RESTfulGridResource extends RESTfulItem implements Serializable
{

    /** Serialization id.*/
    private static final long serialVersionUID = 1L;

    /** uuid.*/
    private String uuid_;
    
    /**
     * Constructor. 
     */
    public RESTfulGridResource() 
    {   
        super();
    }
    
    /**
     * @param grid          The grid.
     * @param reference     The base ref.
     */
    public RESTfulGridResource(Grid grid, Reference reference) 
    {        
       super();
       uuid_ = grid.getName();
       addLink(
               reference.getPath() + "/clusters ",
               "clusters",
               "application/vnd.grid5000.fr+json",
               "clusters"
               );
    }
}
