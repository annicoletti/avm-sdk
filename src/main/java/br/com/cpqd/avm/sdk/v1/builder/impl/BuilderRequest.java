package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestTO;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

public final class BuilderRequest {

	private String requestId;

	private String company;

	private String portfolio;

	private String token;

	private String action;

	private HashMap<String, Object> params;

	public BuilderRequest addRequestId(String requestId) {
		this.requestId = requestId;
		return this;
	}

	public BuilderRequest addCompany(String company) {
		this.company = company;
		return this;
	}

	public BuilderRequest addPortfolio(String portfolio) {
		this.portfolio = portfolio;
		return this;
	}

	public BuilderRequest addToken(String token) {
		this.token = token;
		return this;
	}

	public BuilderRequest addAction(String action) {
		this.action = action;
		return this;
	}

	public BuilderRequest addParam(Map<String, Object> params) {
		if (this.params == null) {
			this.params = new HashMap<String, Object>();
		}
		this.params.putAll(params);
		return this;
	}

	public BuilderRequest addParam(String key, String value) {
		if (this.params == null) {
			this.params = new HashMap<String, Object>();
		}
		this.params.put(key, value);
		return this;
	}

	public BuilderRequest parseFromJSON(String request) {
		JSONObject json = new JSONObject(request);
		if (json.has(SdkConstants.RequestFields.ACTION)) {
			action = json.getString(SdkConstants.RequestFields.ACTION);
		}
		if (json.has(SdkConstants.RequestFields.COMPANY)) {
			company = json.getString(SdkConstants.RequestFields.COMPANY);
		}
		if (json.has(SdkConstants.RequestFields.PORTFOLIO)) {
			portfolio = json.getString(SdkConstants.RequestFields.PORTFOLIO);
		}
		if (json.has(SdkConstants.RequestFields.REQUEST_ID)) {
			requestId = json.getString(SdkConstants.RequestFields.REQUEST_ID);
		}
		if (json.has(SdkConstants.RequestFields.TOKEN)) {
			token = json.getString(SdkConstants.RequestFields.TOKEN);
		}
		return this;
	}

	public RequestTO build() throws SdkExceptions {
		if (requestId == null || requestId.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_REQUEST_REQUEST_ID);
		}
		if (action == null || action.trim().isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_REQUEST_ACTION);
		}
		RequestTO request = new RequestTO();
		request.setAction(action);
		request.setCompany(company);
		request.setPortfolio(portfolio);
		request.setRequestId(requestId);
		request.setToken(token);
		return request;
	}

}
