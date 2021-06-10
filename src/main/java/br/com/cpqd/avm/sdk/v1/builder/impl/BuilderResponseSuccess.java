package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.cpqd.avm.sdk.v1.builder.api.DataModel;
import br.com.cpqd.avm.sdk.v1.enums.EnumResponseError;
import br.com.cpqd.avm.sdk.v1.enums.EnumResponseSuccess;
import br.com.cpqd.avm.sdk.v1.enums.EnumType;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseSuccessAvmTO;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

public final class BuilderResponseSuccess {

	private String requestId;

	private Boolean status = true;

	private Map<String, Object> response = new LinkedHashMap<String, Object>();

	public BuilderResponseSuccess addRequestId(RequestAvmTO requestTO) {
		this.requestId = requestTO.getRequestId();
		return this;
	}

	public BuilderResponseSuccess addRequestId(String requestId) {
		this.requestId = requestId;
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

	public BuilderResponseSuccess addResponse(EnumResponseSuccess EnumResponseSuccess, Object value) {
		this.response.put(EnumResponseSuccess.getValor(), value);
		return this;
	}
	
	public BuilderResponseSuccess addResponseWithError(EnumResponseError EnumResponseError, Object value) {
		this.response.put(EnumResponseError.getValor(), value);
		return this;
	}

	public BuilderResponseSuccess addType(EnumType EnumType) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.TYPE, EnumType);
		return this;
	}

	public BuilderResponseSuccess addEventName(RequestAvmTO requestTO) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.EVENT_NAME, requestTO.getAction());
		return this;
	}
	
	public BuilderResponseSuccess addEventName(String action) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.EVENT_NAME, action);
		return this;
	}

	public BuilderResponseSuccess addDataModel(DataModel datamodel) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.DATA_MODEL, datamodel);
		return this;
	}

	public ResponseAvmTO build() throws SdkExceptions {

		if (this.response == null || this.response.size() <= 0) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE);
		}

		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_REQUEST_ID);
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_STATUS);
		}

		if (this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
			Object object = this.response.get(SdkConstants.ResponseFields.Mandatory.STATUS);
			Boolean bool = (object instanceof Boolean) ? (Boolean) object : false;

			if (bool.equals(false) && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_CODE);
			} else if (bool.equals(true)
					&& this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_CODE_NOT_NECESSARY);
			}
			if (bool.equals(false) && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_MESSAGE);
			} else if (bool.equals(true)
					&& this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
				throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_ERROR_MESSAGE_NOT_NECESSARY);
			}
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.EVENT_NAME)) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_EVENT_NAME);
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.TYPE)) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_RESPONSE_RESPONSE_TYPE);
		}

		ResponseSuccessAvmTO response = new ResponseSuccessAvmTO(requestId);
		response.setResponse(this.response);
		response.setStatus(status);
		return response;
	}
}
