package com.activity.todo;

import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.activity.todo.controller.TodoController;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {
	@Autowired
	private TodoController controller;

	@Test
	public void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
