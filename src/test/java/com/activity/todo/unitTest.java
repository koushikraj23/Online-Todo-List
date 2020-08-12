package com.activity.todo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import org.hamcrest.beans.SamePropertyValuesAs;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.internal.verification.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.junit4.SpringRunner;

import com.activity.todo.model.TodoTask;
import com.activity.todo.repository.TodoTaskRepo;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class unitTest {
	private Timestamp t = new Timestamp(2020, 8, 12, 13, 42, 50, 85);
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TodoTaskRepo todoTaskRepository;

	@Test
	public void testTaskAddition() {

		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, true, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, true, "admin"));
		List<TodoTask> taskList = todoTaskRepository.findByUserName("admin");
		assertEquals(2, todoTaskRepository.findByUserName("admin").size());

	}

	@Test
	public void testFindByUserName() {

		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, true, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, true, "user"));
		List<TodoTask> taskList = todoTaskRepository.findByUserName("user");
		assertEquals("Test2", (taskList.get(0).getTitle()));

	}

	@Test
	public void testDeleteById() {
		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, false, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, false, "admin"));
		List<TodoTask> tempList = todoTaskRepository.findByUserName("admin");
		todoTaskRepository.deleteById(tempList.get(0).getId());
		List<TodoTask> client = todoTaskRepository.findByUserName("admin");
		assertEquals(1, client.size());

	}

	@Test(expected = DataIntegrityViolationException.class)
	public void testInvalidUpdate() {
		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, false, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, false, "admin"));
		List<TodoTask> tempList = todoTaskRepository.findByUserName("admin");
		TodoTask tempTask = tempList.get(0);
		tempTask.setTitle(null);
		todoTaskRepository.save(tempTask);
		List<TodoTask> client = todoTaskRepository.findByUserName("admin");
		assertTrue(client.get(0).isChecked());

	}

	@Test
	public void testUpdateById() {

		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, false, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, false, "admin"));
		List<TodoTask> tempList = todoTaskRepository.findByUserName("admin");
		TodoTask tempTask = tempList.get(0);
		tempTask.setChecked(true);
		todoTaskRepository.save(tempTask);
		List<TodoTask> client = todoTaskRepository.findByUserName("admin");
		assertTrue(client.get(0).isChecked());

	}

	@Test
	public void testDeleteCall() {

		TodoTaskRepo taskRepo = Mockito.mock(TodoTaskRepo.class);
		taskRepo.deleteById((long) 1);
		verify(taskRepo).deleteById(ArgumentMatchers.eq((long) 1));

	}

	@Test
	public void testUpdateCall() {

		TodoTaskRepo taskRepo = Mockito.mock(TodoTaskRepo.class);
		TodoTask tempTask = new TodoTask("Test1", "Unit testing", t, t, false, "admin");
		taskRepo.save(tempTask);
		verify(taskRepo).save(ArgumentMatchers.eq(tempTask));
	}

	@Test(expected = EmptyResultDataAccessException.class)
	public void testInvalidDeleteById() {
		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, false, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, false, "admin"));

		List<TodoTask> tempList = todoTaskRepository.findByUserName("admin");

		todoTaskRepository.deleteById((long) 3);
	}

	@Test(expected = DataIntegrityViolationException.class)
	public void invalidUpdateNullParameter() {
		entityManager.persist(new TodoTask("Test1", "Unit testing", t, t, false, "admin"));
		entityManager.persist(new TodoTask("Test2", "Unit testing v2", t, t, false, "admin"));

		List<TodoTask> tempList = todoTaskRepository.findByUserName("admin");
		TodoTask tempTask = tempList.get(0);
		tempTask.setTitle(null);
		todoTaskRepository.save(tempTask);
		List<TodoTask> client = todoTaskRepository.findByUserName("admin");

		assertTrue(client.get(0).isChecked());
	}

}
