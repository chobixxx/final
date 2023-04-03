package com.groupware.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@ToString
public class EmployeeDTO {
	
	private Integer empNo;
	private String team;
	private String email;
	private String name;
	private String password;
	private String position;
	private String gender;
	private String role = "user";

}
