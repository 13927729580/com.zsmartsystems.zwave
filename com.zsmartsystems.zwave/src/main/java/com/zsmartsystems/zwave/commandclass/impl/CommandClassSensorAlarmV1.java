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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SENSOR_ALARM</b> version <b>1</b>.<br>
 *
 * Command Class Sensor Alarm<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassSensorAlarmV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassSensorAlarmV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SENSOR_ALARM
     */
    public final static int COMMAND_CLASS_KEY = 0x9C;

    /**
     * Sensor Alarm Get Command Constant
     */
    public final static int SENSOR_ALARM_GET = 0x01;
    /**
     * Sensor Alarm Report Command Constant
     */
    public final static int SENSOR_ALARM_REPORT = 0x02;
    /**
     * Sensor Alarm Supported Get Command Constant
     */
    public final static int SENSOR_ALARM_SUPPORTED_GET = 0x03;
    /**
     * Sensor Alarm Supported Report Command Constant
     */
    public final static int SENSOR_ALARM_SUPPORTED_REPORT = 0x04;

    /**
     * Creates a new message with the SENSOR_ALARM_GET command.<br>
     *
     * Sensor Alarm Get<br>
     *
     *
     * @param sensorType {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorAlarmGet(Integer sensorType) {
        logger.debug("Creating command message SENSOR_ALARM_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_ALARM_GET);

        // Process 'Sensor Type'
        outputData.write(sensorType);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_ALARM_GET command<br>
     *
     * Sensor Alarm Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SENSOR_TYPE {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorAlarmGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Sensor Type'
        switch ((int) payload[2]) {
            case 0x00:
                response.put("SENSOR_TYPE", "GENERAL_PURPOSE_ALARM");
                break;
            case 0x01:
                response.put("SENSOR_TYPE", "SMOKE_ALARM");
                break;
            case 0x02:
                response.put("SENSOR_TYPE", "CO_ALARM");
                break;
            case 0x03:
                response.put("SENSOR_TYPE", "CO2_ALARM");
                break;
            case 0x04:
                response.put("SENSOR_TYPE", "HEAT_ALARM");
                break;
            case 0x05:
                response.put("SENSOR_TYPE", "WATER_LEAK_ALARM");
                break;
            case 0xFF:
                response.put("SENSOR_TYPE", "RETURN_FIRST_ALARM_ON_SUPPORTED_LIST");
                break;
            default:
                logger.debug("");
                break;
        }

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SENSOR_ALARM_REPORT command.<br>
     *
     * Sensor Alarm Report<br>
     *
     *
     * @param sourceNodeId {@link Integer}
     * @param sensorType {@link Integer}
     * @param sensorState {@link Integer}
     * @param seconds {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorAlarmReport(Integer sourceNodeId, Integer sensorType, Integer sensorState,
            Integer seconds) {
        logger.debug("Creating command message SENSOR_ALARM_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_ALARM_REPORT);

        // Process 'Source Node ID'
        // Check the node number boundary
        if (sourceNodeId < 1 || sourceNodeId > 232) {
            logger.debug("Node number is out of bounds {}", sourceNodeId);
            return null;
        }
        outputData.write(sourceNodeId);

        // Process 'Sensor Type'
        outputData.write(sensorType);

        // Process 'Sensor State'
        outputData.write(sensorState);

        // Process 'Seconds'
        outputData.write((seconds >> 8) & 0xff);
        outputData.write(seconds & 0xff);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_ALARM_REPORT command<br>
     *
     * Sensor Alarm Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SOURCE_NODE_ID {@link Integer}
     * <li>SENSOR_TYPE {@link Integer}
     * <li>SENSOR_STATE {@link Integer}
     * <li>SECONDS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorAlarmReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Source Node ID'
        response.put("SOURCE_NODE_ID", new Integer(payload[2]));

        // Process 'Sensor Type'
        switch ((int) payload[3]) {
            case 0x00:
                response.put("SENSOR_TYPE", "GENERAL_PURPOSE_ALARM");
                break;
            case 0x01:
                response.put("SENSOR_TYPE", "SMOKE_ALARM");
                break;
            case 0x02:
                response.put("SENSOR_TYPE", "CO_ALARM");
                break;
            case 0x03:
                response.put("SENSOR_TYPE", "CO2_ALARM");
                break;
            case 0x04:
                response.put("SENSOR_TYPE", "HEAT_ALARM");
                break;
            case 0x05:
                response.put("SENSOR_TYPE", "WATER_LEAK_ALARM");
                break;
            case 0xFF:
                response.put("SENSOR_TYPE", "RETURN_FIRST_ALARM_ON_SUPPORTED_LIST");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Sensor State'
        switch ((int) payload[4]) {
            case 0x00:
                response.put("SENSOR_STATE", "NO_ALARM");
                break;
            case 0xFF:
                response.put("SENSOR_STATE", "ALARM");
                break;
            default:
                logger.debug("");
                break;
        }

        // Process 'Seconds'
        response.put("SECONDS", new Integer(payload[5] << 8 + payload[6]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SENSOR_ALARM_SUPPORTED_GET command.<br>
     *
     * Sensor Alarm Supported Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorAlarmSupportedGet() {
        logger.debug("Creating command message SENSOR_ALARM_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_ALARM_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_ALARM_SUPPORTED_GET command<br>
     *
     * Sensor Alarm Supported Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorAlarmSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SENSOR_ALARM_SUPPORTED_REPORT command.<br>
     *
     * Sensor Alarm Supported Report<br>
     *
     *
     * @param numberOfBitMasks {@link Integer}
     * @param bitMask {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getSensorAlarmSupportedReport(Integer numberOfBitMasks, byte[] bitMask) {
        logger.debug("Creating command message SENSOR_ALARM_SUPPORTED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SENSOR_ALARM_SUPPORTED_REPORT);

        // Process 'Number of Bit Masks'
        outputData.write(numberOfBitMasks);

        // Process 'Bit Mask'
        try {
            outputData.write(bitMask);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SENSOR_ALARM_SUPPORTED_REPORT command<br>
     *
     * Sensor Alarm Supported Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NUMBER_OF_BIT_MASKS {@link Integer}
     * <li>BIT_MASK {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleSensorAlarmSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Number of Bit Masks'
        response.put("NUMBER_OF_BIT_MASKS", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Bit Mask'
        int valBitMask = 0;
        int lenBitMask = payload[msgOffset - 1];
        for (int cntBitMask = 0; cntBitMask < lenBitMask; cntBitMask++) {
            valBitMask = (valBitMask << 8) + payload[msgOffset + cntBitMask];
        }
        response.put("BIT_MASK", valBitMask);
        msgOffset += lenBitMask;

        // Return the map of processed response data;
        return response;
    }

}
