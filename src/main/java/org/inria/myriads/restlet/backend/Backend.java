package org.inria.myriads.restlet.backend;

import java.util.ArrayList;

import org.inria.myriads.database.MyGridDatabase;
import org.inria.myriads.grid.Grid;
import org.inria.myriads.rest.resource.grid.cluster.Cluster;
import org.inria.myriads.restlet.configurator.api.Configuration;


/**
 * 
 * Backend.
 * 
 * @author msimonin
 *
 */
public class Backend 
{    
    /** Image repository settings. */
    private Configuration configuration_;

    /** Database.*/
    private MyGridDatabase database_;
    
    /**
     * 
     * Constructor.
     * 
     * @param imageServiceConfiguration     Configuration.
     */
    public Backend(Configuration imageServiceConfiguration) 
    {
        configuration_ = imageServiceConfiguration;
        database_ = new MyGridDatabase();
    }
    

    /**
     *
     * @return  The grid.
     */
    public Grid getGrid() 
    {
       return database_.getGrid();
    }


    /**
     * @return  The clusters.
     */
    public ArrayList<Cluster> getClusters() 
    {
        return database_.getClusters();
    }

}
