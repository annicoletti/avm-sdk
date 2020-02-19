package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.cpqd.avm.sdk.v1.builder.api.DataModel;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseErrorTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseSuccessTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseTO;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

public final class BuilderResponseSuccess {

	private String requestId;

	private Boolean status;

	private Map<String, Object> response = new LinkedHashMap<String, Object>();

	private String code;

	private String message;

	public BuilderResponseSuccess addRequestId(RequestTO requestTO) {
		this.requestId = requestTO.getRequestId();
		return this;
	}

	public BuilderResponseSuccess addStatus(boolean status) {
		this.status = status;
		return this;
	}

	public BuilderResponseSuccess addResponse(Map<String, Object> response) {
		this.response.putAll(response);
		return this;
	}

	public BuilderResponseSuccess addResponse(String key, Object value) {
		this.response.put(key, value);
		return this;
	}

	public BuilderResponseSuccess addType(String type) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.TYPE, type);
		return this;
	}

	public BuilderResponseSuccess addEventName(RequestTO requestTO) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.EVENT_NAME, requestTO.getAction());
		return this;
	}

	public BuilderResponseSuccess addDataModel(DataModel datamodel) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.DATA_MODEL, datamodel);
		return this;
	}

	public BuilderResponseSuccess addCode(String code) {
		this.code = code;
		return this;
	}

	public BuilderResponseSuccess addMessage(String message) {
		this.message = message;
		return this;
	}

	public ResponseTO build() throws SdkExceptions {
		ResponseSuccessTO response;
		this.response.put(SdkConstants.ResponseFields.Mandatory.STATUS, true);

		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_REQUEST_ID);
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_STATUS);
		}
		
		if (this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
			Object object = this.response.get(SdkConstants.ResponseFields.Mandatory.STATUS);
			Boolean bool = (object instanceof Boolean) ? (Boolean) object : false;

			if (!bool && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_CODE);
			} else if (bool && this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_CODE_NOT_NECESSARY);
			}
			if (!bool && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_MESSAGE);
			} else if (bool && this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_MESSAGE_NOT_NECESSARY);
			}
		}
		
		if (this.response == null || this.response.size() <= 0) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE);
		}
		
		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.EVENT_NAME)) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_EVENT_NAME);
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.TYPE)) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_TYPE);
		}

		response = new ResponseSuccessTO(requestId);
		response.setResponse(this.response);
		response.setStatus(status);
		return response;
	}
}
