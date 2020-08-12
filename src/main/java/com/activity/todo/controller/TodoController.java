package com.activity.todo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.activity.todo.exception.TaskForUserNotFoundException;
//import com.activity.todo.exception.TaskExceptionHandler;
import com.activity.todo.exception.TaskIdMismatchException;
import com.activity.todo.exception.TaskIdNotFoundException;
import com.activity.todo.exception.UserNotFoundException;
import com.activity.todo.model.TodoTask;
import com.activity.todo.repository.TodoTaskRepo;
import com.activity.todo.service.TodoListService;

@Controller

public class TodoController {

	@Autowired
	private TodoListService todoTaskService;

	private String getLoggedInUserName() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}

		return principal.toString();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		model.put("todos", todoTaskService.findByUserName(getLoggedInUserName()));
		model.put("name", getLoggedInUserName());
		return "index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String Add(ModelMap model) {
		model.addAttribute("todo", new TodoTask());
		return "addTask";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addTodo(ModelMap model, TodoTask todo, BindingResult result) {

		if (result.hasErrors()) {
			throw new TaskIdMismatchException();
		}
		todo.setUserName(getLoggedInUserName());
		todoTaskService.save(todo);
		return "redirect:/";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam long id, ModelMap model) {
		Optional<TodoTask> todo = todoTaskService.findById(id);
		model.put("todo", todo);
		return "update";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, TodoTask todo, BindingResult result) {

		if (result.hasErrors()) {
			throw new TaskIdMismatchException();
		}

		todo.setUserName(getLoggedInUserName());
		todoTaskService.save(todo);
		return "redirect:/";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteTodo(@RequestParam long id) {
		todoTaskService.deleteById(id);
		return "redirect:/";
	}

}
