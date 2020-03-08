package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseErrorTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseSuccessTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

public final class BuilderResponse {

	private String requestId;

	private Boolean status;

	private Map<String, Object> response = new LinkedHashMap<String, Object>();

	private String code;

	private String message;

	public BuilderResponse addRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	public BuilderResponse addStatus(boolean status) {
		this.status = status;
		return this;
	}

	public BuilderResponse addResponse(Map<String, Object> response) {
		this.response.putAll(response);
		return this;
	}

	public BuilderResponse addResponse(String key, Object value) {
		this.response.put(key, value);
		return this;
	}

	public BuilderResponse addCode(String code) {
		this.code = code;
		return this;
	}

	public BuilderResponse addMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseTO build() throws SdkExceptions {
		if (status == null) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_REQUEST_ACTION);
		}
		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_REQUEST_ID);
		}

		ResponseTO response;
		if (!status) {
			if (code == null || code.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_CODE);
			}
			if (message == null || message.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_MESSAGE);
			}
			response = new ResponseErrorTO(requestId);
			((ResponseErrorTO) response).setCode(code);
			((ResponseErrorTO) response).setMessage(message);

		} else {
			if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_STATUS);
			}
			if (this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
				Object object = this.response.get(SdkConstants.ResponseFields.Mandatory.STATUS);
				Boolean bool = (object instanceof Boolean) ? (Boolean) object : false;

				if (!bool && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
					throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_CODE);
				} else if (bool && this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_CODE_NOT_NECESSARY);
				}
				if (!bool && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
					throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_MESSAGE);
				} else if (bool && this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_MESSAGE_NOT_NECESSARY);
				}
			}
			if (this.response == null || this.response.isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE);
			}
			if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.EVENT_NAME)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_EVENT_NAME);
			}

			if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.TYPE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_TYPE);
			}

			response = new ResponseSuccessTO(requestId);
			((ResponseSuccessTO) response).setResponse(this.response);
			((ResponseSuccessTO) response).setStatus(status);
		}
		return response;
	}
}
