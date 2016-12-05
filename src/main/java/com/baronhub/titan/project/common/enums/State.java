package com.baronhub.titan.project.common.enums;

/**
 * User state
 */
public enum State {
    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted"),
    LOCKED("Locked");

    private String stateType;

    private State(final String state){
        this.stateType = state;
    }

    public String getState(){
        return this.stateType;
    }

    @Override
    public String toString(){
        return this.stateType;
    }

    public String getName(){
        return this.name();
    }
}