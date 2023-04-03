package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupware.dto.EmployeeDTO;
import com.groupware.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

	//로그인
	Employee findByEmailAndPassword(String email, String password);
	
	//이메일 중복 체크
	Employee findByEmail(String email);
	
	//전체 직원 조회
	List<Employee> findAll();
	
	//직원 이름으로 검색
	List<Employee> findByName(String name);
	
	//이메일&이름으로 비밀번호 찾기
	Employee findByEmailAndName(String email, String name);
	
	//사번&비밀번호로 이메일 찾기
	Employee findByEmpNoAndPassword(Integer empNo, String password);
	
	//Message - 사번으로 보낸사람&받은사람 찾기
	Employee findByEmpNo(Integer empNo);


}
