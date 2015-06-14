package com.myprojects.anomalymanager.exception;

@SuppressWarnings("serial")
public class ObjectNotFoundException extends Exception {
	private static String msg = "l'element que vous cherchez n'existe pas!!";

	public ObjectNotFoundException() {
		super(msg);
	}

	public static void main(String[] args) {
		ObjectNotFoundException oException = new ObjectNotFoundException();
		System.out.println(oException.getMessage());
	}
}
