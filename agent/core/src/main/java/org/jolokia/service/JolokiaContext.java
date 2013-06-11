package org.jolokia.service;

import java.util.Set;

import org.jolokia.backend.MBeanServerHandler;
import org.jolokia.backend.MBeanServerHandlerImpl;
import org.jolokia.config.ConfigKey;
import org.jolokia.converter.Converters;
import org.jolokia.detector.ServerHandle;
import org.jolokia.restrictor.Restrictor;
import org.jolokia.util.LogHandler;

/**
 * The context providing access to all Jolokia internal services. This context
 * will be given through during request handling to the various methods.
 * It is also an restrictor used for access restriction handling and responsible
 * for logging aspects.
 *
 * @author roland
 * @since 09.04.13
 */
public interface JolokiaContext extends LogHandler, Restrictor {

    /**
     * Access to the {@link MBeanServerHandlerImpl} for dealing with the
     * local MBeanServers
     *
     * @return the mbean server handler
     */
    MBeanServerHandler getMBeanServerHandler();

    /**
     * Get the various converters used for converting object to and from
     * strings and/or JSON.
     *
     * @return converter holder object
     */
    Converters getConverters();

    /**
     * Access to the server handle holding the server side information
     * of the detected server.
     *
     * @return the server handle
     */
    ServerHandle getServerHandle();

    /**
     * Get a configuration value if set as configuration or the default
     * value if not
     *
     * @param pKey the configuration key to lookup
     * @return the configuration value or the default value if no configuration
     *         was given.
     */
    String getConfig(ConfigKey pKey);

    /**
     * Get all keys stored in this configuration
     */
    Set<ConfigKey> getConfigKeys();
}