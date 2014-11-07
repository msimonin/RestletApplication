package org.inria.restlet.example.main;

import org.inria.restlet.example.resources.MaResource;
import org.restlet.Component;
import org.restlet.data.Protocol;

/**
 * Main RESTlet minimal example
 * 
 * @author msimonin
 */
public final class Main 
{    
    
    /** Hide constructor. */
    private Main()
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Main method.
     * 
     * @param args  The arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception 
    {
        // Create a component
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8124);
        
        // Then attach it to the local host
        component.getDefaultHost().attach("/maressource", MaResource.class);
        
        // Start the component
        component.start();
    }

}
