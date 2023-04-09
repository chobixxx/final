package com.groupware.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.groupware.dto.TodolistDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter


@Entity
public class Todolist {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int num;//pk주기위해서 
   
   @NonNull
   private String title;//제목
   @NonNull
   private int importance;//중요도
   @NonNull
   private String h;//시
   @NonNull
   private String min;//분
   @ManyToOne
   @NonNull
   @JoinColumn(name="emp_no")
   private Employee empNo;
@Override
public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Todolist [num=");
	builder.append(num);
	builder.append(", employeeNo=");
	builder.append(empNo.getEmpNo());
	builder.append(", title=");
	builder.append(title);
	builder.append(", importance=");
	builder.append(importance);
	builder.append(", date=");
	builder.append(h);
	builder.append(", time=");
	builder.append(min);
	builder.append("]");
	return builder.toString();
}

public static Todolist toTodolist(TodolistDTO tDto) {
	   Todolist todolist = new Todolist();
	   todolist.setEmpNo(new Employee(tDto.getEmpNo()));
	   todolist.setH(tDto.getH());
	   todolist.setImportance(tDto.getImportance());
	   todolist.setMin(tDto.getMin());
	   todolist.setNum(tDto.getNum());
	   todolist.setTitle(tDto.getTitle());
	   
	   return todolist;
	}
   
   

}
