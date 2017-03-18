/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_APPLICATION_STATUS</b> version <b>1</b>.<br>
 * <p>
 * Command Class Application Status<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassApplicationStatusV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassApplicationStatusV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_APPLICATION_STATUS
     */
    public final static int COMMAND_CLASS_KEY = 0x22;

    /**
     * Application Busy Command Constant
     */
    public final static int APPLICATION_BUSY = 0x01;
    /**
     * Application Rejected Request Command Constant
     */
    public final static int APPLICATION_REJECTED_REQUEST = 0x02;

    // Constants for Status
    private static Map<Integer, String> constantStatus = new HashMap<Integer, String>();

    static {
        // Constants for Status
        constantStatus.put(0x00, "TRY_AGAIN_LATER");
        constantStatus.put(0x01, "TRY_AGAIN_IN_WAIT_TIME_SECONDS");
        constantStatus.put(0x02, "REQUEST_QUEUED,_EXECUTED_LATER");
    }

    /**
     * Creates a new message with the APPLICATION_BUSY command.<br>
     * <p>
     * Application Busy<br>
     *
     * @param status {@link String}
     * @param waitTime {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getApplicationBusy(String status, Integer waitTime) {
        logger.debug("Creating command message APPLICATION_BUSY version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(APPLICATION_BUSY);

        // Process 'Status'
        for (Integer entry : constantStatus.keySet()) {
            if (constantStatus.get(entry).equals(status)) {
                outputData.write(entry);
                break;
            }
        }

        // Process 'Wait Time'
        outputData.write(waitTime);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the APPLICATION_BUSY command<br>
     * <p>
     * Application Busy<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>STATUS {@link String}
     * <li>WAIT_TIME {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleApplicationBusy(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Status'
        response.put("STATUS", constantStatus.get(payload[2] & 0xff));

        // Process 'Wait Time'
        response.put("WAIT_TIME", Integer.valueOf(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the APPLICATION_REJECTED_REQUEST command.<br>
     * <p>
     * Application Rejected Request<br>
     *
     * @param status {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getApplicationRejectedRequest(Integer status) {
        logger.debug("Creating command message APPLICATION_REJECTED_REQUEST version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(APPLICATION_REJECTED_REQUEST);

        // Process 'Status'
        outputData.write(status);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the APPLICATION_REJECTED_REQUEST command<br>
     * <p>
     * Application Rejected Request<br>
     * <p>
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>STATUS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleApplicationRejectedRequest(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Status'
        response.put("STATUS", Integer.valueOf(payload[2]));

        // Return the map of processed response data;
        return response;
    }

}
