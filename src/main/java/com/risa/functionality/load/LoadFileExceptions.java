package com.risa.functionality.load;

public class LoadFileExceptions extends Exception {
    /**
     * Error codes :
     * 1 -> Error when oppenning and reading file.
     * 2 -> Error when valueOfTypeRoute or valueOfTypeLieu returns null value.
     */
    private final int errorCode;

    public LoadFileExceptions(int errorCode) {
        this.errorCode = errorCode;
    }
}
