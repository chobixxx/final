//package com.groupware.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.groupware.entity.Approver;
//import com.groupware.entity.Document;
//import com.groupware.entity.Employee;
//import com.groupware.repository.DocumentRepository;
//import com.groupware.repository.ApproverRepository;
//import com.groupware.service.DocumentStatus;
//import com.groupware.service.DocumentStatus.ApprovalStatus;
//
//
//@Service
//public class ApproverService {
//
//    
//	@Autowired
//	private ApproverRepository approverRepository;
//	
//    @Autowired
//    private DocumentRepository documentRepository;
//    
//    @Autowired
//    private EmpService empService;
//
//    
//    public boolean approveDocument(Long id, String email) {
//        Approver approver = approverRepository.findById(id).orElse(null);
//        if (approver == null) {
//            return false;
//        }
//
//        if ("admin@gmail.com".equals(email)) {
//            // 해당 결재자가 이 문서를 결재할 권한이 있는지 검사
//        	Employee employee = approver.getEmployee();
//            Document document = approver.getDocument();
//            if (employee.getId() != document.getEmployee().getId()) {
//                return false;
//            }
//
//            // 문서 상태를 결재 중인 상태로 변경
//            document.setStatus(ApprovalStatus.APPROVING);
//            documentRepository.save(document);
//
//            // 결재자가 결재를 완료했으면 문서 상태를 결재 완료 상태로 변경
//            if (document.getApprover().stream().allMatch(Approver::isApproved)) {
//                document.setStatus(DocumentStatus.ApprovalStatus.APPROVED);
//                documentRepository.save(document);
//            }
//            
//
//            return true;
//        } else {
//            return false;
//        }
//        
//    }
//
//    public boolean holdDocument(Long id, String email) {
//        Approver approver = approverRepository.findById(id).orElse(null);
//        if (approver == null) {
//            return false;
//        }
//
//        if ("admin@gmail.com".equals(email)) {
//            // 여기에 보류 처리 로직 작성
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean rejectDocument(Long id, String email) {
//        Approver approver = approverRepository.findById(id).orElse(null);
//        if (approver == null) {
//            return false;
//        }
//
//        if ("admin@gmail.com".equals(email)) {
//            // 여기에 반려 처리 로직 작성
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//	public Approver getApprover(Long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//    
////  public void approveDocument(Long documentId, String approverEmail) {
////  Document document = documentRepository.findById(documentId) // empno로 바꿔야하나?
////      .orElseThrow(() -> new IllegalArgumentException("문서id가 잘못 되었습니다."));
////
////  Employee approver = empService.findByEmail(approverEmail)
////      .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));
////
////  if (!document.getApprover().getEmail().equals(approver.getEmail())) {
////      throw new IllegalArgumentException("권한이 없습니다.");
////  }
////
////  document.setStatus(DocumentStatus.APPROVED);
////  documentRepository.save(document);
////} 
////
////public void holdDocument(Long documentId, String approverEmail) {
////  Document document = documentRepository.findById(documentId)
////      .orElseThrow(() -> new IllegalArgumentException("문서id가 잘못 되었습니다."));
////
////  Employee approver = empService.findByEmail(approverEmail)
////      .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));
////
////  if (!document.getApprover().getEmail().equals(approver.getEmail())) {
////      throw new IllegalArgumentException("권한이 없습니다.");
////  }
////
////  document.setStatus(DocumentStatus.HOLD);
////  documentRepository.save(document);
////}
////
////public void rejectDocument(Long documentId, String approverEmail) {
////  Document document = documentRepository.findById(documentId)
////      .orElseThrow(() -> new IllegalArgumentException("문서id가 잘못 되었습니다."));
////
////  Employee approver = empService.findByEmail(approverEmail)
////      .orElseThrow(() -> new IllegalArgumentException("잘못된 이메일입니다."));
////
////  if (!document.getApprover().getEmail().equals(approver.getEmail())) {
////      throw new IllegalArgumentException("권한이 없습니다.");
////  }
////
////  document.setStatus(DocumentStatus.REJECTED);
////  documentRepository.save(document);
////}
//}