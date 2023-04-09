package com.groupware.service;

public enum DocumentStatus {
    PENDING("결재대기중"),
    APPROVED("결재완료"),
    REJECTED("반려"),
    HOLD("보류");

    private String text;

    DocumentStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public enum ApprovalStatus {
        APPROVING("결재 중"),
        APPROVED("결재 완료"),
        REJECTED("반려"),
        HOLD("보류");

        private String text;

        ApprovalStatus(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}