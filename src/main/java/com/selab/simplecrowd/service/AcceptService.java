package com.selab.simplecrowd.service;

import com.selab.simplecrowd.dao.AcceptDAO;
import com.selab.simplecrowd.dao.PublishDAO;
import com.selab.simplecrowd.dao.SimpleTaskDAO;
import com.selab.simplecrowd.pojo.Accept;
import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import com.selab.simplecrowd.utils.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AcceptService {

    public static final Logger logger = Logger.getLogger(AcceptService.class);


    @Autowired
    private AcceptDAO acceptDAO;
    @Autowired
    private SimpleTaskDAO simpleTaskDAO;
    @Autowired
    private PublishDAO publishDAO;


    // TODO: 2019-03-19 在accept里初始化publish
    public int acceptSimpleService(int taskId, int workerId) {
        Accept accept = new Accept();
        accept.setWorkerId(workerId);
        accept.setTaskId(taskId);
        accept.setPublish(publishDAO.queryPublishedSimpleByTaskId(taskId));

        if (simpleTaskDAO.querySimpleTaskByTaskId(taskId).getState() == 1) {
            int res = acceptDAO.addAcceptSimpleTask(accept);
            simpleTaskDAO.updateSimpleTaskState(taskId, Constant.ACCEPT_STATE);
            publishDAO.deletePublishedSimpleTask(taskId);
            logger.info(String.format("NO.[ %d ] task is accepted by NO.[ %d ] user at [ %s ]", taskId, workerId, accept.getAcceptTime()));
            return res;
        } else {
            logger.info(String.format("NO.[ %d ] task is already accepted by NO.[ %d ] user at [ %s ]", taskId, accept.getWorkerId(), accept.getAcceptTime()));
            return -1;
        }
    }

    public List<Accept> listAcceptedSimpleTaskByWorkerId(int workerId) {
        List<Accept> list = acceptDAO.listAcceptedSimpleTaskByWorkerId(workerId);
        return list;
    }

    public List<Accept> listAcceptedSimpleTaskByPublisherId(int publisherId) {
        List<Accept> list = acceptDAO.listAcceptedSimpleTaskByUserId(publisherId);
        return list;
    }

}
