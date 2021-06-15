package br.com.cpqd.avm.sdk.v2.model.to;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;
import br.com.cpqd.avm.sdk.v2.builder.api.AvmValidateBean;

public class AvmResponseErrorTO extends AvmResponseTO {

	private String code;

	private String message;

	private AvmResponseErrorTO(String requestId, String code, String message) {
		super(requestId, Boolean.FALSE);
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static class Builder implements AvmValidateBean {

		private String code;

		private String message;

		private String requestId;

		public Builder addCode(String code) {
			this.code = code;
			return this;
		}

		public Builder addMessage(String message) {
			this.message = message;
			return this;
		}

		public Builder addRequestId(String requestId) {
			this.requestId = requestId;
			return this;
		}

		public AvmResponseErrorTO build() throws SdkExceptions {
			validate();
			return new AvmResponseErrorTO(requestId, code, message);
		}

		@Override
		public void validate() throws SdkExceptions {

			if (requestId == null || requestId.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_FAILED_AVM__REQUEST_ID);
			}

			if (code == null || code.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_FAILED_AVM__CODE);
			}

			if (message == null || message.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__RESPONSE_FAILED_AVM__MESSAGE);
			}

		}

	}

}
