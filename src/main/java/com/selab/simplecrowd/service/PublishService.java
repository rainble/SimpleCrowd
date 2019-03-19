package com.selab.simplecrowd.service;

import com.selab.simplecrowd.dao.PublishDAO;
import com.selab.simplecrowd.dao.SimpleTaskDAO;
import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import com.selab.simplecrowd.utils.Constant;


public class PublishService {

    public static final Logger logger = Logger.getLogger(PublishService.class);

    private SimpleTaskDAO simpleTaskDAO;
    private PublishDAO publishDAO;

    public int publishSimpleTask(SimpleTask simpleTask, int publisherId, String callbackUrl) {
        simpleTaskDAO.addSimpleTask(simpleTask);
        publishDAO.addPublishSimpleTask(simpleTask.getTaskId(), publisherId, callbackUrl);
        simpleTaskDAO.updateSimpleTaskState(simpleTask.getTaskId(), Constant.PUBLISH_STATE);

        logger.info(String.format("SimpleTask is published successfully. The taskId is [ %d ], publisherId is [ %d ], taskDesc is [ %s ]", simpleTask.getTaskId(), publisherId, simpleTask.getTaskDesc()));
        return simpleTask.getTaskId();
    }


}
