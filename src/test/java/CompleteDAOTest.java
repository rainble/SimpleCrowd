import com.selab.simplecrowd.dao.CompleteDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CompleteDAOTest extends BaseTest {

    @Autowired
    CompleteDAO completeDAO;

    @Test
    public void testAddCompleteSimpleTask() {
        completeDAO.addCompleteSimpleTask(2);
    }

    @Test
    public void testQueryCompletedSimpleTaskByTaskId() {
        System.out.println(completeDAO.queryCompletedSimpleTaskByTaskId(2).toString());
    }

}
