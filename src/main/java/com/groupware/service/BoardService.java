package com.groupware.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.groupware.repository.BoardRepository;

public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
}
