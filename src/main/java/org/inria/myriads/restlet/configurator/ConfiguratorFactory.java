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
package org.inria.myriads.restlet.configurator;

import java.io.IOException;

import org.inria.myriads.restlet.configurator.api.Configurator;
import org.inria.myriads.restlet.configurator.api.impl.JavaPropertyConfigurator;
import org.inria.myriads.restlet.configurator.exception.ConfiguratorException;

/**
 * Node configurator factory.
 * 
 * @author Matthieu Simonin
 */
public final class ConfiguratorFactory 
{
    /** Hide constructor. */
    private ConfiguratorFactory()
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Creates a new node configurator.
     * 
     * @param configurationFile             The configuration file
     * @return                              The node configurator
     * @throws ConfiguratorException    The node configuration exception
     * @throws IOException                  The I/O exception
     */
    public static Configurator newNodeConfigurator(String configurationFile) 
        throws ConfiguratorException, IOException
    {
        return new JavaPropertyConfigurator(configurationFile);
    } 
}
