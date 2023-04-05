package com.groupware.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
//NotExistException이랑 통합하고 결재 관련 컨트롤러, 서비스에서도 통합 해줘야 하는게 나은거 같음.