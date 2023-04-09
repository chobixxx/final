package com.groupware.dto;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import com.groupware.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class TodolistDTO {
   private int num;//pk주기위해서 
   private String title;//제목
   private int importance;//중요도
   private String h;//시
   private String min;//분
   private int empNo;
   
   @Override
   public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("TodolistDTO [num=");
	builder.append(num);
	builder.append(", title=");
	builder.append(title);

	builder.append(", importance=");
	builder.append(importance);
	builder.append(", h=");
	builder.append(h);
	builder.append(", min=");
	builder.append(min);
	builder.append(", empNo=");
	builder.append(empNo);
	builder.append("]");
	return builder.toString();
}

   
}