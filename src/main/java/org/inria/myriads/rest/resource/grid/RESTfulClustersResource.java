package org.inria.myriads.rest.resource.grid;

import java.util.ArrayList;

import org.inria.myriads.rest.resource.RESTfulCollection;
import org.inria.myriads.rest.resource.grid.cluster.Cluster;
import org.restlet.data.Reference;


/**
 * @author msimonin
 *
 */
public class RESTfulClustersResource extends RESTfulCollection 
{

    /**
     * 
     * Constructor.
     * 
     * @param clusters  the clusters.
     * @param reference the base ref.
     */
    public RESTfulClustersResource(ArrayList<Cluster> clusters, Reference reference) 
    {
        for (Cluster cluster : clusters)
        {
            RESTfulClusterItem item = new RESTfulClusterItem();
            item.setUuid(cluster.getUuid());
            // self link
            item.addLink(
                    reference.getPath() + "/" + cluster.getUuid(), 
                    "self",
                    "application/vnd.grid5000.item+json",
                    "self");
            
            //parent
            item.addLink(reference.getParentRef().getPath(), "parent", "application/vnd.grid5000.item+json", "parent");
            addItem(item);
            
        }
        this.addLink(reference.getPath(),
                "self",
                "application/vnd.grid5000.collection+json",
                "clusters");
    }

}
