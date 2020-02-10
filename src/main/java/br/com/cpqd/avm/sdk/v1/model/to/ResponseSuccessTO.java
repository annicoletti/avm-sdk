package br.com.cpqd.avm.sdk.v1.model.to;

import java.util.Map;

public class ResponseSuccessTO extends ResponseTO {

	private static final long serialVersionUID = -2221919017435299919L;

	private Map<String, Object> response;

	public ResponseSuccessTO(String requestId) {
		super.requestId = requestId;
		super.status = true;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

}
