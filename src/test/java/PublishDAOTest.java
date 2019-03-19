import com.selab.simplecrowd.dao.PublishDAO;
import com.selab.simplecrowd.dao.SimpleTaskDAO;
import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PublishDAOTest extends BaseTest {

    @Autowired
    PublishDAO publishDAO;
    @Autowired
    SimpleTaskDAO simpleTaskDAO;


    @Test
    public void testQueryPublishedSimpleByTaskId() {
        int taskId = simpleTaskDAO.queryLatestTaskId(), publisherId = 99;
        String callbackUrl = "www.126.com";
//        Publish publish = publishDAO.queryPublishedSimpleByTaskId(taskId);
        publishDAO.addPublishSimpleTask(taskId, publisherId, callbackUrl);
        List<Publish> list = publishDAO.listPublishedSimpleTaskByUserId(publisherId);
        for (Publish publish : list) {
            System.out.println(publish.toString() + " next is ");
        }
//        System.out.println(publish.toString());
//        System.out.println(publish.getSimpleTask().toString());
    }

}
