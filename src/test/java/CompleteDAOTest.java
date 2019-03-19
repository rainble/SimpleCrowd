import com.selab.simplecrowd.dao.CompleteDAO;
import com.selab.simplecrowd.pojo.Complete;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CompleteDAOTest extends BaseTest {

    @Autowired
    CompleteDAO completeDAO;

    @Test
    public void testAddCompleteSimpleTask() {
        Complete complete = new Complete();
        complete.setTaskId(4);
        int res = completeDAO.addCompleteSimpleTask(complete);
        System.out.println(complete.getCompleteId() + "   " + res);
    }

    @Test
    public void testQueryCompletedSimpleTaskByTaskId() {
        System.out.println(completeDAO.queryCompletedSimpleTaskByTaskId(2).toString());
    }

}
