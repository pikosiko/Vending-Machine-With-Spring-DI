package com.sg.vendingmachine.calc;

public class InsufficientFundsException extends Exception{



    public InsufficientFundsException() {

    }

    public InsufficientFundsException(String message){
        super(message);
    }

    public InsufficientFundsException(String message, Throwable cause) {
        super(message, cause);
    }
}
