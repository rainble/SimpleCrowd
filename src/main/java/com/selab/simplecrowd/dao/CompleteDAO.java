package com.selab.simplecrowd.dao;

import com.selab.simplecrowd.pojo.Accept;
import com.selab.simplecrowd.pojo.Complete;
import com.selab.simplecrowd.pojo.SimpleTask;
import org.apache.ibatis.annotations.Param;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;

public interface CompleteDAO {
    
    /**
     * complete a task accepted
     * @param taskId
     * @return int
     * @create 2019-03-14 20:47
    **/
    int addCompleteSimpleTask(@Param("taskId")int taskId);

    /**
     * query completed task by taskId
     * @param taskId 
     * @return com.selab.simplecrowd.pojo.SimpleTask
     * @create 2019-03-14 20:52
    **/
    Complete queryCompletedSimpleTaskByTaskId(@Param("taskId")int taskId);

    /**
     * query the tasks completed which are published bu one person
     * @param publisherId
     * @return java.util.List<com.selab.simplecrowd.pojo.SimpleTask>
     * @create 2019-03-14 20:54
    **/
    List<Complete> listCompletedSimpleTaskByUserId(@Param("publisher")int publisherId);

    /**
     * query the tasks completed by one person
     * @param workerId
     * @return java.util.List<com.selab.simplecrowd.pojo.SimpleTask>
     * @create 2019-03-14 20:55
    **/
    List<Complete> listCompletedSimpleTaskByWorkerId(@Param("workerId")int workerId);

    /**
     * delete a task completed
     * @param taskId
     * @return int
     * @create 2019-03-14 21:04
    **/
    int deleteCompletedSimpleTask(@Param("taskId")int taskId);

}
