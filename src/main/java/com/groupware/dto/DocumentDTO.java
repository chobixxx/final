package com.groupware.dto;

import com.groupware.entity.Document;
import com.groupware.service.DocumentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class DocumentDTO {

	private Long docNum;
	private String title;
	private String author;
	private String content;
	private DocumentStatus status;

	public DocumentDTO(Document document) {
		this.docNum = document.getDocNum();
		this.title = document.getTitle();
		this.content = document.getContent();
		this.author = document.getAuthor();
		this.status = document.getStatus();
		if (this.status == null) {
	        this.status = DocumentStatus.결재대기중;
	    }
	}
	
	public static DocumentDTO fromDocument(Document document) {
	    return new DocumentDTO(
	            document.getDocNum(),
	            document.getTitle(),
	            document.getContent(),
	            document.getAuthor(),
	            document.getStatus());
	}
	
	 public String getStatusText() {
	        return status.getText();
	    }
	
	@Override
	public String toString() {
	    return "DocumentDTO [docNum=" + docNum + ", title=" + title + ", author=" + author
	            + ", content=" + content + ", status=" + status.getText() + "]";
	}
	
}
