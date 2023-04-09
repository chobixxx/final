package com.groupware.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupware.dto.EmployeeDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString

@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_no")
	private Integer empNo;
	
	@Column(name = "team", nullable = false)
	private String team;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "position", nullable = false)
	private String position;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
    @Column(name = "role", nullable = false)
    private String role = "user";
    
    
    //Message 관련 생성자
    public Employee(int empNo) {
        this.empNo = empNo;
     }
	
	
	public static Employee toEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee();
		employee.setEmpNo(employeeDTO.getEmpNo());
		employee.setTeam(employeeDTO.getTeam());
		employee.setEmail(employeeDTO.getEmail());
		employee.setName(employeeDTO.getName());
		employee.setPassword(employeeDTO.getPassword());
		employee.setPosition(employeeDTO.getPosition());
		employee.setGender(employeeDTO.getGender());
		employee.setRole(employeeDTO.getRole() != null ? employeeDTO.getRole() : "user");
		return employee;
	}


}
