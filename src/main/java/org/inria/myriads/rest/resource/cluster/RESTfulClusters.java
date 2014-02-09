package org.inria.myriads.rest.resource.cluster;

import java.util.ArrayList;

import org.inria.myriads.cluster.Cluster;
import org.inria.myriads.rest.resource.RESTfulCollection;
import org.inria.myriads.restlet.resource.ClustersResource;
import org.restlet.data.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author msimonin
 *
 */
public class RESTfulClusters extends RESTfulCollection 
{
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(ClustersResource.class);
    
    /**
     * 
     * Constructor.
     * 
     * @param clusters  the clusters.
     * @param reference the base ref.
     */
    public RESTfulClusters(ArrayList<Cluster> clusters, Reference reference) 
    {
        for (Cluster cluster : clusters)
        {
            Reference clusterReference = new Reference(reference);
            clusterReference.addSegment(cluster.getUid());
            RESTfulCluster item = new RESTfulCluster(cluster, clusterReference);
            addItem(item);
            
        }
        this.addLink(reference.getPath(),
                "self",
                "application/vnd.grid5000.collection+json",
                "clusters");
    }

}
