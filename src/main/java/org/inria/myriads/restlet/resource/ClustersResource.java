package org.inria.myriads.restlet.resource;

import java.util.ArrayList;

import org.inria.myriads.rest.resource.grid.RESTfulClustersResource;
import org.inria.myriads.rest.resource.grid.cluster.Cluster;
import org.restlet.resource.Get;


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
    public RESTfulClustersResource root()
    {   
        setHeadersCollection();
        ArrayList<Cluster> clusters = getBackend().getClusters();
        return new RESTfulClustersResource(clusters,  getRequest().getResourceRef());       
    }
}
