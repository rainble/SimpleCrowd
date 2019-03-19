import com.selab.simplecrowd.pojo.Publish;
import com.selab.simplecrowd.pojo.SimpleTask;
import com.selab.simplecrowd.service.PublishService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class PublishServiceTest extends BaseTest {

    @Autowired
    PublishService publishService;

    @Test
    public void testPublishSimpleTask() {
        SimpleTask simpleTask = new SimpleTask();
        simpleTask.setTaskDesc("Jane Maple");
        simpleTask.setLocationDesc("England");
        simpleTask.setDuration(30);
        simpleTask.setBonus(10);
        int publisherId = 80;
        String callbackUrl = "mail.fudan.edu.cn";
        int res = publishService.publishSimpleTask(simpleTask, publisherId, callbackUrl);
        System.out.println(res);
    }

}
