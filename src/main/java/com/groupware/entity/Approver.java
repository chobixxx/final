//package com.groupware.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//
//@Entity
//public class Approver {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    
//    private String email;
//    
//    @ManyToOne
//    @JoinColumn(name = "document_id")
//    private Document document;
//
//	public Employee employee;
//
//	public String getEmail() {
//		// TODO Auto-generated method stub
//		return this.getEmail();
//	}
//	
//	public Long getId() {
//	    return id;
//	}
//
//	public Object stream() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public void setApprovedBy(Employee employee) {
//		// TODO Auto-generated method stub
//		
//	}
//
//}