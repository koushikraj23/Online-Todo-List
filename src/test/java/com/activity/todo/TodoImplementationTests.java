/*import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.activity.todo.model.TodoTask;
import com.activity.todo.repository.TodoTaskRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoImplementationTests {

	@MockBean
	TodoTask todoListMock;

	@Autowired
	TodoTaskRepo todoTaskRepo;

	@Test
	public void testFindTheGreatestFromAllData() {
		when(todoListMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, todoTaskRepo.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(todoListMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}

	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(todoListMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}*/