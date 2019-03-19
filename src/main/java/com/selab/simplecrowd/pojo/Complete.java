package com.selab.simplecrowd.pojo;

import java.sql.Timestamp;

public class Complete {

    private int taskId;

    private Timestamp completeTime;

    private Accept accept;

    @Override
    public String toString() {
        return "Complete{" +
                "taskId=" + taskId +
                ", completeTime=" + completeTime +
                ", simpleTask=" + accept.toString() +
                '}';
    }

    public void setSimpleTask(Accept accept) {
        this.accept = accept;
    }

    public Accept getSimpleTask() {
        return accept;
    }

    public int getTaskId() {
        return taskId;
    }

    public Timestamp getCompleteTime() {
        return completeTime;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setCompleteTime(Timestamp completeTime) {
        this.completeTime = completeTime;
    }
}
