package br.com.cpqd.avm.sdk.v1.model.to;

import java.io.Serializable;
import java.util.Map;

public class RequestAvmTO implements Serializable {

	private static final long serialVersionUID = 5791849205603413511L;

	private String requestId;

	private String company;

	private String portfolio;

	private String token;

	private String action;

	private Map<String, Object> params;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + requestId + ", company=" + company + ", portfolio=" + portfolio + ", token="
				+ token + ", action=" + action + "]";
	}

}
