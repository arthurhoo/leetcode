package com.arthur.java.multithread;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Arthur Hu
 * @date: 2021/7/25 3:02 下午
 * Description:
 */
public class ScheduleRuleDTO implements Serializable {

    private List<ScheduleRuleItemDTO> scheduleRuleItemDTOList;

    public List<ScheduleRuleItemDTO> getScheduleRuleItemDTOList() {
        return scheduleRuleItemDTOList;
    }

    public void setScheduleRuleItemDTOList(List<ScheduleRuleItemDTO> scheduleRuleItemDTOList) {
        this.scheduleRuleItemDTOList = scheduleRuleItemDTOList;
    }

    public static void main(String[] args) {
        ScheduleRuleDTO scheduleRuleDTO = new ScheduleRuleDTO();
        List<ScheduleRuleItemDTO> scheduleRuleItemDTOS = new ArrayList<>();
        ScheduleRuleItemDTO scheduleRuleItemDTO = new ScheduleRuleItemDTO();
        scheduleRuleItemDTO.setCronStr("0 30 15 * * ?");
        scheduleRuleItemDTO.setEnbale(true);
        scheduleRuleItemDTO.setTaskId("es-clusterId-taskId");
        scheduleRuleItemDTO.setTaskType("es-monitor");
        scheduleRuleItemDTO.setModifiedTime(new Date());
        scheduleRuleItemDTO.setStartTime(new Date());

        scheduleRuleItemDTOS.add(scheduleRuleItemDTO);
        scheduleRuleDTO.setScheduleRuleItemDTOList(scheduleRuleItemDTOS);

        System.out.println(JSON.toJSONString(scheduleRuleDTO));
    }
}
