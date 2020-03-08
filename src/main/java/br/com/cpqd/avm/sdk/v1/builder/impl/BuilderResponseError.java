package br.com.cpqd.avm.sdk.v1.builder.impl;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseErrorTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

public final class BuilderResponseError {

	private String requestId;

	private Boolean status = false;

	private String code;

	private String message;

	public BuilderResponseError addRequestId(RequestTO requestTO) {
		this.requestId = requestTO.getRequestId();
		return this;
	}

	public BuilderResponseError addRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	public BuilderResponseError addCode(String code) {
		this.code = code;
		return this;
	}

	public BuilderResponseError addMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseTO build() throws SdkExceptions {
		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_REQUEST_ID);
		}

		if (code == null || code.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_CODE);
		}

		if (message == null || message.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_MESSAGE);
		}

		ResponseErrorTO response = new ResponseErrorTO(requestId);
		response.setStatus(status);
		response.setCode(code);
		response.setMessage(message);
		return response;
	}
}
