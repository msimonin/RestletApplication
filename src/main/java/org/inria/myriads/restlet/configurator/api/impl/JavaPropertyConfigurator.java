/**
 * Copyright (C) 2010-2013 Eugen Feller, INRIA <eugen.feller@inria.fr>
 *
 * This file is part of Snooze, a scalable, autonomic, and
 * energy-aware virtual machine (VM) management framework.
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation, either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, see <http://www.gnu.org/licenses>.
 */
package org.inria.myriads.restlet.configurator.api.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

import org.inria.myriads.communication.NetworkAddress;
import org.inria.myriads.restlet.configurator.api.Configuration;
import org.inria.myriads.restlet.configurator.api.Configurator;
import org.inria.myriads.restlet.configurator.networking.NetworkingSettings;
import org.inria.myriads.restlet.exception.ConfiguratorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Node configurator.
 * 
 * @author Matthieu Simonin
 */
public final class JavaPropertyConfigurator 
    implements Configurator
{
    
    /** Define the logger. */
    private static final Logger log_ = LoggerFactory.getLogger(JavaPropertyConfigurator.class);
    
    /** NodeParams. */
    private Configuration configuration_;
        
    /** Properties. */
    private Properties properties_;
    
    /**
     * Initialize parameters.
     *  
     * @param configurationFile             The configuration file
     * @throws ConfiguratorException 
     * @throws IOException 
     */
    public JavaPropertyConfigurator(String configurationFile) 
        throws ConfiguratorException, IOException
    {
        configuration_ = new Configuration();
          
        properties_ = new Properties();    
        FileInputStream fileInput = new FileInputStream(configurationFile);
        properties_.load(fileInput); 
        
        setNetworkingSettings();
        
        fileInput.close();
    }



    @Override
    public Configuration getImageServiceConfiguration() 
    {
        return configuration_;
    }
    
    /**
     * Set the network settings.
     * 
     * @throws ConfiguratorException    The configuration exception
     * @throws UnknownHostException         The unknown host exception
     */
    private void setNetworkingSettings() 
        throws ConfiguratorException, UnknownHostException 
    {
        NetworkingSettings networkingSettings = configuration_.getNetworkingSettings();
        String listenAddress = properties_.getProperty("network.listen.address");
        if (listenAddress != null)
        {
            listenAddress = listenAddress.trim();
        } else
        {
            listenAddress = InetAddress.getLocalHost().getHostAddress();
        }
          
        int listenPort = Integer.valueOf(getProperty("network.listen.controlDataPort"));  
        NetworkAddress controlDataAddress = new NetworkAddress(listenAddress, listenPort);
        
        networkingSettings.setListenAddress(controlDataAddress);
        
    }

    
    /**
     * Returns the content of a properties.
     * 
     * @param tag                           The tag
     * @return                              The content string
     * @throws ConfiguratorException    The configuration exception
     */
    private String getProperty(String tag) 
        throws ConfiguratorException
    {
        String content = properties_.getProperty(tag);
        if (content == null) 
        {
            throw new ConfiguratorException(String.format("%s entry is missing", tag));
        }
        
        content = content.trim();
        return content;             
    }

}
