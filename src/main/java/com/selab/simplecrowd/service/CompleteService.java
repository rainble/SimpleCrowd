package com.selab.simplecrowd.service;

import com.selab.simplecrowd.dao.AcceptDAO;
import com.selab.simplecrowd.dao.CompleteDAO;
import com.selab.simplecrowd.dao.SimpleTaskDAO;
import com.selab.simplecrowd.pojo.Accept;
import com.selab.simplecrowd.pojo.Complete;
import com.selab.simplecrowd.utils.Constant;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class CompleteService {

    public static final Logger logger = Logger.getLogger(CompleteService.class);

    @Autowired
    SimpleTaskDAO simpleTaskDAO;

    @Autowired
    CompleteDAO completeDAO;

    @Autowired
    AcceptDAO acceptDAO;

    // TODO: 2019-03-19 在complete里不初始化accept
    public int completeSimpleTask(int taskId) {
        Complete complete = new Complete();
        complete.setTaskId(taskId);
        if (simpleTaskDAO.querySimpleTaskByTaskId(taskId).getState() == Constant.ACCEPT_STATE) {
            completeDAO.addCompleteSimpleTask(complete);
            simpleTaskDAO.updateSimpleTaskState(taskId, Constant.COMPLETE_STATE);
            acceptDAO.deleteAcceptedSimpleTask(taskId);
            logger.info(String.format("NO.[ %d ] task is completed by NO.[ %d ] user at [ %s ]",
                    taskId, complete.getAccept().getWorkerId(), complete.getCompleteTime()));
            return 1;
        } else {
            logger.info(String.format(
                    "NO.[ %d ] task is already accepted by NO.[ %d ] user at [ %s ]，do not submit repeatedly",
                    taskId, acceptDAO.queryAcceptedSimpleTaskByTaskId(taskId).getWorkerId(), complete.getCompleteTime()));
            return -1;
        }


    }
}
