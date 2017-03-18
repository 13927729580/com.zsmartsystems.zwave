package com.zsmartsystems.zwave.transaction;

import java.util.Comparator;

/**
 *
 * @author Chris Jackson
 *
 */
public class ZWaveCommandClassTransactionPayloadComparator implements Comparator<ZWaveCommandClassTransactionPayload> {

    /**
     * Compares a serial message to another serial message.
     * Used by the priority queue to order messages.
     *
     * @param arg0 the first serial message to compare the other to.
     * @param arg1 the other serial message to compare the first one to.
     */
    @Override
    public int compare(ZWaveCommandClassTransactionPayload arg0, ZWaveCommandClassTransactionPayload arg1) {
        return arg0.getPriority().compareTo(arg1.getPriority());
    }
}
