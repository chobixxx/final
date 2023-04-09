package com.groupware.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.groupware.service.DocumentStatus;
import com.groupware.service.DocumentStatus.ApprovalStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
public class Document {

    public static final String Status = null;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_no")
	private Integer empNo;

    private String title;

    private String content;
    
    @Enumerated(EnumType.STRING) // Enum 타입을 문자열로 매핑
    private DocumentStatus status; // status 필드와 Enum 타입의 매핑 설정
    
    private Timestamp created_date;
    
    
    
//    @ManyToOne
//    private Approver approver;

//	public Approver getApprover() {
//		return null;
//	}

//	public Object getEmployee() {
//		return this.approver;
//	}

	public void setApprover(Object approver) {
		
	}

	public void setEmployee(Object employee) {
		
	}

	public void setStatus(DocumentStatus approved) {
		
	}
	
//	public String getEmail() {
//        return this.approver.getEmail();
//    }

	public void setStatus(ApprovalStatus approving) {
		
	}

}