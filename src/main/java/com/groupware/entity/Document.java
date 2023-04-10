package com.groupware.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupware.dto.DocumentDTO;
import com.groupware.service.DocumentStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@ToString

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doc_num")
    private Long docNum;
    
    @Enumerated(EnumType.STRING) // Enum 타입을 문자열로 매핑
    private DocumentStatus status = DocumentStatus.결재대기중; // status 필드와 Enum 타입의 매핑 설정
    
    public String getStatusText() {
        return this.status.getText();
    }
    
    public DocumentStatus getStatus() {
        if (status == null) {
            return DocumentStatus.결재대기중;
        }
        return status;
    }
    
    public void setStatus(DocumentStatus status) {
        if (status == null) {
            this.status = DocumentStatus.결재대기중;
        } else {
            this.status = status;
        }
    } 

    @NonNull
    private String title;

    @NonNull
    private String author;

    @NonNull
    @Column(columnDefinition = "TEXT")
    private String content;

	public static Document toDocument(DocumentDTO documentDTO) {
		Document document = new Document();
		document.setDocNum(documentDTO.getDocNum());
		document.setTitle(documentDTO.getTitle());
		document.setAuthor(documentDTO.getAuthor());
		document.setContent(documentDTO.getContent());
		document.setStatus(documentDTO.getStatus());
		return document;
	}

}