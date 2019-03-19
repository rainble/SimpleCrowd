package com.selab.simplecrowd.enums;

public enum SimpleTaskState {

    PUBLISH(1, "任务已发布"), ACCEPT(2, "任务已接受"),
        COMPLETE(3, "任务已完成"),
        FAIL_PUBLISH(-1, "任务发布失败"),
        FAIL_ACCEPT(-2, "任务接受失败"),
        FAIL_COMPLETE(-3, "任务完成失败");

    private int state;
    private String stateDesc;

    private SimpleTaskState(int state, String stateDesc) {
        this.state = state;
        this.stateDesc = stateDesc;
    }

    public int getState() {
        return state;
    }

    public String getStateDesc() {
        return stateDesc;
    }

}
