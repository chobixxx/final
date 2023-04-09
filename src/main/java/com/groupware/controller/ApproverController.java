//package com.groupware.controller;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.groupware.entity.Approver;
//import com.groupware.entity.Document;
//import com.groupware.entity.Employee;
//import com.groupware.repository.ApproverRepository;
//import com.groupware.repository.DocumentRepository;
//import com.groupware.service.ApproverService;
//import com.groupware.service.DocumentStatus;
//import com.groupware.service.EmpService;
//
//@RestController
//@RequestMapping("/approver")
//public class ApproverController {
//	
//	@Autowired
//	private ApproverRepository approverRepository;
//	
//    @Autowired
//    private DocumentRepository documentRepository;
//    
//	 @Autowired
//	    private ApproverService approverService;
//
//	    @Autowired
//	    private EmpService empService;
//	    
//	  //admin 계정으로 로그인
//		@RequestMapping(value = "/adminmain", method = RequestMethod.GET)
//		public String adminMain(HttpSession session, Model model) {
//		    String userRole = (String) session.getAttribute("userRole");
//		    if (userRole != null && userRole.equals("admin")) {
//		        return "adminmain";
//		    } else {
//		        return "redirect:/"; // 관리자가 아닐 경우, 로그인 페이지로 이동
//		    }
//		}
//
//	    @PostMapping("/{id}")
//	    public ResponseEntity<String> approveDocument(@PathVariable Long id, @RequestParam String email, @RequestParam(required = false) String status) {
//	        // 사용자 인증
//	        Employee employee = empService.findByEmail(email);
//	        if (employee == null) {
//	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
//	        }
//
//	        // 관리자 권한 검사
//	        if (!"admin@gmail.com".equals(email) || !"admin".equals(employee.getRole())) {
//	            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//	        }
//
//	        // 결재자가 결재 가능한 문서를 가져옴
//	        Approver approver = approverService.getApprover(id);
//	        if (approver == null) {
//	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	        }
//
//	        // 해당 결재자가 이 문서를 결재할 권한이 있는지 검사
//	        Document document = approver.getDocument();
//	        if (employee.getId() != document.getId()) {
//	            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//	        }
//
//	        // 문서 상태를 변경
//	        if ("approve".equals(status)) {
//	            document.setStatus(DocumentStatus.ApprovalStatus.APPROVING);
//	        } else if ("hold".equals(status)) {
//	            document.setStatus(DocumentStatus.ApprovalStatus.HOLD);
//	        } else if ("reject".equals(status)) {
//	            document.setStatus(DocumentStatus.ApprovalStatus.REJECTED);
//	        } else {
//	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid status");
//	        }
//	        approver.setApprovedBy(employee);
//	        documentRepository.save(document);
//	        approverRepository.save(approver);
//
//	        return ResponseEntity.ok().body("Success");
//	    }
//}
//
////    @Autowired
////    private ApproverService approverService;
////    
////    @Autowired
////    private ApproverRepository approverRepository;
////
//// // 이메일이 admin@gmail.com이면 결재 가능
////    @PostMapping("/{id}/approve")
////    public ResponseEntity<Object> approveDocument(@PathVariable Long id) {
////        Approver approver = approverRepository.findById(id).orElse(null);
////        if (approver == null) {
////            return ResponseEntity.notFound().build();
////        }
////
////        // 이메일이 admin@gmail.com이면 결재 가능
////        if ("admin@gmail.com".equals(approver.getEmail())) {
////            // 여기에 결재 처리 로직 작성
////            return ResponseEntity.ok().build();
////        } else {
////            return ResponseEntity.badRequest().body("결재권한이 없습니다.");
////        }
////    }
////
////    // 이메일이 admin@gmail.com이면 보류 가능
////    @PostMapping("/{id}/hold")
////    public ResponseEntity<Object> holdDocument(@PathVariable Long id) {
////        Approver approver = approverRepository.findById(id).orElse(null);
////        if (approver == null) {
////            return ResponseEntity.notFound().build();
////        }
////
////        // 이메일이 admin@gmail.com이면 보류 가능
////        if ("admin@gmail.com".equals(approver.getEmail())) {
////            // 여기에 보류 처리 로직 작성
////            return ResponseEntity.ok().build();
////        } else {
////            return ResponseEntity.badRequest().body("보류권한이 없습니다.");
////        }
////    }
////
////    // 이메일이 admin@gmail.com이면 반려 가능
////    @PostMapping("/{id}/reject")
////    public ResponseEntity<Object> rejectDocument(@PathVariable Long id) {
////        Approver approver = approverRepository.findById(id).orElse(null);
////        if (approver == null) {
////            return ResponseEntity.notFound().build();
////        }
////
////        // 이메일이 admin@gmail.com이면 반려 가능
////        if ("admin@gmail.com".equals(approver.getEmail())) {
////            // 여기에 반려 처리 로직 작성
////            return ResponseEntity.ok().build();
////        } else {
////            return ResponseEntity.badRequest().body("반려권한이 없습니다.");
////        }
////    }
////}