package org.inria.myriads.grid;

import java.io.Serializable;
import java.util.ArrayList;

import org.inria.myriads.cluster.Cluster;

/**
 * 
 * Grid.
 * 
 * @author msimonin
 *
 */
public class Grid implements Serializable 
{

    /** serial id.*/
    private static final long serialVersionUID = 1L;
    
    /** Name.*/
    private String name_;
    
    /** clusters.*/
    private ArrayList<Cluster> clusters_;

    
    
    /**
     * Constructor.
     */
    public Grid() 
    {
        super();
        clusters_ = new ArrayList<Cluster>();
    }

    /**
     * @return the name
     */
    public String getName() 
    {
        return name_;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) 
    {
        name_ = name;
    }

    /**
     * @param cluster cluster to add.
     */
    public void addCluster(Cluster cluster)
    {
        clusters_.add(cluster);
    }

    /**
     * @return the clusters
     */
    public ArrayList<Cluster> getClusters() 
    {
        return clusters_;
    }

    /**
     * @param clusters the clusters to set
     */
    public void setClusters(ArrayList<Cluster> clusters) 
    {
        clusters_ = clusters;
    }
    
    
    
}
