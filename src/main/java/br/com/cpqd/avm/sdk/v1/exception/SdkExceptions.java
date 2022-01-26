package br.com.cpqd.avm.sdk.v1.exception;

import java.util.Locale;
import java.util.ResourceBundle;

public class SdkExceptions extends Exception {

	private static final long serialVersionUID = -4938380884798482666L;

	private Locale locale = new Locale.Builder().build();

	private ResourceBundle bundle = ResourceBundle.getBundle("exceptions", locale);

	private String message;

	private String code;

	public SdkExceptions(String codeError) {
		this.message = bundle.getString(codeError);
		this.code = codeError;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
