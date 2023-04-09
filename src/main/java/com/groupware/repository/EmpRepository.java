package com.groupware.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupware.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

	//로그인
	Employee findByEmailAndPassword(String email, String password);
	
	//이메일 중복 체크
	Employee findByEmail(String email);
	
	//이메일&이름으로 비밀번호 찾기
	Employee findByEmailAndName(String email, String name);
	
	//사번&비밀번호로 이메일 찾기
	Employee findByEmpNoAndPassword(Integer empNo, String password);
	
	//전체 직원 조회
	List<Employee> findAll();
	
	//사번으로 직원 조회
	Employee findByEmpNo(Integer empNo);
	void deleteByEmpNo(Integer empNo);  // 직원 삭제
	
	//직원 이름으로 검색
	List<Employee> findByName(String name);

}
