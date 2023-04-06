//package com.groupware.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//
//@NoArgsConstructor
//@AllArgsConstructor
//@RequiredArgsConstructor
//@Getter
//@Setter
//
//
//@NamedQuery(name = "Board.allBoard",
//query = "select b from Board b order by no desc")
//@Entity
//public class Board {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int no;
//	
//	@NonNull
//	@Column(length = 50, nullable = false)
//	private String title;
//	
//	@NonNull
//	@Column(length = 500, nullable = false)
//	private String content;
//	
//	@NonNull
//	@Column(length = 10, nullable = false)
//	private String password;
//	
//	@NonNull
//	@Column(nullable = false)
//	private String writedate;
//	
//	@NonNull
//	@Column(nullable = false)
//	private int hit;
//	
//	@ManyToOne
//	@NonNull
//	@JoinColumn(name="emp_no")
//	   private Employee empNo;
//	
//	@OneToMany(mappedBy = "boardNo" , cascade = CascadeType.ALL)
//	private List<Reply> reply = new ArrayList<Reply>();
//	
//	public Board(int no) {
//		this.no = no;
//	}
//	
//	public Board (int no, String title,String content,String password, Employee employeeno) {
//		this.no=no;
//		this.title = title;
//		this.content= content;
//		this.password= password;
//		this.empNo =employeeno;
//	}
//	
//	 @Override
//	    public String toString() {
//	       StringBuilder builder = new StringBuilder();
//	       builder.append("게시판 번호 : ");
//	       builder.append(no);
//	       builder.append(", 제목 : ");
//	       builder.append(title);
//	       builder.append(", 내용 : ");
//	       builder.append(content);
//	       builder.append(", 비밀번호 : ");
//	       builder.append(password);
//	       builder.append(", 작성일 : ");
//	       builder.append(writedate);
//	       builder.append(", 조회수: ");
//	       builder.append(hit);
//	       builder.append(", 사원번호: ");
//	   	builder.append(empNo.getEmpNo());
//
//	       return builder.toString();
//	    }
//
//}