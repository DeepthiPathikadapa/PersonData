package com.sboot.person.exception;

public class PersonNotfoundException extends RuntimeException {
   private static final long serialVersionUID = 1L;
   
   public PersonNotfoundException(String msg) {
	   super(msg);
   }
}

