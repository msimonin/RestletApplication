package org.inria.myriads.restlet.resource;

import java.util.ArrayList;

import org.inria.myriads.rest.exception.AlreadyDefinedClusterException;
import org.inria.myriads.rest.resource.grid.RESTfulClustersResource;
import org.inria.myriads.rest.resource.grid.RESTfulCreateClusterResponse;
import org.inria.myriads.rest.resource.grid.cluster.Cluster;
import org.restlet.data.Status;
import org.restlet.resource.Get;
import org.restlet.resource.Post;


/**
 * @author msimonin
 *
 */
public class ClustersResource extends CommonServerResource
{
    /**
     * @return  The RESTfulClustersResource.
     */
    @Get
    public RESTfulClustersResource getClusters()
    {   
        setHeadersCollection();
        setHeadersAllow("GET,POST");
        ArrayList<Cluster> clusters = getBackend().getClusters();
        return new RESTfulClustersResource(clusters,  getRequest().getResourceRef());       
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
