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

@Deprecated
public final class BuilderResponseSuccess {

	private String requestId;

	private Boolean status = true;

	private Map<String, Object> response = new LinkedHashMap<String, Object>();

	@Deprecated
	public BuilderResponseSuccess addRequestId(RequestAvmTO requestTO) {
		this.requestId = requestTO.getRequestId();
		return this;
	}

	@Deprecated
	public BuilderResponseSuccess addRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	@Deprecated
	public BuilderResponseSuccess addResponse(Map<String, Object> response) {
		this.response.putAll(response);
		return this;
	}

	@Deprecated
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

	@Deprecated
	public BuilderResponseSuccess addType(EnumType EnumType) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.TYPE, EnumType);
		return this;
	}

	@Deprecated
	public BuilderResponseSuccess addEventName(RequestAvmTO requestTO) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.EVENT_NAME, requestTO.getAction());
		return this;
	}

	@Deprecated
	public BuilderResponseSuccess addEventName(String action) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.EVENT_NAME, action);
		return this;
	}

	@Deprecated
	public BuilderResponseSuccess addDataModel(DataModel datamodel) {
		this.response.put(SdkConstants.ResponseFields.Mandatory.DATA_MODEL, datamodel);
		return this;
	}

	@Deprecated
	public ResponseAvmTO build() throws SdkExceptions {

		if (this.response == null || this.response.size() <= 0) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__RESPONSE);
		}

		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__REQUEST_ID);
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__STATUS);
		}

		if (this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
			Object object = this.response.get(SdkConstants.ResponseFields.Mandatory.STATUS);
			Boolean bool = (object instanceof Boolean) ? (Boolean) object : false;

			if (bool.equals(false) && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_CODE);

			} else if (bool.equals(true)
					&& this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
				throw new SdkExceptions(
						SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_CODE__NOT_REQUIRED);
			}
			if (bool.equals(false) && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_MESSAGE);

			} else if (bool.equals(true)
					&& this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
				throw new SdkExceptions(
						SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_MESSAGE__NOT_REQUIRED);
			}
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.EVENT_NAME)) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__EVENT_NAME);
		}

		if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.TYPE)) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__TYPE);
		}

		ResponseSuccessAvmTO response = new ResponseSuccessAvmTO(requestId);
		response.setResponse(this.response);
		response.setStatus(status);
		return response;
	}
}
