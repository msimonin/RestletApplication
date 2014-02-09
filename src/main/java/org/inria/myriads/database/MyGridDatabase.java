package org.inria.myriads.database;

import java.util.ArrayList;
import java.util.Iterator;

import org.inria.myriads.cluster.Cluster;
import org.inria.myriads.exception.AlreadyDefinedClusterException;
import org.inria.myriads.exception.ClusterNotFoundException;
import org.inria.myriads.grid.Grid;

/**
 * 
 * In memory database.
 * 
 * 
 * @author msimonin
 *
 */
public class MyGridDatabase 
{

    /** Grid.*/
    private Grid grid_;
    
    /**
     * Constructor.
     * 
     * Prepopulated with 2 clusters.
     */
    public MyGridDatabase() 
    {
        grid_ = new Grid();
        grid_.setName("MyGrid");
        Cluster cluster1 = new Cluster();
        cluster1.setUid("cluster1");
        Cluster cluster2 = new Cluster();
        cluster2.setUid("cluster2");
        grid_.addCluster(cluster1);
        grid_.addCluster(cluster2);
    }

    /**
     * @return the grid
     */
    public Grid getGrid() 
    {
        return grid_;
    }

    /**
     * @param grid the grid to set
     */
    public void setGrid(Grid grid) 
    {
        grid_ = grid;
    }

    /**
     * 
     * Gets the clusters.
     * 
     * @return the cluster list.
     */
    public ArrayList<Cluster> getClusters() 
    {
        return grid_.getClusters();
    }

    /**
     * 
     * Creates a new cluster.
     * 
     * @param name           The cluster
     * @return                  The newly created clusters
     * @throws AlreadyDefinedClusterException   Exception.
     */
    public Cluster createCluster(String name) throws AlreadyDefinedClusterException 
    {
        ArrayList<Cluster> clusters = grid_.getClusters();
        for (Cluster registeredCluster : clusters)
        {
            if (name.equals(registeredCluster.getUid()))
            {
                throw new AlreadyDefinedClusterException();
            }
        }
        Cluster cluster = new Cluster();
        cluster.setUid(name);
        clusters.add(cluster);
        return cluster;
    }

    /**
     * @param clusterId The cluster id to search.
     * @return  The cluster if found.
     * @throws ClusterNotFoundException Exception
     */
    public Cluster getCluster(String clusterId) throws ClusterNotFoundException 
    {
        ArrayList<Cluster> clusters = grid_.getClusters();
        for (Cluster cluster : clusters)
        {
            if (cluster.getUid().equals(clusterId))
            {
                return cluster;
            }
        }
        throw new ClusterNotFoundException();
    }

    /**
     * 
     * Delete a cluster.
     * 
     * @param clusterId     The cluster to delete
     * @throws ClusterNotFoundException The exception
     */
    public void deleteCluster(String clusterId) throws ClusterNotFoundException
    {
        Iterator<Cluster> it = grid_.getClusters().iterator();
        while (it.hasNext())
        {
           Cluster cluster = (Cluster) it.next();
           if (cluster.getUid().equals(clusterId))
           {
               it.remove();
               return;
           }
        }
        throw new ClusterNotFoundException();
    }
    
    
}
