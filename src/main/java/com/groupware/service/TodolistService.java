package com.groupware.service;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.parser.DTD;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupware.dto.TodolistDTO;
import com.groupware.entity.Employee;
import com.groupware.entity.Todolist;
import com.groupware.exception.MessageException;
import com.groupware.repository.EmpRepository;
import com.groupware.repository.TodolistRepository;

@Service
public class TodolistService {

	@Autowired
	private TodolistRepository todolistRepository;
	
	@Autowired
	private EmpRepository empRepository;
	
	
	//전부 가져오기(테스트용)
	public List<TodolistDTO> getAll() {
		List<Todolist> todolists = todolistRepository.findAll();
		List<TodolistDTO> todolistDTOs = new ArrayList<>();
		for(Todolist todolist : todolists) {
			TodolistDTO tdto = new TodolistDTO();
			tdto.setEmpNo(todolist.getEmpNo().getEmpNo());
			tdto.setImportance(todolist.getImportance());
			tdto.setNum(todolist.getNum());
			tdto.setH(todolist.getH());
			tdto.setMin(todolist.getMin());
			tdto.setTitle(todolist.getTitle());
			todolistDTOs.add(tdto);
		}
		
		
		return todolistDTOs;
	} 
	
	//사번으로 가져오기
	public List<TodolistDTO> getTodolistOne(int empNo) {
		Employee e = empRepository.findByEmpNo(empNo);
		System.out.println(e.toString());
		List<Todolist> todolists = todolistRepository.findByEmpNo(e);
		List<TodolistDTO> todolistDTOs = new ArrayList<>();
		for(Todolist todolist : todolists) {
			TodolistDTO tdto = new TodolistDTO();
			tdto.setEmpNo(todolist.getEmpNo().getEmpNo());
			tdto.setImportance(todolist.getImportance());
			tdto.setNum(todolist.getNum());
			tdto.setH(todolist.getH());
			tdto.setMin(todolist.getMin());
			tdto.setTitle(todolist.getTitle());
			todolistDTOs.add(tdto);
		}
		System.out.println("todolist 서비스 도착");
		todolistDTOs.forEach(v -> System.out.println());
		System.out.println("***********");
		return todolistDTOs;
	}

	public  void save(TodolistDTO tDto) throws MessageException{
		Todolist todolist = Todolist.toTodolist(tDto);
		todolistRepository.save(todolist);
	}

	@Transactional
	public void delete(int num) {
		todolistRepository.deleteByNum(num);
		
	} 
}
