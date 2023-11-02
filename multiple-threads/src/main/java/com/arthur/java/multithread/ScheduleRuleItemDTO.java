package com.arthur.java.multithread;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Arthur Hu
 * @date: 2021/7/25 3:03 下午
 * Description:
 */
public class ScheduleRuleItemDTO implements Serializable {

    private String taskId;
    private String cronStr;
    private String taskType;
    private Boolean enbale;
    private Date startTime;
    private Date modifiedTime;
    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getCronStr() {
        return cronStr;
    }

    public void setCronStr(String cronStr) {
        this.cronStr = cronStr;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public Boolean getEnbale() {
        return enbale;
    }

    public void setEnbale(Boolean enbale) {
        this.enbale = enbale;
    }

    @Override
    public String toString() {
        return "ScheduleRuleItemDTO{" +
                "taskId='" + taskId + '\'' +
                ", cronStr='" + cronStr + '\'' +
                ", taskType='" + taskType + '\'' +
                ", enbale=" + enbale +
                '}';
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
