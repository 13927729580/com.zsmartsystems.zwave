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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to implement the Z-Wave command class <b>COMMAND_CLASS_SCREEN_MD</b> version <b>1</b>.<br>
 *
 * Command Class Screen Md<br>
 *
 * This class provides static methods for processing received messages (message handler) and
 * methods to get a message to send on the Z-Wave network.<br>
 *
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassScreenMdV1 {
    private static final Logger logger = LoggerFactory.getLogger(CommandClassScreenMdV1.class);

    /**
     * Integer command class key for COMMAND_CLASS_SCREEN_MD
     */
    public final static int COMMAND_CLASS_KEY = 0x92;

    /**
     * Screen Md Get Command Constant
     */
    public final static int SCREEN_MD_GET = 0x01;
    /**
     * Screen Md Report Command Constant
     */
    public final static int SCREEN_MD_REPORT = 0x02;

    /**
     * Creates a new message with the SCREEN_MD_GET command.<br>
     *
     * Screen Md Get<br>
     *
     *
     * @param numberOfReports {@link Integer}
     * @param nodeId {@link Integer}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScreenMdGet(Integer numberOfReports, Integer nodeId) {
        logger.debug("Creating command message SCREEN_MD_GET version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCREEN_MD_GET);

        // Process 'Number of Reports'
        outputData.write(numberOfReports);

        // Process 'Node ID'
        // Check the node number boundary
        if (nodeId < 1 || nodeId > 232) {
            logger.debug("Node number is out of bounds {}", nodeId);
            return null;
        }
        outputData.write(nodeId);

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCREEN_MD_GET command<br>
     *
     * Screen Md Get<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>NUMBER_OF_REPORTS {@link Integer}
     * <li>NODE_ID {@link Integer}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScreenMdGet(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // Process 'Number of Reports'
        response.put("NUMBER_OF_REPORTS", new Integer(payload[2]));

        // Process 'Node ID'
        response.put("NODE_ID", new Integer(payload[3]));

        // Return the map of processed response data;
        return response;
    }

    /**
     * Creates a new message with the SCREEN_MD_REPORT command.<br>
     *
     * Screen Md Report<br>
     *
     *
     * @param charPresentation {@link Integer}
     * @param screenSettings {@link Integer}
     * @param moreData {@link Boolean}
     * @return the {@link byte[]} array with the command to send
     */
    static public byte[] getScreenMdReport(Integer charPresentation, Integer screenSettings, Boolean moreData) {
        logger.debug("Creating command message SCREEN_MD_REPORT version 1");

        ByteArrayOutputStream outputData = new ByteArrayOutputStream();
        outputData.write(COMMAND_CLASS_KEY);
        outputData.write(SCREEN_MD_REPORT);

        // Process 'Properties1'
        int valProperties1 = 0;
        valProperties1 |= charPresentation & 0x07;
        valProperties1 |= ((screenSettings << 3) & 0x38);
        valProperties1 |= moreData ? 0x80 : 0;
        outputData.write(valProperties1);

        // Process 'vg'

        return outputData.toByteArray();
    }

    /**
     * Processes a received frame with the SCREEN_MD_REPORT command<br>
     *
     * Screen Md Report<br>
     *
     *
     * The output data {@link Map} has the following properties<br>
     *
     * <ul>
     * <li>CHAR_PRESENTATION {@link Integer}
     * <li>SCREEN_SETTINGS {@link Integer}
     * <li>MORE_DATA {@link Boolean}
     * </ul>
     *
     * @param payload the {@link byte[]} payload data to process
     * @return a {@link Map} of processed response data
     */
    public static Map<String, Object> handleScreenMdReport(byte[] payload) {
        // Create our response map
        Map<String, Object> response = new HashMap<String, Object>();

        // We're using variable length fields, so track the offset
        int msgOffset = 2;

        // Process 'Properties1'
        response.put("CHAR_PRESENTATION", new Integer(payload[msgOffset] & 0x07));
        response.put("SCREEN_SETTINGS", new Integer((payload[msgOffset] & 0x38 >> 3)));
        response.put("MORE_DATA", new Boolean((payload[msgOffset] & 0x80) != 0));
        msgOffset += 1;

        // Process 'vg'

        // Create a list to hold the group vg
        List<Map<String, Object>> variantList = new ArrayList<Map<String, Object>>();

        int offset = msgOffset;
        while (offset < payload.length) {
            // Create a map to hold the members of this variant
            Map<String, Object> variant = new HashMap<String, Object>();

            // Process 'Properties1'
            variant.put("LINE_NUMBER", new Integer(payload[msgOffset] & 0x0F));
            variant.put("CLEAR", new Boolean((payload[msgOffset] & 0x10) != 0));
            variant.put("LINE_SETTINGS", new Integer((payload[msgOffset] & 0xE0 >> 5)));
            msgOffset += 1;

            // Process 'Character Position'
            variant.put("CHARACTER_POSITION", new Integer(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Number of Characters'
            variant.put("NUMBER_OF_CHARACTERS", new Integer(payload[msgOffset]));
            msgOffset += 1;

            // Process 'Character'
            int valCharacter = 0;
            int lenCharacter = payload[msgOffset - 1];
            for (int cntCharacter = 0; cntCharacter < lenCharacter; cntCharacter++) {
                valCharacter = (valCharacter << 8) + payload[msgOffset + cntCharacter];
            }
            variant.put("CHARACTER", valCharacter);
            msgOffset += lenCharacter;

        }

        // Add the variant list to the response
        response.put("VG", variantList);

        // Return the map of processed response data;
        return response;
    }

}
