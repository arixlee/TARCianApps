package com.example.ysbeh.tarcianapps;

import java.io.Serializable;


/**
 * Created by Lee on 09-Dec-16.
 */

public class ReportFalse implements Serializable {
    private String errorMessage;
    private int errorType;

    public ReportFalse(){

    }
    public ReportFalse(int errorType, String errorMessage) {
        this.errorType = errorType;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorType() {
        return errorType;
    }

    public void setErrorType(int errorType) {
        this.errorType = errorType;
    }
}
