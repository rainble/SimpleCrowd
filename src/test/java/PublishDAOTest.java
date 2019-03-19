import com.selab.simplecrowd.dao.PublishDAO;
import com.selab.simplecrowd.dao.SimpleTaskDAO;
import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class PublishDAOTest extends BaseTest {

    @Autowired
    PublishDAO publishDAO;
    @Autowired
    SimpleTaskDAO simpleTaskDAO;


    @Test
    public void testQueryPublishedSimpleByTaskId() {
        int taskId = 5;
        Publish publish = publishDAO.queryPublishedSimpleByTaskId(taskId);

        System.out.println(publish.toString());
        System.out.println(publish.getSimpleTask().toString());
    }

    @Test
    public void testListPublishedSimpleTaskByUserId() {
        int publisherId = 99;
        List<Publish> list = publishDAO.listPublishedSimpleTaskByUserId(publisherId);
        for (Publish publish : list) {
            System.out.println(publish.toString() + " next is ");
        }
    }

    @Test
    public void testAddPublishSimpleTask() {
        int taskId = 8, publisherId = 99;
        String callbackUrl = "www.126.com";
        Publish publish = new Publish();
        publish.setCallbackUrl(callbackUrl);
        publish.setTaskId(taskId);
        publish.setPublisherId(publisherId);
        int res = publishDAO.addPublishSimpleTask(publish);
        System.out.println(publish.getPublishId());
    }

    @Test
    public void testListAllPublishedSimpleTask() {
        List<Publish> list = publishDAO.listAllPublishedSimpleTask();
        for (Publish publish : list) {
            System.out.println(publish.toString());
        }
    }
}
