/**
 * Copyright (c) 2014-2016 by the respective copyright holders.
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
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_METER_TBL_PUSH</b> version <b>1</b>.<br>
 *
 * Command Class Meter Tbl Push<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMeterTblPushV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassMeterTblPushV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_METER_TBL_PUSH
     */
    public final static int COMMAND_CLASS_KEY = 0x3E;

    /**
     * Meter Tbl Push Configuration Set Command Constant
     */
    public final static int METER_TBL_PUSH_CONFIGURATION_SET = 0x01;
    /**
     * Meter Tbl Push Configuration Get Command Constant
     */
    public final static int METER_TBL_PUSH_CONFIGURATION_GET = 0x02;
    /**
     * Meter Tbl Push Configuration Report Command Constant
     */
    public final static int METER_TBL_PUSH_CONFIGURATION_REPORT = 0x03;

    /**
     * Creates a new message with the METER_TBL_PUSH_CONFIGURATION_SET command.<br>
     *
     * Meter Tbl Push Configuration Set<br>
     *
     *
     * @param operatingStatusPushMode {@link Integer}
     * @param ps {@link Boolean}
     * @param intervalMonths {@link Integer}
     * @param intervalDays {@link Integer}
     * @param intervalHours {@link Integer}
     * @param intervalMinutes {@link Integer}
     * @param pushNodeId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterTblPushConfigurationSet(Integer operatingStatusPushMode, Boolean ps,
            Integer intervalMonths, Integer intervalDays, Integer intervalHours, Integer intervalMinutes,
            Integer pushNodeId) {
        logger.debug("Creating command message METER_TBL_PUSH_CONFIGURATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_TBL_PUSH_CONFIGURATION_SET);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= operatingStatusPushMode & 0x0F;
        valProperties1 |= ps ? 0x10 : 0;
        outputData.write(valProperties1);

        // Process 'Push Dataset'

        // Process 'Interval Months'
        outputData.write(intervalMonths);

        // Process 'Interval Days'
        outputData.write(intervalDays);

        // Process 'Interval Hours'
        outputData.write(intervalHours);

        // Process 'Interval Minutes'
        outputData.write(intervalMinutes);

        // Process 'Push Node ID'
        // Check the node number boundary
        if (pushNodeId < 1 || pushNodeId > 232) {
            logger.debug("Node number is out of bounds {}", pushNodeId);
            return null;
        }
        outputData.write(pushNodeId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_TBL_PUSH_CONFIGURATION_SET command<br>
     *
     * Meter Tbl Push Configuration Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>OPERATING_STATUS_PUSH_MODE {@link Integer}
     * <li>PS {@link Boolean}
     * <li>INTERVAL_MONTHS {@link Integer}
     * <li>INTERVAL_DAYS {@link Integer}
     * <li>INTERVAL_HOURS {@link Integer}
     * <li>INTERVAL_MINUTES {@link Integer}
     * <li>PUSH_NODE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterTblPushConfigurationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("OPERATING_STATUS_PUSH_MODE", new Integer(payload[2] & 0x0F));
        response.put("PS", new Boolean((payload[2] & 0x10) != 0));

        // Process 'Push Dataset'

        // Process 'Interval Months'
        response.put("INTERVAL_MONTHS", new Integer(payload[6]));

        // Process 'Interval Days'
        response.put("INTERVAL_DAYS", new Integer(payload[7]));

        // Process 'Interval Hours'
        response.put("INTERVAL_HOURS", new Integer(payload[8]));

        // Process 'Interval Minutes'
        response.put("INTERVAL_MINUTES", new Integer(payload[9]));

        // Process 'Push Node ID'
        response.put("PUSH_NODE_ID", new Integer(payload[10]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_TBL_PUSH_CONFIGURATION_GET command.<br>
     *
     * Meter Tbl Push Configuration Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterTblPushConfigurationGet() {
        logger.debug("Creating command message METER_TBL_PUSH_CONFIGURATION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_TBL_PUSH_CONFIGURATION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_TBL_PUSH_CONFIGURATION_GET command<br>
     *
     * Meter Tbl Push Configuration Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterTblPushConfigurationGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the METER_TBL_PUSH_CONFIGURATION_REPORT command.<br>
     *
     * Meter Tbl Push Configuration Report<br>
     *
     *
     * @param operatingStatusPushMode {@link Integer}
     * @param ps {@link Boolean}
     * @param intervalMonths {@link Integer}
     * @param intervalDays {@link Integer}
     * @param intervalHours {@link Integer}
     * @param intervalMinutes {@link Integer}
     * @param pushNodeId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getMeterTblPushConfigurationReport(Integer operatingStatusPushMode, Boolean ps,
            Integer intervalMonths, Integer intervalDays, Integer intervalHours, Integer intervalMinutes,
            Integer pushNodeId) {
        logger.debug("Creating command message METER_TBL_PUSH_CONFIGURATION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(METER_TBL_PUSH_CONFIGURATION_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= operatingStatusPushMode & 0x0F;
        valProperties1 |= ps ? 0x10 : 0;
        outputData.write(valProperties1);

        // Process 'Push Dataset'

        // Process 'Interval Months'
        outputData.write(intervalMonths);

        // Process 'Interval Days'
        outputData.write(intervalDays);

        // Process 'Interval Hours'
        outputData.write(intervalHours);

        // Process 'Interval Minutes'
        outputData.write(intervalMinutes);

        // Process 'Push Node ID'
        // Check the node number boundary
        if (pushNodeId < 1 || pushNodeId > 232) {
            logger.debug("Node number is out of bounds {}", pushNodeId);
            return null;
        }
        outputData.write(pushNodeId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the METER_TBL_PUSH_CONFIGURATION_REPORT command<br>
     *
     * Meter Tbl Push Configuration Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>OPERATING_STATUS_PUSH_MODE {@link Integer}
     * <li>PS {@link Boolean}
     * <li>INTERVAL_MONTHS {@link Integer}
     * <li>INTERVAL_DAYS {@link Integer}
     * <li>INTERVAL_HOURS {@link Integer}
     * <li>INTERVAL_MINUTES {@link Integer}
     * <li>PUSH_NODE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleMeterTblPushConfigurationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'
        response.put("OPERATING_STATUS_PUSH_MODE", new Integer(payload[2] & 0x0F));
        response.put("PS", new Boolean((payload[2] & 0x10) != 0));

        // Process 'Push Dataset'

        // Process 'Interval Months'
        response.put("INTERVAL_MONTHS", new Integer(payload[6]));

        // Process 'Interval Days'
        response.put("INTERVAL_DAYS", new Integer(payload[7]));

        // Process 'Interval Hours'
        response.put("INTERVAL_HOURS", new Integer(payload[8]));

        // Process 'Interval Minutes'
        response.put("INTERVAL_MINUTES", new Integer(payload[9]));

        // Process 'Push Node ID'
        response.put("PUSH_NODE_ID", new Integer(payload[10]));

        // Return the map of processed response data;
        return response;
    }

}
