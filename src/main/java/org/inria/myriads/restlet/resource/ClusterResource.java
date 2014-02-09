package org.inria.myriads.restlet.resource;

import org.inria.myriads.cluster.Cluster;
import org.inria.myriads.exception.ClusterNotFoundException;
import org.inria.myriads.rest.resource.cluster.RESTfulCluster;
import org.restlet.data.Status;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author msimonin
 *
 */
public class ClusterResource extends CommonServerResource 
{

    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ClusterResource.class);
        
    /**
     * Constructor.
     */
    public ClusterResource()
    {
        getHeaders().put("Content-type",
                "application/vnd.grid5000.item+json");
        getHeaders().put("Allow", "GET,DELETE");
    }
    
    /**
     * @return RESTfulCluster.
     */
    @Get
    public RESTfulCluster getCluster()
    {
        setHeaders();
        Cluster cluster = null;
        try
        {
            String clusterId = (String) getRequest().getAttributes().get("clusterId");
            cluster = getBackend().getDatabase().getCluster(clusterId);
            return new RESTfulCluster(cluster, getRequest().getResourceRef());    
        }
        catch (ClusterNotFoundException exception)
        {
            this.getResponse().setStatus(Status.CLIENT_ERROR_NOT_FOUND);
        }
        return null;
    }
    
    
    /**
     * Delete a cluster.
     */
    @Delete
    public void deleteCluster()
    {
        try
        {
            String clusterId = (String) getRequest().getAttributes().get("clusterId");
            getBackend().getDatabase().deleteCluster(clusterId);
            getResponse().setStatus(Status.SUCCESS_ACCEPTED);
            return;
        }
        catch (ClusterNotFoundException exception)
        {
            this.getResponse().setStatus(Status.CLIENT_ERROR_NOT_FOUND, exception);
        }
    }
}
