package com.selab.simplecrowd.service;

import com.selab.simplecrowd.dao.PublishDAO;
import com.selab.simplecrowd.dao.SimpleTaskDAO;
import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import org.apache.log4j.Logger;
import com.selab.simplecrowd.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 2019-03-19 回来把log用AOP实现一下
@Service
public class PublishService {

    public static final Logger logger = Logger.getLogger(PublishService.class);

    @Autowired
    private SimpleTaskDAO simpleTaskDAO;
    @Autowired
    private PublishDAO publishDAO;

    public int publishSimpleTask(SimpleTask simpleTask, int publisherId, String callbackUrl) {
        simpleTaskDAO.addSimpleTask(simpleTask);
        Publish publish = new Publish();
        publish.setPublisherId(publisherId);
        publish.setTaskId(simpleTask.getTaskId());
        publish.setCallbackUrl(callbackUrl);
        publish.setSimpleTask(simpleTask);
        publishDAO.addPublishSimpleTask(publish);
        simpleTaskDAO.updateSimpleTaskState(simpleTask.getTaskId(), Constant.PUBLISH_STATE);

        logger.info(String.format("SimpleTask is published successfully. The taskId is [ %d ], publisherId is [ %d ], taskDesc is [ %s ]", simpleTask.getTaskId(), publisherId, simpleTask.getTaskDesc()));
        return simpleTask.getTaskId();
    }

    public List<Publish> queryPublishedSimpleTask() {
        List<Publish> list = publishDAO.listAllPublishedSimpleTask();
        return list;
    }


}
