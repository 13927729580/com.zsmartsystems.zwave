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
import java.lang.IllegalArgumentException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCHEDULE</b> version <b>3</b>.<br>
 *
 * Command Class Schedule<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassScheduleV3 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassScheduleV3.class);

    /**
     * Integer command class key for COMMAND_CLASS_SCHEDULE
     */
    public final static int COMMAND_CLASS_KEY = 0x53;

    /**
     * Schedule Support Get Command Constant
     */
    public final static int SCHEDULE_SUPPORTED_GET = 0x01;
    /**
     * Schedule Support Report Command Constant
     */
    public final static int SCHEDULE_SUPPORTED_REPORT = 0x02;
    /**
     * Schedule Set Command Constant
     */
    public final static int COMMAND_SCHEDULE_SET = 0x03;
    /**
     * Schedule Get Command Constant
     */
    public final static int COMMAND_SCHEDULE_GET = 0x04;
    /**
     * Schedule Report Command Constant
     */
    public final static int COMMAND_SCHEDULE_REPORT = 0x05;
    /**
     * Schedule Remove Command Constant
     */
    public final static int SCHEDULE_REMOVE = 0x06;
    /**
     * Schedule State Set Command Constant
     */
    public final static int SCHEDULE_STATE_SET = 0x07;
    /**
     * Schedule State Get Command Constant
     */
    public final static int SCHEDULE_STATE_GET = 0x08;
    /**
     * Schedule State Report Command Constant
     */
    public final static int SCHEDULE_STATE_REPORT = 0x09;

    /**
     * Creates a new message with the SCHEDULE_SUPPORTED_GET command.<br>
     *
     * Schedule Support Get<br>
     *
     *
     * @param scheduleIdBlock {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleSupportedGet(Integer scheduleIdBlock) {
        logger.debug("Creating command message SCHEDULE_SUPPORTED_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_SUPPORTED_GET);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_SUPPORTED_GET command<br>
     *
     * Schedule Support Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleSupportedGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_SUPPORTED_REPORT command.<br>
     *
     * Schedule Support Report<br>
     *
     *
     * @param numberOfSupportedScheduleId {@link Integer}
     * @param startTimeSupport {@link Integer}
     * @param fallbackSupport {@link Boolean}
     * @param supportEnableDisable {@link Boolean}
     * @param numberOfSupportedCc {@link Integer}
     * @param supportedOverrideTypes {@link Integer}
     * @param overrideSupport {@link Boolean}
     * @param scheduleIdBlock {@link Integer}
     * @param numberOfSupportedScheduleBlocks {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleSupportedReport(Integer numberOfSupportedScheduleId, Integer startTimeSupport,
            Boolean fallbackSupport, Boolean supportEnableDisable, Integer numberOfSupportedCc,
            Integer supportedOverrideTypes, Boolean overrideSupport, Integer scheduleIdBlock,
            Integer numberOfSupportedScheduleBlocks) {
        logger.debug("Creating command message SCHEDULE_SUPPORTED_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_SUPPORTED_REPORT);

        // Process 'Number of Supported Schedule ID'
        outputData.write(numberOfSupportedScheduleId);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= startTimeSupport & 0x3F;
        valProperties1 |= fallbackSupport ? 0x40 : 0;
        valProperties1 |= supportEnableDisable ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'Number of supported CC'
        outputData.write(numberOfSupportedCc);

        // Process 'vg1'

        // Process 'Properties3'
        int valProperties3 = 0;
        valProperties3 |= supportedOverrideTypes & 0x7F;
        valProperties3 |= overrideSupport ? 0x80 : 0;
        outputData.write(valProperties3);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        // Process 'Number of Supported Schedule Blocks'
        outputData.write(numberOfSupportedScheduleBlocks);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_SUPPORTED_REPORT command<br>
     *
     * Schedule Support Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NUMBER_OF_SUPPORTED_SCHEDULE_ID {@link Integer}
     * <li>START_TIME_SUPPORT {@link Integer}
     * <li>FALLBACK_SUPPORT {@link Boolean}
     * <li>SUPPORT_ENABLE_DISABLE {@link Boolean}
     * <li>NUMBER_OF_SUPPORTED_CC {@link Integer}
     * <li>SUPPORTED_OVERRIDE_TYPES {@link Integer}
     * <li>OVERRIDE_SUPPORT {@link Boolean}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * <li>NUMBER_OF_SUPPORTED_SCHEDULE_BLOCKS {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleSupportedReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Number of Supported Schedule ID'
        response.put("NUMBER_OF_SUPPORTED_SCHEDULE_ID", new Integer(payload[2]));

        // Process 'Properties1'
        response.put("START_TIME_SUPPORT", new Integer(payload[3] & 0x3F));
        response.put("FALLBACK_SUPPORT", new Boolean((payload[3] & 0x40) != 0));
        response.put("SUPPORT_ENABLE_DISABLE", new Boolean((payload[3] & 0x80) != 0));

        // Process 'Number of supported CC'
        response.put("NUMBER_OF_SUPPORTED_CC", new Integer(payload[4]));

        // Process 'vg1'

        // Create a list to hold the group vg1
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = 5;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Supported CC'
            variant.put("SUPPORTED_CC", new Integer(payload[5]));

            // Process 'Properties2'
            variant.put("SUPPORTED_COMMAND", new Integer(payload[6] & 0x03));

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 2] & 0xFF) >> 0;
        }

        // Add the variant list to the response
        response.put("VG1", variantList);

        // Process 'Properties3'
        response.put("SUPPORTED_OVERRIDE_TYPES", new Integer(payload[7] & 0x7F));
        response.put("OVERRIDE_SUPPORT", new Boolean((payload[7] & 0x80) != 0));

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[8]));

        // Process 'Number of Supported Schedule Blocks'
        response.put("NUMBER_OF_SUPPORTED_SCHEDULE_BLOCKS", new Integer(payload[9]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SCHEDULE_SET command.<br>
     *
     * Schedule Set<br>
     *
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param recurrenceOffset {@link Integer}
     * @param startDayOfMonth {@link Integer}
     * @param recurrenceMode {@link String}
     * @param startWeekday {@link Integer}
     * @param startHour {@link Integer}
     * @param durationType {@link Integer}
     * @param startMinute {@link Integer}
     * @param relative {@link Boolean}
     * @param durationByte {@link Integer}
     * @param reportsToFollow {@link Integer}
     * @param numberOfCmdToFollow {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandScheduleSet(Integer scheduleId, Integer scheduleIdBlock, Integer startYear,
            Integer startMonth, Integer recurrenceOffset, Integer startDayOfMonth, String recurrenceMode,
            Integer startWeekday, Integer startHour, Integer durationType, Integer startMinute, Boolean relative,
            Integer durationByte, Integer reportsToFollow, Integer numberOfCmdToFollow) {
        logger.debug("Creating command message COMMAND_SCHEDULE_SET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SCHEDULE_SET);

        // Process 'Schedule ID'
        outputData.write(scheduleId);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        // Process 'Start Year'
        outputData.write(startYear);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= startMonth & 0x0F;
        valProperties1 |= ((recurrenceOffset << 4) & 0xF0);
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= startDayOfMonth & 0x1F;
        int valrecurrenceMode;
        switch (recurrenceMode) {
            case "REPEAT_EVERY_N_HOURS":
                valrecurrenceMode = 0;
                break;
            case "REPEAT_EVERY_N_DAYS":
                valrecurrenceMode = 1;
                break;
            case "REPEAT_EVERY_N_WEEKS":
                valrecurrenceMode = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for recurrenceMode: " + recurrenceMode);
        }
        valProperties2 |= valrecurrenceMode >> 5 & 0x60;
        outputData.write(valProperties2);

        // Process 'Properties3'
        outputData.write(startWeekday & 0x7F);

        // Process 'Properties4'
        int valProperties4 = 0;
        valProperties4 |= startHour & 0x1F;
        valProperties4 |= ((durationType << 5) & 0xE0);
        outputData.write(valProperties4);

        // Process 'Properties5'
        int valProperties5 = 0;
        valProperties5 |= startMinute & 0x3F;
        valProperties5 |= relative ? 0x40 : 0;
        outputData.write(valProperties5);

        // Process 'Duration Byte'
        outputData.write((durationByte >> 8) & 0xff);
        outputData.write(durationByte & 0xff);

        // Process 'Reports to Follow'
        outputData.write(reportsToFollow);

        // Process 'Number of Cmd to Follow'
        outputData.write(numberOfCmdToFollow);

        // Process 'vg1'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SCHEDULE_SET command<br>
     *
     * Schedule Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID {@link Integer}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * <li>START_YEAR {@link Integer}
     * <li>START_MONTH {@link Integer}
     * <li>RECURRENCE_OFFSET {@link Integer}
     * <li>START_DAY_OF_MONTH {@link Integer}
     * <li>RECURRENCE_MODE {@link String}
     * <li>START_WEEKDAY {@link Integer}
     * <li>START_HOUR {@link Integer}
     * <li>DURATION_TYPE {@link Integer}
     * <li>START_MINUTE {@link Integer}
     * <li>RELATIVE {@link Boolean}
     * <li>DURATION_BYTE {@link Integer}
     * <li>REPORTS_TO_FOLLOW {@link Integer}
     * <li>NUMBER_OF_CMD_TO_FOLLOW {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandScheduleSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Schedule ID'
        response.put("SCHEDULE_ID", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Start Year'
        response.put("START_YEAR", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties1'
        response.put("START_MONTH", new Integer(payload[msgOffset] & 0x0F));
        response.put("RECURRENCE_OFFSET", new Integer((payload[msgOffset] & 0xF0 >> 4)));
        msgOffset += 1;

        // Process 'Properties2'
        response.put("START_DAY_OF_MONTH", new Integer(payload[msgOffset] & 0x1F));
        switch ((payload[msgOffset] & 0x60) >> 5) {
            case 0x00:
                response.put("RECURRENCE_MODE", "REPEAT_EVERY_N_HOURS");
                break;
            case 0x01:
                response.put("RECURRENCE_MODE", "REPEAT_EVERY_N_DAYS");
                break;
            case 0x02:
                response.put("RECURRENCE_MODE", "REPEAT_EVERY_N_WEEKS");
                break;
            default:
                logger.debug("Unknown enum value {} for RECURRENCE_MODE", String.format("0x%02X", msgOffset));
        }
        msgOffset += 1;

        // Process 'Properties3'
        response.put("START_WEEKDAY", new Integer(payload[msgOffset] & 0x7F));
        msgOffset += 1;

        // Process 'Properties4'
        response.put("START_HOUR", new Integer(payload[msgOffset] & 0x1F));
        response.put("DURATION_TYPE", new Integer((payload[msgOffset] & 0xE0 >> 5)));
        msgOffset += 1;

        // Process 'Properties5'
        response.put("START_MINUTE", new Integer(payload[msgOffset] & 0x3F));
        response.put("RELATIVE", new Boolean((payload[msgOffset] & 0x40) != 0));
        msgOffset += 1;

        // Process 'Duration Byte'
        response.put("DURATION_BYTE", new Integer(payload[msgOffset] << 8 + payload[msgOffset + 12]));
        msgOffset += 2;

        // Process 'Reports to Follow'
        response.put("REPORTS_TO_FOLLOW", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Number of Cmd to Follow'
        response.put("NUMBER_OF_CMD_TO_FOLLOW", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'vg1'

        // Create a list to hold the group vg1
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = msgOffset;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Cmd Length'
            variant.put("CMD_LENGTH", new Integer(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Cmd Byte'
            int valCmdByte = 0;
            int lenCmdByte = payload[msgOffset - 1];
            for (int cntCmdByte = 0; cntCmdByte < lenCmdByte; cntCmdByte++) {
                valCmdByte = (valCmdByte << 8) + payload[msgOffset + cntCmdByte];
            }
            variant.put("CMD_BYTE", valCmdByte);
            msgOffset += lenCmdByte;

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 10] & 0xFF) >> 0;
        }

        // Add the variant list to the response
        response.put("VG1", variantList);

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SCHEDULE_GET command.<br>
     *
     * Schedule Get<br>
     *
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @param aidRoCtl {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandScheduleGet(Integer scheduleId, Integer scheduleIdBlock, Boolean aidRoCtl) {
        logger.debug("Creating command message COMMAND_SCHEDULE_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SCHEDULE_GET);

        // Process 'Schedule ID'
        outputData.write(scheduleId);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        // Process 'Properties1'
        outputData.write(aidRoCtl ? 0x80 : 0);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SCHEDULE_GET command<br>
     *
     * Schedule Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID {@link Integer}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * <li>AID_RO_CTL {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandScheduleGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Schedule ID'
        response.put("SCHEDULE_ID", new Integer(payload[2]));

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[3]));

        // Process 'Properties1'
        response.put("AID_RO_CTL", new Boolean((payload[4] & 0x80) != 0));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the COMMAND_SCHEDULE_REPORT command.<br>
     *
     * Schedule Report<br>
     *
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @param startYear {@link Integer}
     * @param startMonth {@link Integer}
     * @param aidRo {@link Integer}
     * @param startDayOfMonth {@link Integer}
     * @param recurrenceMode {@link String}
     * @param aidRoCtl {@link Boolean}
     * @param startWeekday {@link Integer}
     * @param startHour {@link Integer}
     * @param durationType {@link Integer}
     * @param startMinute {@link Integer}
     * @param relative {@link Boolean}
     * @param durationByte {@link Integer}
     * @param reportsToFollow {@link Integer}
     * @param numberOfCmdToFollow {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getCommandScheduleReport(Integer scheduleId, Integer scheduleIdBlock, Integer startYear,
            Integer startMonth, Integer aidRo, Integer startDayOfMonth, String recurrenceMode, Boolean aidRoCtl,
            Integer startWeekday, Integer startHour, Integer durationType, Integer startMinute, Boolean relative,
            Integer durationByte, Integer reportsToFollow, Integer numberOfCmdToFollow) {
        logger.debug("Creating command message COMMAND_SCHEDULE_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(COMMAND_SCHEDULE_REPORT);

        // Process 'Schedule ID'
        outputData.write(scheduleId);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        // Process 'Start Year'
        outputData.write(startYear);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= startMonth & 0x0F;
        valProperties1 |= ((aidRo << 4) & 0xF0);
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= startDayOfMonth & 0x1F;
        int valrecurrenceMode;
        switch (recurrenceMode) {
            case "REPEAT_EVERY_N_HOURS":
                valrecurrenceMode = 0;
                break;
            case "REPEAT_EVERY_N_DAYS":
                valrecurrenceMode = 1;
                break;
            case "REPEAT_EVERY_N_WEEKS":
                valrecurrenceMode = 2;
                break;
            default:
                throw new IllegalArgumentException("Unknown enum value for recurrenceMode: " + recurrenceMode);
        }
        valProperties2 |= valrecurrenceMode >> 5 & 0x60;
        valProperties2 |= aidRoCtl ? 0x80 : 0;
        outputData.write(valProperties2);

        // Process 'Properties3'
        outputData.write(startWeekday & 0x7F);

        // Process 'Properties4'
        int valProperties4 = 0;
        valProperties4 |= startHour & 0x1F;
        valProperties4 |= ((durationType << 5) & 0xE0);
        outputData.write(valProperties4);

        // Process 'Properties5'
        int valProperties5 = 0;
        valProperties5 |= startMinute & 0x3F;
        valProperties5 |= relative ? 0x40 : 0;
        outputData.write(valProperties5);

        // Process 'Duration Byte'
        outputData.write((durationByte >> 8) & 0xff);
        outputData.write(durationByte & 0xff);

        // Process 'Reports to Follow'
        outputData.write(reportsToFollow);

        // Process 'Number of Cmd to Follow'
        outputData.write(numberOfCmdToFollow);

        // Process 'vg1'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the COMMAND_SCHEDULE_REPORT command<br>
     *
     * Schedule Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID {@link Integer}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * <li>START_YEAR {@link Integer}
     * <li>START_MONTH {@link Integer}
     * <li>AID_RO {@link Integer}
     * <li>START_DAY_OF_MONTH {@link Integer}
     * <li>RECURRENCE_MODE {@link String}
     * <li>AID_RO_CTL {@link Boolean}
     * <li>START_WEEKDAY {@link Integer}
     * <li>START_HOUR {@link Integer}
     * <li>DURATION_TYPE {@link Integer}
     * <li>START_MINUTE {@link Integer}
     * <li>RELATIVE {@link Boolean}
     * <li>DURATION_BYTE {@link Integer}
     * <li>REPORTS_TO_FOLLOW {@link Integer}
     * <li>NUMBER_OF_CMD_TO_FOLLOW {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleCommandScheduleReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Schedule ID'
        response.put("SCHEDULE_ID", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Start Year'
        response.put("START_YEAR", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Properties1'
        response.put("START_MONTH", new Integer(payload[msgOffset] & 0x0F));
        response.put("AID_RO", new Integer((payload[msgOffset] & 0xF0 >> 4)));
        msgOffset += 1;

        // Process 'Properties2'
        response.put("START_DAY_OF_MONTH", new Integer(payload[msgOffset] & 0x1F));
        switch ((payload[msgOffset] & 0x60) >> 5) {
            case 0x00:
                response.put("RECURRENCE_MODE", "REPEAT_EVERY_N_HOURS");
                break;
            case 0x01:
                response.put("RECURRENCE_MODE", "REPEAT_EVERY_N_DAYS");
                break;
            case 0x02:
                response.put("RECURRENCE_MODE", "REPEAT_EVERY_N_WEEKS");
                break;
            default:
                logger.debug("Unknown enum value {} for RECURRENCE_MODE", String.format("0x%02X", msgOffset));
        }
        response.put("AID_RO_CTL", new Boolean((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'Properties3'
        response.put("START_WEEKDAY", new Integer(payload[msgOffset] & 0x7F));
        msgOffset += 1;

        // Process 'Properties4'
        response.put("START_HOUR", new Integer(payload[msgOffset] & 0x1F));
        response.put("DURATION_TYPE", new Integer((payload[msgOffset] & 0xE0 >> 5)));
        msgOffset += 1;

        // Process 'Properties5'
        response.put("START_MINUTE", new Integer(payload[msgOffset] & 0x3F));
        response.put("RELATIVE", new Boolean((payload[msgOffset] & 0x40) != 0));
        msgOffset += 1;

        // Process 'Duration Byte'
        response.put("DURATION_BYTE", new Integer(payload[msgOffset] << 8 + payload[msgOffset + 12]));
        msgOffset += 2;

        // Process 'Reports to Follow'
        response.put("REPORTS_TO_FOLLOW", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'Number of Cmd to Follow'
        response.put("NUMBER_OF_CMD_TO_FOLLOW", new Integer(payload[msgOffset]));
        msgOffset += 1;

        // Process 'vg1'

        // Create a list to hold the group vg1
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = msgOffset;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Cmd Length'
            variant.put("CMD_LENGTH", new Integer(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Cmd Byte'
            int valCmdByte = 0;
            int lenCmdByte = payload[msgOffset - 1];
            for (int cntCmdByte = 0; cntCmdByte < lenCmdByte; cntCmdByte++) {
                valCmdByte = (valCmdByte << 8) + payload[msgOffset + cntCmdByte];
            }
            variant.put("CMD_BYTE", valCmdByte);
            msgOffset += lenCmdByte;

            // Add to the list
            variantList.add(variant);

            // Add the length of this variant
            offset += (payload[offset + 10] & 0xFF) >> 0;
        }

        // Add the variant list to the response
        response.put("VG1", variantList);

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_REMOVE command.<br>
     *
     * Schedule Remove<br>
     *
     *
     * @param scheduleId {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleRemove(Integer scheduleId, Integer scheduleIdBlock) {
        logger.debug("Creating command message SCHEDULE_REMOVE version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_REMOVE);

        // Process 'Schedule ID'
        outputData.write(scheduleId);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_REMOVE command<br>
     *
     * Schedule Remove<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID {@link Integer}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleRemove(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Schedule ID'
        response.put("SCHEDULE_ID", new Integer(payload[2]));

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_STATE_SET command.<br>
     *
     * Schedule State Set<br>
     *
     *
     * @param scheduleId {@link Integer}
     * @param scheduleState {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleStateSet(Integer scheduleId, Integer scheduleState, Integer scheduleIdBlock) {
        logger.debug("Creating command message SCHEDULE_STATE_SET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_STATE_SET);

        // Process 'Schedule ID'
        outputData.write(scheduleId);

        // Process 'Schedule State'
        outputData.write(scheduleState);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_STATE_SET command<br>
     *
     * Schedule State Set<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID {@link Integer}
     * <li>SCHEDULE_STATE {@link Integer}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleStateSet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Schedule ID'
        response.put("SCHEDULE_ID", new Integer(payload[2]));

        // Process 'Schedule State'
        response.put("SCHEDULE_STATE", new Integer(payload[3]));

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[4]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_STATE_GET command.<br>
     *
     * Schedule State Get<br>
     *
     *
     * @param scheduleIdBlock {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleStateGet(Integer scheduleIdBlock) {
        logger.debug("Creating command message SCHEDULE_STATE_GET version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_STATE_GET);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_STATE_GET command<br>
     *
     * Schedule State Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleStateGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[2]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCHEDULE_STATE_REPORT command.<br>
     *
     * Schedule State Report<br>
     *
     *
     * @param numberOfSupportedScheduleId {@link Integer}
     * @param override {@link Boolean}
     * @param reportsToFollow {@link Integer}
     * @param activeId1 {@link Integer}
     * @param activeId2 {@link Integer}
     * @param activeId3 {@link Integer}
     * @param activeIdN {@link Integer}
     * @param scheduleIdBlock {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScheduleStateReport(Integer numberOfSupportedScheduleId, Boolean override,
            Integer reportsToFollow, Integer activeId1, Integer activeId2, Integer activeId3, Integer activeIdN,
            Integer scheduleIdBlock) {
        logger.debug("Creating command message SCHEDULE_STATE_REPORT version 3");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCHEDULE_STATE_REPORT);

        // Process 'Number of Supported Schedule ID'
        outputData.write(numberOfSupportedScheduleId);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= override ? 0x01 : 0;
        valProperties1 |= ((reportsToFollow << 1) & 0xFE);
        outputData.write(valProperties1);

        // Process 'Properties2'
        int valProperties2 = 0;
        valProperties2 |= activeId1 & 0x0F;
        valProperties2 |= ((activeId2 << 4) & 0xF0);
        outputData.write(valProperties2);

        // Process 'Properties3'
        int valProperties3 = 0;
        valProperties3 |= activeId3 & 0x0F;
        valProperties3 |= ((activeIdN << 4) & 0xF0);
        outputData.write(valProperties3);

        // Process 'Schedule ID Block'
        outputData.write(scheduleIdBlock);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCHEDULE_STATE_REPORT command<br>
     *
     * Schedule State Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NUMBER_OF_SUPPORTED_SCHEDULE_ID {@link Integer}
     * <li>OVERRIDE {@link Boolean}
     * <li>REPORTS_TO_FOLLOW {@link Integer}
     * <li>ACTIVE_ID_1 {@link Integer}
     * <li>ACTIVE_ID_2 {@link Integer}
     * <li>ACTIVE_ID_3 {@link Integer}
     * <li>ACTIVE_ID_N {@link Integer}
     * <li>SCHEDULE_ID_BLOCK {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScheduleStateReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Number of Supported Schedule ID'
        response.put("NUMBER_OF_SUPPORTED_SCHEDULE_ID", new Integer(payload[2]));

        // Process 'Properties1'
        response.put("OVERRIDE", new Boolean((payload[3] & 0x01) != 0));
        response.put("REPORTS_TO_FOLLOW", new Integer((payload[3] & 0xFE >> 1)));

        // Process 'Properties2'
        response.put("ACTIVE_ID_1", new Integer(payload[4] & 0x0F));
        response.put("ACTIVE_ID_2", new Integer((payload[4] & 0xF0 >> 4)));

        // Process 'Properties3'
        response.put("ACTIVE_ID_3", new Integer(payload[5] & 0x0F));
        response.put("ACTIVE_ID_N", new Integer((payload[5] & 0xF0 >> 4)));

        // Process 'Schedule ID Block'
        response.put("SCHEDULE_ID_BLOCK", new Integer(payload[6]));

        // Return the map of processed response data;
        return response;
    }

}
