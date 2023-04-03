package com.groupware.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.groupware.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content; //내용

	@Column(nullable = false)
	private boolean deletedBySender;
	
	@Column(nullable = false)
	private boolean deletedByReceiver;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender", referencedColumnName = "employeeNo")
//	@JoinColumn(name = "employeeNo")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Employee sender; //보낸사람

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver", referencedColumnName = "employeeNo")
//	@JoinColumn(name = "employeeNo")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Employee receiver; //받은사람
	
	
	@Column(nullable = false)
	private String writeDate; //작성일
	
//	@Column(nullable = false)
//	private int readcheck; //확인여부 (미확인시 1, 확인시 0)
	
	
	public void deleteBySender() {
		this.deletedBySender = true;
	}
	
	public void deleteByReceiver() {
		this.deletedByReceiver = true;
	}
	
	public boolean isDeleted() {
		return isDeletedBySender() && isDeletedByReceiver();
	}
}