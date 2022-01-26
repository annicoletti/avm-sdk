package br.com.cpqd.avm.sdk.v2.model.to;

public abstract class AvmResponseTO {

	protected String requestId;

	protected Boolean status;

	public AvmResponseTO(String requestId, Boolean status) {
		this.requestId = requestId;
		this.status = status;
	}

	public String getRequestId() {
		return requestId;
	}

	public Boolean getStatus() {
		return status;
	}
}
