package org.inria.myriads.rest.resource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * RESTfulCollection.
 * 
 * @author msimonin
 *
 */
public class RESTfulCollection extends RESTfulItem implements Serializable
{
    /** Serial id.*/
    private static final long serialVersionUID = 1L;
    
    /** total.*/
    private int total_;
    
    /** offset.*/
    private int offset_;
    
    /** items.*/
    private List<RESTfulItem> items_;

    /**
     * Constructor.
     */
    public RESTfulCollection() 
    {
        super();
        total_ = 0;
        offset_ = 0;
        items_ = new ArrayList<RESTfulItem>();
    }

    /**
     * @return the items
     */
    public List<RESTfulItem> getItems() 
    {
        return items_;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<RESTfulItem> items) 
    {
        items_ = items;
    }
    
    /**
     * @param item  The item to add.
     */
    protected void addItem(RESTfulItem item)
    {
        items_.add(item);
        total_ = items_.size();
    }

    /**
     * @return the total
     */
    public int getTotal() 
    {
        return total_;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(int total) 
    {
        total_ = total;
    }

    /**
     * @return the offset
     */
    public int getOffset() 
    {
        return offset_;
    }

    /**
     * @param offset the offset to set
     */
    public void setOffset(int offset) 
    {
        offset_ = offset;
    }
    
}
