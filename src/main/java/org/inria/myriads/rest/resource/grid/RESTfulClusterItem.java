package org.inria.myriads.rest.resource.grid;

import java.io.Serializable;

import org.inria.myriads.rest.resource.RESTfulItem;

/**
 * @author msimonin
 *
 */
public class RESTfulClusterItem extends RESTfulItem implements Serializable
{
       
   /** Serial id.*/
    private static final long serialVersionUID = 1L;
    
    /** uuid.*/
    private String uuid_;


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

}
