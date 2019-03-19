package com.selab.simplecrowd.dao;

import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PublishDAO {

    /**
     * publish crowd task
     * @param taskId
     * @param publisherId
     * @param callbackUr
     * @return int
     * @create 2019-03-15 10:16
    **/
    int addPublishSimpleTask(@Param("taskId")int taskId, @Param("publisherId") int publisherId,
                                 @Param("callbackUrl")String callbackUr);

    /**
     * query task detail by taskId
     * @param taskId 
     * @return com.selab.simplecrowd.pojo.SimpleTask
     * @create  20:06
    **/
    Publish queryPublishedSimpleByTaskId(@Param("taskId")int taskId);

    /**
     * list all of the tasks published by one publisher
     * @param publisherId
     * @return java.util.List<com.selab.simplecrowd.pojo.SimpleTask>
     * @create  20:23
    **/
    List<Publish> listPublishedSimpleTaskByUserId(@Param("publisherId")int publisherId);

    /**
     * query the callbackUrl bu taskId for callback when the task is completed
     * @param taskId
     * @return java.lang.String
     * @create 2019-03-15 10:18
    **/
    String queryCallbackUrlByTaskId(@Param("taskId")int taskId);

    /**
     * delete the task 
     * @param taskId 
     * @return int
     * @create  20:35
    **/
    int deletePublishedSimpleTask(@Param("taskId")int taskId);
}
