package org.inria.myriads.restlet.resource;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
    
    /** Headers.*/
    private Map<String, String> headers_;
    
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
        headers_ = new HashMap<String, String>();
    }
    
    
    /**
     * Sets the headers.
     */
    protected void setHeaders()
    {
        @SuppressWarnings("unchecked")
        Series<Header> responseHeaders = (Series<Header>) getResponse().getAttributes().get("org.restlet.http.headers");
        if (responseHeaders == null) 
        {
            responseHeaders = new Series<Header>(Header.class);
            getResponse().getAttributes().put("org.restlet.http.headers", responseHeaders);
        }
        for (Entry<String, String>  header: headers_.entrySet())
        {
            //responseHeaders.add(new Header(header.getKey(), "application/vnd.grid5000.item+json"));
            responseHeaders.add(new Header(header.getKey(), header.getValue()));
        }  
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


    /**
     * @return the headers
     */
    public Map<String, String> getHeaders() 
    {
        return headers_;
    }


    /**
     * @param headers the headers to set
     */
    public void setHeaders(Map<String, String> headers) 
    {
        headers_ = headers;
    }
}
