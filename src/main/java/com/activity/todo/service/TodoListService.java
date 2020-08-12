package com.activity.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.todo.model.TodoTask;
import com.activity.todo.repository.TodoTaskRepo;
@Service
public class TodoListService {

	@Autowired
	TodoTaskRepo todoTaskrepo;

	public List<TodoTask> findByUserName(String name) {
		return todoTaskrepo.findByUserName(name);
	}

	public void save(TodoTask todo) {
		// TODO Auto-generated method stub
		todoTaskrepo.save(todo);
	}

	public Optional<TodoTask> findById(long id) {
		// TODO Auto-generated method stub
		return todoTaskrepo.findById(id);
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		todoTaskrepo.deleteById(id);
	}
}
