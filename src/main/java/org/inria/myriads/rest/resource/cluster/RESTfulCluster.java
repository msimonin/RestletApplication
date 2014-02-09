package org.inria.myriads.rest.resource.cluster;

import java.io.Serializable;

import org.inria.myriads.cluster.Cluster;
import org.inria.myriads.rest.resource.RESTfulItem;
import org.restlet.data.Reference;

/**
 * @author msimonin
 *
 */
public class RESTfulCluster extends RESTfulItem implements Serializable
{
       
   /** Serial id.*/
    private static final long serialVersionUID = 1L;
    
    /** uuid.*/
    private String uid_;


    /**
     * 
     * Constructor.
     * 
     * @param cluster       The cluster.
     * @param reference     The resource ref.
     */
    public RESTfulCluster(Cluster cluster, Reference reference) 
    {
        
        uid_ = cluster.getUid();
        // self link
        addLink(
                reference.getPath(), 
                "self",
                "application/vnd.grid5000.item+json",
                "self");
        
        //parent
        addLink(reference.getParentRef().getPath(), "parent", "application/vnd.grid5000.item+json", "parent");

    }


    /**
     * Constructor.
     */
    public RESTfulCluster() 
    {
        super();
    }


    /**
     * @return the uid
     */
    public String getUid() 
    {
        return uid_;
    }


    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) 
    {
        uid_ = uid;
    }

}
