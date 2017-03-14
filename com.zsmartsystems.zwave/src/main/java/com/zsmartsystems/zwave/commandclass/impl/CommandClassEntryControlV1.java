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
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_ENTRY_CONTROL</b> version <b>1</b>.<br>
 *
 * Command Class Entry Control<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassEntryControlV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassEntryControlV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_ENTRY_CONTROL
     */
    public final static int COMMAND_CLASS_KEY = 0x6F;

    /**
     * Entry Control Notification Command Constant
     */
    public final static int ENTRY_CONTROL_NOTIFICATION = 0x01;
    /**
     * Entry Control Key Supported Get Command Constant
     */
    public final static int ENTRY_CONTROL_KEY_SUPPORTED_GET = 0x02;
    /**
     * Entry Control Key Supported Report Command Constant
     */
    public final static int ENTRY_CONTROL_KEY_SUPPORTED_REPORT = 0x03;
    /**
     * Entry Control Event Supported Get Command Constant
     */
    public final static int ENTRY_CONTROL_EVENT_SUPPORTED_GET = 0x04;
    /**
     * Entry Control Event Supported Report Command Constant
     */
    public final static int ENTRY_CONTROL_EVENT_SUPPORTED_REPORT = 0x05;
    /**
     * Entry Control Configuration Set Command Constant
     */
    public final static int ENTRY_CONTROL_CONFIGURATION_SET = 0x06;
    /**
     * Entry Control Configuration Get Command Constant
     */
    public final static int ENTRY_CONTROL_CONFIGURATION_GET = 0x07;
    /**
     * Entry Control Configuration Report Command Constant
     */
    public final static int ENTRY_CONTROL_CONFIGURATION_REPORT = 0x08;

    /**
     * Creates a new message with the ENTRY_CONTROL_NOTIFICATION command.<br>
     *
     * Entry Control Notification<br>
     *
     *
     * @param sequenceNumber {@link Integer}
     * @param dataType {@link String}
     * @param eventType {@link String}
     * @param eventDataLength {@link Integer}
     * @param eventData {@link byte[]}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlNotification(Integer sequenceNumber, String dataType, String eventType,
            Integer eventDataLength, byte[] eventData) {
        logger.debug("Creating command message ENTRY_CONTROL_NOTIFICATION version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_NOTIFICATION);

        // Process 'Sequence Number'
        outputData.write(sequenceNumber);

        // Process 'Properties1'
        int valdataType;
        switch (dataType) {
            case "NA":
                valdataType = 0;
                break;
            case "RAW":
                valdataType = 1;
                break;
            case "ASCII":
                valdataType = 2;
                break;
            case "MD5":
                valdataType = 3;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for dataType: " + dataType);
        }
        outputData.write(valdataType & 0x03);

        // Process 'Event Type'
        switch (eventType) {
            case "CACHING":
                outputData.write(0x00);
                break;
            case "CACHED_KEYS":
                outputData.write(0x01);
                break;
            case "ENTER":
                outputData.write(0x02);
                break;
            case "DISARM_ALL":
                outputData.write(0x03);
                break;
            case "ARM_ALL":
                outputData.write(0x04);
                break;
            case "ARM_AWAY":
                outputData.write(0x05);
                break;
            case "ARM_HOME":
                outputData.write(0x06);
                break;
            case "EXIT_DELAY":
                outputData.write(0x07);
                break;
            case "ARM_1":
                outputData.write(0x08);
                break;
            case "ARM_2":
                outputData.write(0x09);
                break;
            case "ARM_3":
                outputData.write(0x0A);
                break;
            case "ARM_4":
                outputData.write(0x0B);
                break;
            case "ARM_5":
                outputData.write(0x0C);
                break;
            case "ARM_6":
                outputData.write(0x0D);
                break;
            case "RFID":
                outputData.write(0x0E);
                break;
            case "BELL":
                outputData.write(0x0F);
                break;
            case "FIRE":
                outputData.write(0x10);
                break;
            case "POLICE":
                outputData.write(0x11);
                break;
            case "ALERT_PANIC":
                outputData.write(0x12);
                break;
            case "ALERT_MEDICAL":
                outputData.write(0x13);
                break;
            case "GATE_OPEN":
                outputData.write(0x14);
                break;
            case "GATE_CLOSE":
                outputData.write(0x15);
                break;
            case "LOCK":
                outputData.write(0x16);
                break;
            case "UNLOCK":
                outputData.write(0x17);
                break;
            case "TEST":
                outputData.write(0x18);
                break;
            case "CANCEL":
                outputData.write(0x19);
                break;
            default:
                throw new IllegalArgumentException("Unknown constant value for eventType: " + eventType);
        }

        // Process 'Event Data Length'
        outputData.write(eventDataLength);

        // Process 'Event Data'
        try {
            outputData.write(eventData);
        } catch (IOException e) {
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_NOTIFICATION command<br>
     *
     * Entry Control Notification<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SEQUENCE_NUMBER {@link Integer}
     * <li>DATA_TYPE {@link String}
     * <li>EVENT_TYPE {@link String}
     * <li>EVENT_DATA_LENGTH {@link Integer}
     * <li>EVENT_DATA {@link byte[]}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlNotification(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Sequence Number'
        response.put("SEQUENCE_NUMBER", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties1'
        switch ((int) payload[msgOffset] & 0x03) {
            case 0x00:
                response.put("DATA_TYPE", "NA");
                break;
            case 0x01:
                response.put("DATA_TYPE", "RAW");
                break;
            case 0x02:
                response.put("DATA_TYPE", "ASCII");
                break;
            case 0x03:
                response.put("DATA_TYPE", "MD5");
                break;
            default:
                logger.debug("Unknown enum value {} for DATA_TYPE", String.format("0x%02X", msgOffset));
        }
        msgOffset += 1;

        // Process 'Event Type'
        switch ((int) payload[msgOffset]) {
            case (byte) 0x00:
                response.put("EVENT_TYPE", "CACHING");
                break;
            case (byte) 0x01:
                response.put("EVENT_TYPE", "CACHED_KEYS");
                break;
            case (byte) 0x02:
                response.put("EVENT_TYPE", "ENTER");
                break;
            case (byte) 0x03:
                response.put("EVENT_TYPE", "DISARM_ALL");
                break;
            case (byte) 0x04:
                response.put("EVENT_TYPE", "ARM_ALL");
                break;
            case (byte) 0x05:
                response.put("EVENT_TYPE", "ARM_AWAY");
                break;
            case (byte) 0x06:
                response.put("EVENT_TYPE", "ARM_HOME");
                break;
            case (byte) 0x07:
                response.put("EVENT_TYPE", "EXIT_DELAY");
                break;
            case (byte) 0x08:
                response.put("EVENT_TYPE", "ARM_1");
                break;
            case (byte) 0x09:
                response.put("EVENT_TYPE", "ARM_2");
                break;
            case (byte) 0x0A:
                response.put("EVENT_TYPE", "ARM_3");
                break;
            case (byte) 0x0B:
                response.put("EVENT_TYPE", "ARM_4");
                break;
            case (byte) 0x0C:
                response.put("EVENT_TYPE", "ARM_5");
                break;
            case (byte) 0x0D:
                response.put("EVENT_TYPE", "ARM_6");
                break;
            case (byte) 0x0E:
                response.put("EVENT_TYPE", "RFID");
                break;
            case (byte) 0x0F:
                response.put("EVENT_TYPE", "BELL");
                break;
            case (byte) 0x10:
                response.put("EVENT_TYPE", "FIRE");
                break;
            case (byte) 0x11:
                response.put("EVENT_TYPE", "POLICE");
                break;
            case (byte) 0x12:
                response.put("EVENT_TYPE", "ALERT_PANIC");
                break;
            case (byte) 0x13:
                response.put("EVENT_TYPE", "ALERT_MEDICAL");
                break;
            case (byte) 0x14:
                response.put("EVENT_TYPE", "GATE_OPEN");
                break;
            case (byte) 0x15:
                response.put("EVENT_TYPE", "GATE_CLOSE");
                break;
            case (byte) 0x16:
                response.put("EVENT_TYPE", "LOCK");
                break;
            case (byte) 0x17:
                response.put("EVENT_TYPE", "UNLOCK");
                break;
            case (byte) 0x18:
                response.put("EVENT_TYPE", "TEST");
                break;
            case (byte) 0x19:
                response.put("EVENT_TYPE", "CANCEL");
                break;
            default:
                logger.debug("Unknown value {} for constant 'EVENT_TYPE'", String.format("%02X", payload[msgOffset]));
                response.put("EVENT_TYPE", "UNKNOWN_" + String.format("%02X", payload[msgOffset]));
                break;
        }
        msgOffset += 1;

        // Process 'Event Data Length'
        response.put("EVENT_DATA_LENGTH", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Event Data'
        int valEventData = 0;
        int lenEventData = payload[msgOffset - 1];
        for (int cntEventData = 0; cntEventData < lenEventData; cntEventData++) {
            valEventData = (valEventData << 8) + payload[msgOffset + cntEventData];
        }
        response.put("EVENT_DATA", valEventData);
        msgOffset += lenEventData;

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_KEY_SUPPORTED_GET command.<br>
     *
     * Entry Control Key Supported Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlKeySupportedGet() {
        logger.debug("Creating command message ENTRY_CONTROL_KEY_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_KEY_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_KEY_SUPPORTED_GET command<br>
     *
     * Entry Control Key Supported Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlKeySupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_KEY_SUPPORTED_REPORT command.<br>
     *
     * Entry Control Key Supported Report<br>
     *
     *
     * @param keySupportedBitMaskLength {@link Integer}
     * @param keySupportedBitMask {@link List<Integer>}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlKeySupportedReport(Integer keySupportedBitMaskLength,
            List<Integer> keySupportedBitMask) {
        logger.debug("Creating command message ENTRY_CONTROL_KEY_SUPPORTED_REPORT version 1");

        Collections.sort(keySupportedBitMask);
        int lenKeySupportedBitMask = (keySupportedBitMask.get(keySupportedBitMask.size() - 1) / 8) + 1;

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_KEY_SUPPORTED_REPORT);

        // Process 'Key Supported Bit Mask Length'
        outputData.write(keySupportedBitMaskLength);

        // Process 'Key Supported Bit Mask'
        int valKeySupportedBitMask = 0;
        for (int cntKeySupportedBitMask = 1 ; cntKeySupportedBitMask < lenKeySupportedBitMask * 8 ; cntKeySupportedBitMask++) {
            valKeySupportedBitMask |= keySupportedBitMask.contains(valKeySupportedBitMask) ? (1 << cntKeySupportedBitMask % 8) : 0;
            if (cntKeySupportedBitMask % 8 == 0) {
                outputData.write(valKeySupportedBitMask);
                valKeySupportedBitMask = 0;
            }
        }

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_KEY_SUPPORTED_REPORT command<br>
     *
     * Entry Control Key Supported Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>KEY_SUPPORTED_BIT_MASK_LENGTH {@link Integer}
     * <li>KEY_SUPPORTED_BIT_MASK {@link List}<{@link Integer}>
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlKeySupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Key Supported Bit Mask Length'
        response.put("KEY_SUPPORTED_BIT_MASK_LENGTH", new Integer(payload[2]));

        // Process 'Key Supported Bit Mask'
        List<Integer> responseKeySupportedBitMask = new ArrayList<Integer>();
        int lenKeySupportedBitMask = (payload[0] & 0xFF) * 8;
        for (int cntKeySupportedBitMask = 0; cntKeySupportedBitMask < lenKeySupportedBitMask; cntKeySupportedBitMask++) {
            if ((payload[3 + (cntKeySupportedBitMask / 8)] & cntKeySupportedBitMask % 8) == 0) {
                continue;
            }
            responseKeySupportedBitMask.add(cntKeySupportedBitMask);
        }
        response.put("KEY_SUPPORTED_BIT_MASK", responseKeySupportedBitMask);

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_EVENT_SUPPORTED_GET command.<br>
     *
     * Entry Control Event Supported Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlEventSupportedGet() {
        logger.debug("Creating command message ENTRY_CONTROL_EVENT_SUPPORTED_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_EVENT_SUPPORTED_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_EVENT_SUPPORTED_GET command<br>
     *
     * Entry Control Event Supported Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlEventSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_EVENT_SUPPORTED_REPORT command.<br>
     *
     * Entry Control Event Supported Report<br>
     *
     *
     * @param dataTypeSupportedBitMask {@link List<String>}
     * @param eventTypeSupportedBitMask {@link List<String>}
     * @param keyCachedSizeSupportedMinimum {@link Integer}
     * @param keyCachedSizeSupportedMaximum {@link Integer}
     * @param keyCachedTimeoutSupportedMinimum {@link Integer}
     * @param keyCachedTimeoutSupportedMaximum {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlEventSupportedReport(List<String> dataTypeSupportedBitMask,
            List<String> eventTypeSupportedBitMask, Integer keyCachedSizeSupportedMinimum,
            Integer keyCachedSizeSupportedMaximum, Integer keyCachedTimeoutSupportedMinimum,
            Integer keyCachedTimeoutSupportedMaximum) {
        logger.debug("Creating command message ENTRY_CONTROL_EVENT_SUPPORTED_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_EVENT_SUPPORTED_REPORT);

        // Process 'Properties1'
        outputData.write(0);

        // Process 'Data Type Supported Bit Mask'
        int valDataTypeSupportedBitMask = 0;
        valDataTypeSupportedBitMask |= (dataTypeSupportedBitMask.contains("NA") ? 0x01 : 0);
        valDataTypeSupportedBitMask |= (dataTypeSupportedBitMask.contains("RAW") ? 0x02 : 0);
        valDataTypeSupportedBitMask |= (dataTypeSupportedBitMask.contains("ASCII") ? 0x04 : 0);
        valDataTypeSupportedBitMask |= (dataTypeSupportedBitMask.contains("MD5") ? 0x08 : 0);
        outputData.write(valDataTypeSupportedBitMask);

        // Process 'Properties2'
        outputData.write(0);

        // Process 'Event Type Supported Bit Mask'
        int valEventTypeSupportedBitMask = 0;
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("CACHING") ? 0x01 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("CACHED_KEYS") ? 0x02 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ENTER") ? 0x04 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("DISARM_ALL") ? 0x08 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_ALL") ? 0x10 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_AWAY") ? 0x20 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_HOME") ? 0x40 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("EXIT_DELAY") ? 0x80 : 0);
        outputData.write(valEventTypeSupportedBitMask);
        valEventTypeSupportedBitMask = 0;
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_1") ? 0x01 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_2") ? 0x02 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_3") ? 0x04 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_4") ? 0x08 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_5") ? 0x10 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ARM_6") ? 0x20 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("RFID") ? 0x40 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("BELL") ? 0x80 : 0);
        outputData.write(valEventTypeSupportedBitMask);
        valEventTypeSupportedBitMask = 0;
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("FIRE") ? 0x01 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("POLICE") ? 0x02 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ALERT_PANIC") ? 0x04 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("ALERT_MEDICAL") ? 0x08 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("GATE_OPEN") ? 0x10 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("GATE_CLOSE") ? 0x20 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("LOCK") ? 0x40 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("UNLOCK") ? 0x80 : 0);
        outputData.write(valEventTypeSupportedBitMask);
        valEventTypeSupportedBitMask = 0;
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("TEST") ? 0x01 : 0);
        valEventTypeSupportedBitMask |= (eventTypeSupportedBitMask.contains("CANCEL") ? 0x02 : 0);
        outputData.write(valEventTypeSupportedBitMask);

        // Process 'Key Cached Size supported Minimum'
        outputData.write(keyCachedSizeSupportedMinimum);

        // Process 'Key Cached Size supported Maximum'
        outputData.write(keyCachedSizeSupportedMaximum);

        // Process 'Key Cached Timeout supported Minimum'
        outputData.write(keyCachedTimeoutSupportedMinimum);

        // Process 'Key Cached Timeout supported Maximum'
        outputData.write(keyCachedTimeoutSupportedMaximum);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_EVENT_SUPPORTED_REPORT command<br>
     *
     * Entry Control Event Supported Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>DATA_TYPE_SUPPORTED_BIT_MASK {@link List}<{@link String}>
     * <li>EVENT_TYPE_SUPPORTED_BIT_MASK {@link List}<{@link String}>
     * <li>KEY_CACHED_SIZE_SUPPORTED_MINIMUM {@link Integer}
     * <li>KEY_CACHED_SIZE_SUPPORTED_MAXIMUM {@link Integer}
     * <li>KEY_CACHED_TIMEOUT_SUPPORTED_MINIMUM {@link Integer}
     * <li>KEY_CACHED_TIMEOUT_SUPPORTED_MAXIMUM {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlEventSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Properties1'

        // Process 'Data Type Supported Bit Mask'
        List<String> responseDataTypeSupportedBitMask = new ArrayList<String>();
        int lenDataTypeSupportedBitMask = (payload[0] & 0x03) * 8;
        for (int cntDataTypeSupportedBitMask = 0; cntDataTypeSupportedBitMask < lenDataTypeSupportedBitMask; cntDataTypeSupportedBitMask++) {
            if ((payload[3 + (cntDataTypeSupportedBitMask / 8)] & cntDataTypeSupportedBitMask % 8) == 0) {
                continue;
            }
            switch (cntDataTypeSupportedBitMask) {
                case 0x00:
                    responseDataTypeSupportedBitMask.add("NA");
                    break;
                case 0x01:
                    responseDataTypeSupportedBitMask.add("RAW");
                    break;
                case 0x02:
                    responseDataTypeSupportedBitMask.add("ASCII");
                    break;
                case 0x03:
                    responseDataTypeSupportedBitMask.add("MD5");
                    break;
                default:
                    responseDataTypeSupportedBitMask.add("BITMASK_" + cntDataTypeSupportedBitMask);
                    break;
            }
        }
        response.put("DATA_TYPE_SUPPORTED_BIT_MASK", responseDataTypeSupportedBitMask);

        // Process 'Properties2'

        // Process 'Event Type Supported Bit Mask'
        List<String> responseEventTypeSupportedBitMask = new ArrayList<String>();
        int lenEventTypeSupportedBitMask = (payload[-2] & 0x1F) * 8;
        for (int cntEventTypeSupportedBitMask = 0; cntEventTypeSupportedBitMask < lenEventTypeSupportedBitMask; cntEventTypeSupportedBitMask++) {
            if ((payload[5 + (cntEventTypeSupportedBitMask / 8)] & cntEventTypeSupportedBitMask % 8) == 0) {
                continue;
            }
            switch (cntEventTypeSupportedBitMask) {
                case 0x00:
                    responseEventTypeSupportedBitMask.add("CACHING");
                    break;
                case 0x01:
                    responseEventTypeSupportedBitMask.add("CACHED_KEYS");
                    break;
                case 0x02:
                    responseEventTypeSupportedBitMask.add("ENTER");
                    break;
                case 0x03:
                    responseEventTypeSupportedBitMask.add("DISARM_ALL");
                    break;
                case 0x04:
                    responseEventTypeSupportedBitMask.add("ARM_ALL");
                    break;
                case 0x05:
                    responseEventTypeSupportedBitMask.add("ARM_AWAY");
                    break;
                case 0x06:
                    responseEventTypeSupportedBitMask.add("ARM_HOME");
                    break;
                case 0x07:
                    responseEventTypeSupportedBitMask.add("EXIT_DELAY");
                    break;
                case 0x08:
                    responseEventTypeSupportedBitMask.add("ARM_1");
                    break;
                case 0x09:
                    responseEventTypeSupportedBitMask.add("ARM_2");
                    break;
                case 0x0A:
                    responseEventTypeSupportedBitMask.add("ARM_3");
                    break;
                case 0x0B:
                    responseEventTypeSupportedBitMask.add("ARM_4");
                    break;
                case 0x0C:
                    responseEventTypeSupportedBitMask.add("ARM_5");
                    break;
                case 0x0D:
                    responseEventTypeSupportedBitMask.add("ARM_6");
                    break;
                case 0x0E:
                    responseEventTypeSupportedBitMask.add("RFID");
                    break;
                case 0x0F:
                    responseEventTypeSupportedBitMask.add("BELL");
                    break;
                case 0x10:
                    responseEventTypeSupportedBitMask.add("FIRE");
                    break;
                case 0x11:
                    responseEventTypeSupportedBitMask.add("POLICE");
                    break;
                case 0x12:
                    responseEventTypeSupportedBitMask.add("ALERT_PANIC");
                    break;
                case 0x13:
                    responseEventTypeSupportedBitMask.add("ALERT_MEDICAL");
                    break;
                case 0x14:
                    responseEventTypeSupportedBitMask.add("GATE_OPEN");
                    break;
                case 0x15:
                    responseEventTypeSupportedBitMask.add("GATE_CLOSE");
                    break;
                case 0x16:
                    responseEventTypeSupportedBitMask.add("LOCK");
                    break;
                case 0x17:
                    responseEventTypeSupportedBitMask.add("UNLOCK");
                    break;
                case 0x18:
                    responseEventTypeSupportedBitMask.add("TEST");
                    break;
                case 0x19:
                    responseEventTypeSupportedBitMask.add("CANCEL");
                    break;
                default:
                    responseEventTypeSupportedBitMask.add("BITMASK_" + cntEventTypeSupportedBitMask);
                    break;
            }
        }
        response.put("EVENT_TYPE_SUPPORTED_BIT_MASK", responseEventTypeSupportedBitMask);

        // Process 'Key Cached Size supported Minimum'
        response.put("KEY_CACHED_SIZE_SUPPORTED_MINIMUM", new Integer(payload[6]));

        // Process 'Key Cached Size supported Maximum'
        response.put("KEY_CACHED_SIZE_SUPPORTED_MAXIMUM", new Integer(payload[7]));

        // Process 'Key Cached Timeout supported Minimum'
        response.put("KEY_CACHED_TIMEOUT_SUPPORTED_MINIMUM", new Integer(payload[8]));

        // Process 'Key Cached Timeout supported Maximum'
        response.put("KEY_CACHED_TIMEOUT_SUPPORTED_MAXIMUM", new Integer(payload[9]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_CONFIGURATION_SET command.<br>
     *
     * Entry Control Configuration Set<br>
     *
     *
     * @param keyCacheSize {@link Integer}
     * @param keyCacheTimeout {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlConfigurationSet(Integer keyCacheSize, Integer keyCacheTimeout) {
        logger.debug("Creating command message ENTRY_CONTROL_CONFIGURATION_SET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_CONFIGURATION_SET);

        // Process 'Key Cache Size'
        outputData.write(keyCacheSize);

        // Process 'Key Cache Timeout'
        outputData.write(keyCacheTimeout);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_CONFIGURATION_SET command<br>
     *
     * Entry Control Configuration Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>KEY_CACHE_SIZE {@link Integer}
     * <li>KEY_CACHE_TIMEOUT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlConfigurationSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Key Cache Size'
        response.put("KEY_CACHE_SIZE", new Integer(payload[2]));

        // Process 'Key Cache Timeout'
        response.put("KEY_CACHE_TIMEOUT", new Integer(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_CONFIGURATION_GET command.<br>
     *
     * Entry Control Configuration Get<br>
     *
     *
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlConfigurationGet() {
        logger.debug("Creating command message ENTRY_CONTROL_CONFIGURATION_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_CONFIGURATION_GET);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_CONFIGURATION_GET command<br>
     *
     * Entry Control Configuration Get<br>
     *
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlConfigurationGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the ENTRY_CONTROL_CONFIGURATION_REPORT command.<br>
     *
     * Entry Control Configuration Report<br>
     *
     *
     * @param keyCacheSize {@link Integer}
     * @param keyCacheTimeout {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getEntryControlConfigurationReport(Integer keyCacheSize, Integer keyCacheTimeout) {
        logger.debug("Creating command message ENTRY_CONTROL_CONFIGURATION_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(ENTRY_CONTROL_CONFIGURATION_REPORT);

        // Process 'Key Cache Size'
        outputData.write(keyCacheSize);

        // Process 'Key Cache Timeout'
        outputData.write(keyCacheTimeout);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the ENTRY_CONTROL_CONFIGURATION_REPORT command<br>
     *
     * Entry Control Configuration Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>KEY_CACHE_SIZE {@link Integer}
     * <li>KEY_CACHE_TIMEOUT {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleEntryControlConfigurationReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Key Cache Size'
        response.put("KEY_CACHE_SIZE", new Integer(payload[2]));

        // Process 'Key Cache Timeout'
        response.put("KEY_CACHE_TIMEOUT", new Integer(payload[3]));

        // Return the map of processed response data;
        return response;
    }

}
