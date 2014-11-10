package org.inria.restlet.mta.backend;

import org.inria.restlet.mta.database.api.Database;
import org.inria.restlet.mta.database.api.impl.InMemoryDatabase;

/**
 * 
 * Backend.
 * Commun à toutes les resources.
 * 
 * @author msimonin
 *
 */
public class Backend 
{
    /** Database.*/
    private Database database_;
    
    public Backend() 
    {
        database_ = new InMemoryDatabase();
    }

    public Database getDatabase() 
    {
        return database_;
    }

}
