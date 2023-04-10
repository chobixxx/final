package com.groupware.service;

public enum DocumentStatus {
    결재대기중("결재대기중"),
    결재완료("결재완료"),
    반려("반려"),
    보류("보류");

    private String text;

    DocumentStatus(String text) {
        this.text = text;
    }
    
    public static DocumentStatus fromText(String text) {
        for (DocumentStatus status : DocumentStatus.values()) {
            if (status.getText().equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid document status: " + text);
    }

    public String getText() {
        return text;
    }

    public static DocumentStatus fromString(String text) {
        for (DocumentStatus status : DocumentStatus.values()) {
            if (status.text.equalsIgnoreCase(text)) {
                return status;
            }
        }
        return null;
    }
}