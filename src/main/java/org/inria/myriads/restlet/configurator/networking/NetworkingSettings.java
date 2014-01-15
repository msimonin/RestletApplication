package org.inria.myriads.restlet.configurator.networking;

import org.inria.myriads.communication.NetworkAddress;

/**
 * 
 * Network Settings.
 * 
 * @author msimonin
 *
 */
public class NetworkingSettings 
{
   
    /** Listen parameters. */
    private NetworkAddress listenAddress_;

    
    /** Constructor. */
    public NetworkingSettings()
    {
        listenAddress_ = new NetworkAddress();

    }
    
    /**
     * Returns the listen parameters.
     * 
     * @return  The listen parameters
     */
    public NetworkAddress getListenAddress()
    {
        return listenAddress_;
    }
    
    public void setListenAddress(NetworkAddress address)
    {
        listenAddress_ = address;
    }
    

}
