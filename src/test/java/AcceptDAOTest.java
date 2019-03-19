import com.selab.simplecrowd.dao.AcceptDAO;
import com.selab.simplecrowd.pojo.Accept;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AcceptDAOTest extends BaseTest {

    @Autowired
    AcceptDAO acceptDAO;

    @Test
    public void testQueryAcceptedSimpleTaskByTaskId() {
        int taskId = 1;
        acceptDAO.addAcceptSimpleTask(2, 79);
        Accept accept = acceptDAO.queryAcceptedSimpleTaskByTaskId(taskId);
        System.out.println(accept.toString());

    }

}
