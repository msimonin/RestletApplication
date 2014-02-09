package org.inria.myriads.rest.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.inria.myriads.rest.util.Link;

/**
 * @author msimonin
 *
 */
public class RESTfulItem  implements Serializable
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    /** links.*/
    private List<Link> links_;

    /**
     * Contructor. 
     */
    public RESTfulItem() 
    {
        links_ = new ArrayList<Link>();
    }

    /**
     * @return the links
     */
    public List<Link> getLinks() 
    {
        return links_;
    }

    /**
     * @param links the links to set
     */
    public void setLinks(List<Link> links) 
    {
        links_ = links;
    }

    /**
     * @param href  href of the resource
     * @param rel   relation
     * @param type  type
     * @param title title (seems optionnal)
     */
    public void addLink(String href, String rel, String type, String title)
    {
        Link link = new Link();
        link.setHref(href);
        link.setRel(rel);
        link.setType(type);
        link.setTitle(title);
        links_.add(link);
    }
}
