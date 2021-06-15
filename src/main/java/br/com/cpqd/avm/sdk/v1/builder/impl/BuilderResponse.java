package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmErrorTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseSuccessAvmTO;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

@Deprecated
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

	public ResponseAvmTO build() throws SdkExceptions {

		if (status == null) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_AVM__STATUS);
		}

		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_AVM__REQUEST_ID);
		}

		ResponseAvmTO response;
		if (!status) {

			if (code == null || code.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_FAILED_AVM__CODE);
			}

			if (message == null || message.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_FAILED_AVM__MESSAGE);
			}

			response = new ResponseAvmErrorTO(requestId);
			((ResponseAvmErrorTO) response).setCode(code);
			((ResponseAvmErrorTO) response).setMessage(message);

		} else {

			if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__STATUS);
			}

			if (this.response.containsKey(SdkConstants.ResponseFields.Mandatory.STATUS)) {

				Object object = this.response.get(SdkConstants.ResponseFields.Mandatory.STATUS);
				Boolean bool = (object instanceof Boolean) ? (Boolean) object : Boolean.FALSE;

				if (!bool && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
					throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_CODE);

				} else if (bool && this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_CODE__NOT_REQUIRED);
				}

				if (!bool && !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_MESSAGE);

				} else if (bool && this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_MESSAGE__NOT_REQUIRED);
				}
			}
			
			if (this.response == null || this.response.isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__RESPONSE);
			}
			
			if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.EVENT_NAME)) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__EVENT_NAME);
			}

			if (!this.response.containsKey(SdkConstants.ResponseFields.Mandatory.TYPE)) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__TYPE);
			}

			response = new ResponseSuccessAvmTO(requestId);
			((ResponseSuccessAvmTO) response).setResponse(this.response);
			((ResponseSuccessAvmTO) response).setStatus(status);
		}
		return response;
	}
}
