package com.zsmartsystems.zwave;

/**
 * Representation of a single association - stores a node and option endpoint
 * 
 * @author Chris Jackson
 *
 */
public class ZWaveAssociation {
    private int node;
    private int endpoint;

    public ZWaveAssociation(int node) {
        this.node = node;
        this.endpoint = 0;
    }

    public ZWaveAssociation(int node, int endpoint) {
        this.node = node;
        this.endpoint = endpoint;
    }

    public int getNode() {
        return node;
    }

    public int getEndpoint() {
        return endpoint;
    }

    @Override
    public boolean equals(Object checker) {
        ZWaveAssociation assoc = (ZWaveAssociation) checker;
        return (this.node == assoc.node && this.endpoint == assoc.endpoint);
    }
}
