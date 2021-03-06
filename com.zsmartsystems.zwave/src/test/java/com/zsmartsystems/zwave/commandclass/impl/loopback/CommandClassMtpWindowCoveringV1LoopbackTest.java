/**
 * Copyright (c) 2016-2017 by the respective copyright holders.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package com.zsmartsystems.zwave.commandclass.impl.loopback;

import static org.junit.Assert.assertEquals;

import java.util.Map;
import com.zsmartsystems.zwave.commandclass.impl.CommandClassMtpWindowCoveringV1;

/**
 * Class to implement loopback tests for command class <b>COMMAND_CLASS_MTP_WINDOW_COVERING</b> version <b>1</b>.
 * <p>
 * Note that this code is autogenerated. Manual changes may be overwritten.
 *
 * @author Chris Jackson - Initial contribution of Java code generator
 */
public class CommandClassMtpWindowCoveringV1LoopbackTest {
    /**
     * Performs an in/out test of the MOVE_TO_POSITION_SET command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param value {@link String}
     */
    public static void testMoveToPositionSetLoopback(String value) {
        byte[] testPayload = CommandClassMtpWindowCoveringV1.getMoveToPositionSet(value);

        Map<String, Object> response = CommandClassMtpWindowCoveringV1.handleMoveToPositionSet(testPayload);
        assertEquals(value, (String) response.get("VALUE"));
    }

    /**
     * Performs an in/out test of the MOVE_TO_POSITION_REPORT command.
     * <p>
     * Test is designed to ensure that the command generates the same data
     * as the handler processes and is mainly a check of the code generator.
     *
     * @param value {@link String}
     */
    public static void testMoveToPositionReportLoopback(String value) {
        byte[] testPayload = CommandClassMtpWindowCoveringV1.getMoveToPositionReport(value);

        Map<String, Object> response = CommandClassMtpWindowCoveringV1.handleMoveToPositionReport(testPayload);
        assertEquals(value, (String) response.get("VALUE"));
    }

}
