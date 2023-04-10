package com.groupware.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.stereotype.Service;

import com.groupware.dto.DocumentDTO;
import com.groupware.entity.Document;
import com.groupware.exception.MessageException;
import com.groupware.exception.NotExistException;
import com.groupware.exception.NotFoundException;
import com.groupware.repository.DocumentRepository;


@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    

    //결재문서 목록
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    //결재문서 생성
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }
    
    //결재문서 삭제
    @Transactional
    public void deleteDocument(Long docNum) throws DataAccessResourceFailureException {
        try {
            documentRepository.deleteByDocNum(docNum);
        } catch (Exception e) {
            throw new DataAccessResourceFailureException("Failed to delete document with docNum: " + docNum, e);
        }
    }
    
    //
    public Document getDocumentByDocNum(Long docNum) {
        return documentRepository.findByDocNum(docNum);
    }

    
	public void updateDocument(DocumentDTO documentDTO) {
		 Document document = documentRepository.findByDocNum(documentDTO.getDocNum());
		    if (document != null) {
		        document.setTitle(documentDTO.getTitle());
		        document.setContent(documentDTO.getContent());

		        documentRepository.save(document);
		    }
	}
	
	//작성자와 사용자의 이름 맞추기
	public DocumentDTO getDocument(Long docNum) throws NotExistException {
	    Document document = documentRepository.findById(docNum).orElse(null);
	    if (document == null) {
	        throw new NotExistException("해당 문서가 존재하지 않습니다.");
	    }
	    return new DocumentDTO(document);
	}

	//문서 작성
	public void save(DocumentDTO documentDTO) throws MessageException{
		Document document = Document.toDocument(documentDTO);
		documentRepository.save(document);
	}

	
	@Transactional
	public void approveDocument(Long docNum, String status) throws MessageException {
	    Document document = documentRepository.findByDocNum(docNum);
	    if (document != null) {
	    	DocumentStatus documentStatus = DocumentStatus.valueOf(status);
	        document.setStatus(documentStatus);

	        try {
	            documentRepository.save(document);
	        } catch (DataAccessResourceFailureException e) {
	            throw new MessageException("데이터베이스 접근 중 오류가 발생했습니다.");
	        }
	    } else {
	        throw new MessageException("해당 문서가 존재하지 않습니다.");
	    }
	}

	public void insertDocument(DocumentStatus status) {
		
	}
	
	@Transactional
	public DocumentDTO changeStatus(Long docNum, String newStatus) {
	    Document document = documentRepository.findById(docNum)
	            .orElseThrow(() -> new NotFoundException("해당 문서를 찾을 수 없습니다"));
	    document.setStatus(DocumentStatus.fromText(newStatus));
	    documentRepository.save(document);
	    return DocumentDTO.fromDocument(document);
	}
	
	 public List<DocumentDTO> getDocuments() {
	        List<Document> documents = documentRepository.findAll();
	        return documents.stream()
	                .map(document -> new DocumentDTO(document.getDocNum().longValue(), document.getTitle(), document.getAuthor(),
	                        document.getContent(), document.getStatus()))
	                .collect(Collectors.toList());
	    }
	}
