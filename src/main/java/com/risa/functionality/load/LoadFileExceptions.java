package com.risa.functionality.load;

public class LoadFileExceptions extends Exception {
    /**
     * Error codes :
     * 1 -> Error when oppenning and reading file.
     * 2 ->
     */
    private final int errorCode;

    public LoadFileExceptions(int errorCode) {
        this.errorCode = errorCode;
    }
}
