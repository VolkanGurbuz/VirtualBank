package com.volkangurbuz.customercreationservice.utilities.results;

public class ErrorResult extends Result {
    public ErrorResult(boolean success, String message) {
        super(false, message);
    }
}
