package br.com.cpqd.avm.sdk.v1.model.to;

public class ResponseErrorTO extends ResponseTO {

	private static final long serialVersionUID = -4588269257222094048L;

	private String code;

	private String message;

	public ResponseErrorTO(String requestId) {
		super.requestId = requestId;
		super.status = false;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
