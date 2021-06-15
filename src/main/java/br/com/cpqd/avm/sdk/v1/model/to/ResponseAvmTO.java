package br.com.cpqd.avm.sdk.v1.model.to;

import java.io.Serializable;

@Deprecated
public class ResponseAvmTO implements Serializable {

	private static final long serialVersionUID = -2875047698537499968L;

	protected String requestId;

	protected Boolean status;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

}
