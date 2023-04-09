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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String content; //내용

	@Column(nullable = false, name = "deletedBySender")
	private boolean deletedBySender;
	
	@Column(nullable = false, name = "deletedByReceiver")
	private boolean deletedByReceiver;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sender", referencedColumnName = "emp_No")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Employee sender; //보낸사람

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "receiver", referencedColumnName = "emp_No")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private Employee receiver; //받은사람
	
	@Column(nullable = false)
	private String writeDate; //작성일
	

	public void deletedBySender() {
		this.deletedBySender = true;
	}
	
	public void deletedByReceiver() {
		this.deletedByReceiver = true;
	}
	
	public boolean isDeleted() {
		return isDeletedBySender() && isDeletedByReceiver();
	}
}