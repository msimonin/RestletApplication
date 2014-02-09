package org.inria.myriads.restlet.resource;

import org.inria.myriads.restlet.backend.Backend;
import org.restlet.engine.header.Header;
import org.restlet.resource.ServerResource;
import org.restlet.util.Series;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author msimonin
 *
 */
public class CommonServerResource extends ServerResource 
{
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(CommonServerResource.class);
    
    
    /** Backend. */
    private Backend backend_;
    
    /**
     * Constructor.
     */
    public CommonServerResource() 
    {
        super();
        log_.debug("Starting the root resource");
        backend_ = (Backend) getApplication().getContext().getAttributes().get("backend");
    }
    
    /**
     * Sets the item header.
     */
    protected void setHeadersItem()
    {
        @SuppressWarnings("unchecked")
        Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers");
        if (responseHeaders == null) 
        {
            responseHeaders = new Series<Header>(Header.class);
            getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
        }
        responseHeaders.add(new Header("Content-Type", "application/vnd.grid5000.item+json"));   
    }
    
    /**
     * Sets the collection header.
     */
    @SuppressWarnings("unchecked")
    protected void setHeadersCollection()
    {
        Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers");
        if (responseHeaders == null) 
        {
            responseHeaders = new Series<Header>(Header.class);
            getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
        }
        responseHeaders.add(new Header("Content-Type", "application/vnd.grid5000.collection+json"));   
    }
    
    /**
     * 
     * Set allow header.
     * 
     * @param allow allow header to set
     */
    @SuppressWarnings("unchecked")
    protected void setHeadersAllow(String allow)
    {
        Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers");
        if (responseHeaders == null) 
        {
            responseHeaders = new Series<Header>(Header.class);
            getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
        }
        responseHeaders.add(new Header("Allow", allow));
    }
    /**
     * 
     * Gets the backend.
     * 
     * @return the backend.
     */
    protected Backend getBackend()
    {
        return backend_;
    }
}
