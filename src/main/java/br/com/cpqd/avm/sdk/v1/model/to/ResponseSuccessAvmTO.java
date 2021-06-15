package br.com.cpqd.avm.sdk.v1.model.to;

import java.util.Map;

@Deprecated
public class ResponseSuccessAvmTO extends ResponseAvmTO {

	private static final long serialVersionUID = -2221919017435299919L;

	private Map<String, Object> response;

	public ResponseSuccessAvmTO(String requestId) {
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
