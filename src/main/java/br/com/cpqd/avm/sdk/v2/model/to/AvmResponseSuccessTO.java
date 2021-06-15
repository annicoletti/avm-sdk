package br.com.cpqd.avm.sdk.v2.model.to;

import java.util.LinkedHashMap;
import java.util.Map;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;
import br.com.cpqd.avm.sdk.v2.builder.api.AvmDataModel;
import br.com.cpqd.avm.sdk.v2.builder.api.AvmValidateBean;
import br.com.cpqd.avm.sdk.v2.enums.AvmResponseError;
import br.com.cpqd.avm.sdk.v2.enums.AvmResponseSuccess;
import br.com.cpqd.avm.sdk.v2.enums.AvmType;

public class AvmResponseSuccessTO extends AvmResponseTO {

	private Map<String, Object> response;

	private AvmResponseSuccessTO(String requestId, Map<String, Object> response) {
		super(requestId, Boolean.TRUE);
		this.response = response;
	}

	public Map<String, Object> getResponse() {
		return response;
	}

	public void setResponse(Map<String, Object> response) {
		this.response = response;
	}

	public static class Builder implements AvmValidateBean {

		private String requestId;

		private Map<String, Object> response = new LinkedHashMap<>();

		public Builder addDefaults(AvmRequestTO avmRequestTO) {
			this.requestId = avmRequestTO.getRequestId();
			this.response.put(SdkConstants.ResponseFields.Mandatory.EVENT_NAME, avmRequestTO.getAction());
			return this;
		}

		public Builder addResponse(Map<String, Object> response) {
			this.response.putAll(response);
			return this;
		}

		public Builder addResponse(String key, Object value) {
			this.response.put(key, value);
			return this;
		}

		public Builder addDataModel(AvmDataModel datamodel) {
			this.response.put(SdkConstants.ResponseFields.Mandatory.DATA_MODEL, datamodel);
			this.response.put(SdkConstants.ResponseFields.Mandatory.TYPE, datamodel.getType());
			return this;
		}

		public Builder addType(AvmType avmType) {
			if (!response.containsKey(SdkConstants.ResponseFields.Mandatory.TYPE)) {
				this.response.put(SdkConstants.ResponseFields.Mandatory.TYPE, avmType);
			}
			return this;
		}

		public Builder addResponse(AvmResponseSuccess avmResponseSuccess, Object value) {
			this.response.put(avmResponseSuccess.getValor(), value);
			return this;
		}

		public Builder addResponseWithError(AvmResponseError avmResponseError, Object value) {
			this.response.put(avmResponseError.getValor(), value);
			return this;
		}

		public AvmResponseSuccessTO build() throws SdkExceptions {
			validate();
			return new AvmResponseSuccessTO(requestId, response);
		}

		@Override
		public void validate() throws SdkExceptions {

			if (this.response == null || this.response.isEmpty()) {
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

				if (bool.equals(false)
						&& !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
					throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_CODE);

				} else if (bool.equals(true)
						&& this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_CODE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_CODE__NOT_REQUIRED);
				}
				if (bool.equals(false)
						&& !this.response.containsKey(SdkConstants.ResponseFields.Mandatory.ERROR_MESSAGE)) {
					throw new SdkExceptions(
							SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_SUCCESS_AVM__ERROR_MESSAGE);

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

		}

	}

}
