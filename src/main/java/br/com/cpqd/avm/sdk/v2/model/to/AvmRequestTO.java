package br.com.cpqd.avm.sdk.v2.model.to;

import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;
import br.com.cpqd.avm.sdk.v2.builder.api.AvmValidateBean;

public class AvmRequestTO {

	private String requestId;

	private String company;

	private String portfolio;

	private String token;

	private String action;

	private Map<String, Object> params;

	private AvmRequestTO(String requestId, String company, String portfolio, String token, String action,
			Map<String, Object> params) {
		this.requestId = requestId;
		this.company = company;
		this.portfolio = portfolio;
		this.token = token;
		this.action = action;
		this.params = params;
	}

	public String getRequestId() {
		return requestId;
	}

	public String getCompany() {
		return company;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public String getToken() {
		return token;
	}

	public String getAction() {
		return action;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public static class Builder implements AvmValidateBean {

		private String requestId;

		private String company;

		private String portfolio;

		private String token;

		private String action;

		private Map<String, Object> params = new LinkedHashMap<>();

		public Builder addRequestId(String requestId) {
			this.requestId = requestId;
			return this;
		}

		public Builder addCompany(String company) {
			this.company = company;
			return this;
		}

		public Builder addPortfolio(String portfolio) {
			this.portfolio = portfolio;
			return this;
		}

		public Builder addToken(String token) {
			this.token = token;
			return this;
		}

		public Builder addAction(String action) {
			this.action = action;
			return this;
		}

		public Builder addParams(Map<String, Object> params) {
			this.params.putAll(params);
			return this;
		}

		public Builder addParams(String key, Object value) {
			this.params.put(key, value);
			return this;
		}

		public AvmRequestTO build() throws SdkExceptions {
			validate();
			return new AvmRequestTO(requestId, company, portfolio, token, action, params);
		}

		@SuppressWarnings("unchecked")
		public Builder parseFromMap(Map<String, Object> params) {

			if (params.containsKey(SdkConstants.RequestFields.ACTION)) {
				action = (String) params.get(SdkConstants.RequestFields.ACTION);
				params.remove(SdkConstants.RequestFields.ACTION);
			}

			if (params.containsKey(SdkConstants.RequestFields.COMPANY)) {
				company = (String) params.get(SdkConstants.RequestFields.COMPANY);
				params.remove(SdkConstants.RequestFields.COMPANY);
			}

			if (params.containsKey(SdkConstants.RequestFields.PORTFOLIO)) {
				portfolio = (String) params.get(SdkConstants.RequestFields.PORTFOLIO);
				params.remove(SdkConstants.RequestFields.PORTFOLIO);
			}

			if (params.containsKey(SdkConstants.RequestFields.REQUEST_ID)) {
				requestId = (String) params.get(SdkConstants.RequestFields.REQUEST_ID);
				params.remove(SdkConstants.RequestFields.REQUEST_ID);
			}

			if (params.containsKey(SdkConstants.RequestFields.TOKEN)) {
				token = (String) params.get(SdkConstants.RequestFields.TOKEN);
				params.remove(SdkConstants.RequestFields.TOKEN);
			}

			if (params.containsKey(SdkConstants.RequestFields.PARAMETERS)) {
				Object objParams = params.get(SdkConstants.RequestFields.PARAMETERS);
				params.remove(SdkConstants.RequestFields.PARAMETERS);
				if (objParams instanceof Map) {
					Map<String, Object> map = (Map<String, Object>) objParams;
					addParams(map);
				}
			}

			if (!params.isEmpty()) {
				addParams(params);
			}

			return this;
		}

		public Builder parseFromJson(String json) {
			JSONObject jsonObject = new JSONObject(json);
			return this.parseFromJson(jsonObject);
		}

		public Builder parseFromJson(JSONObject json) {
			return this.parseFromMap(json.toMap());
		}

		@Override
		public void validate() throws SdkExceptions {

			if (requestId == null || requestId.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__REQUEST_AVM__REQUEST_ID);
			}

			if (action == null || action.trim().isEmpty()) {
				throw new SdkExceptions(SdkConstantsExceptions.Builder.EXCEPTION__REQUEST_AVM__ACTION);
			}
		}

	}

}
