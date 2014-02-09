package org.inria.myriads.rest.util;


/**
 * 
 * Link.
 * 
 * @author msimonin
 *
 */
public class Link 
{
    /** href.*/
    private String href_;
    
    /** relationship.*/
    private String rel_;
    
    /** content type.*/
    private String type_;
    
    /** title.*/
    private String title_;

    /**
     * @return the href
     */
    public String getHref() 
    {
        return href_;
    }

    /**
     * @param href the href to set
     */
    public void setHref(String href) 
    {
        href_ = href;
    }

    /**
     * @return the rel
     */
    public String getRel() 
    {
        return rel_;
    }

    /**
     * @param rel the rel to set
     */
    public void setRel(String rel) 
    {
        rel_ = rel;
    }

    /**
     * @return the type
     */
    public String getType() 
    {
        return type_;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) 
    {
        type_ = type;
    }

    /**
     * @return the title
     */
    public String getTitle() 
    {
        return title_;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) 
    {
        title_ = title;
    }
}
