package br.com.cpqd.avm.sdk.v1.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class SdkExceptions extends Exception {

	Locale locale = new Locale.Builder().build();
	ResourceBundle bundle = ResourceBundle.getBundle("exceptions", locale);
	
	private static final long serialVersionUID = -4938380884798482666L;

	public SdkExceptions(String error) {
		super(error);
		String message = bundle.getString(error);
		//message = MessageFormat.format(message, "André", "Nicoletti");
		System.out.println(message);
	}
	
}
