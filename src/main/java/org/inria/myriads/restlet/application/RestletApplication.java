package org.inria.myriads.restlet.application;


import org.inria.myriads.restlet.resource.Resource;
import org.restlet.Application;
import org.restlet.Context;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 * 
 * Image service application.
 * 
 * @author msimonin
 *
 */
public class RestletApplication extends Application 
{

    /**
     * 
     * Constructor.
     * 
     * @param context   the context.
     */
    public RestletApplication(Context context) 
    {
        super(context);
    }
    
    /**
     * Creates the root restlet.
     * 
     * @return  The restlet router
     */
    public Restlet createInboundRoot() 
    {  
         Router router = new Router(getContext());  
         router.attach("/", Resource.class);
         return router;  
    }

}
