package org.inria.myriads.restlet.resource;

import java.util.ArrayList;

import org.inria.myriads.cluster.Cluster;
import org.inria.myriads.exception.AlreadyDefinedClusterException;
import org.inria.myriads.rest.resource.cluster.RESTfulClusters;
import org.inria.myriads.rest.resource.cluster.RESTfulCreateClusterResponse;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author msimonin
 *
 */
public class ClustersResource extends CommonServerResource
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ClustersResource.class);
    
    
    /**
     * Constructor.
     */
    public ClustersResource()
    {
        super();
        getHeaders().put("Content-type",
                "application/vnd.grid5000.collection+json");
        getHeaders().put("Allow", "GET,POST");
    }
    
    /**
     * @return  The RESTfulClustersResource.
     */
    @Get
    public RESTfulClusters getClusters()
    {   
        setHeaders();
        ArrayList<Cluster> clusters = getBackend().getClusters();
        log_.warn(getRequest().getResourceRef().getPath());
        log_.warn(getRequest().getResourceRef().toUri().getPath());
        return new RESTfulClusters(clusters,  getRequest().getResourceRef());       
    }
    
    /**
     * @param name  The name of the cluster.
     * @return  Response
     * @throws AlreadyDefinedClusterException 
     */
    @Post
    public RESTfulCreateClusterResponse createCluster(String name) throws AlreadyDefinedClusterException
    {
       try
       {
           setHeaders();
           Cluster cluster = getBackend().createCluster(name);
           RESTfulCreateClusterResponse response =
                   new RESTfulCreateClusterResponse(cluster, getRequest().getResourceRef());
           return response;
       }
       catch (AlreadyDefinedClusterException exception)
       {
           this.getResponse().setStatus(Status.CLIENT_ERROR_CONFLICT);
           RESTfulCreateClusterResponse response = 
                   new RESTfulCreateClusterResponse();
           response.setMessage("Cannot create, the cluster already exists");
           return response;
       }

    }
}
