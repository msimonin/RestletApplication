package org.inria.myriads.rest.resource.cluster;

import java.io.Serializable;

import org.inria.myriads.cluster.Cluster;
import org.inria.myriads.rest.resource.RESTfulItem;
import org.restlet.data.Reference;

/**
 * @author msimonin
 *
 */
public class RESTfulCreateClusterResponse extends RESTfulItem implements Serializable
{

    /** Default serial id.*/
    private static final long serialVersionUID = 1L;
    
    /** uuid. */
    private String uuid_;
    
    /** message.*/
    private String message_;
   
    /**
     * @param cluster       The cluster response.
     * @param reference     Base reference of the request.
     */
    public RESTfulCreateClusterResponse(Cluster cluster, Reference reference) 
    {
        super();
        uuid_ = cluster.getUid();
        this.addLink(reference.getPath() + "/" + uuid_,
                "self",
                "application/vnd.grid5000.item+json",
                "self");
        this.addLink(reference.getPath(),
                "parent", 
                "application/vnd.grid5000.collection+json",
                "parent");
    }

    /**
     * Constructor.
     */
    public RESTfulCreateClusterResponse() 
    {
        super();
    }

    /**
     * @return the uuid
     */
    public String getUuid() 
    {
        return uuid_;
    }

    /**
     * @param uuid the uuid to set
     */
    public void setUuid(String uuid) 
    {
        uuid_ = uuid;
    }

    /**
     * @return the message
     */
    public String getMessage() 
    {
        return message_;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) 
    {
        message_ = message;
    }
    
    
}
