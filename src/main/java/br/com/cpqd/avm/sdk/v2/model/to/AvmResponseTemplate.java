package br.com.cpqd.avm.sdk.v2.model.to;

import java.util.LinkedHashMap;
import java.util.Map;

public class AvmResponseTemplate {

	private Map<String, Object> responses;

	private AvmResponseTemplate(Map<String, Object> responses) {
		this.responses = responses;
	}

	public Map<String, Object> getResponses() {
		return responses;
	}

	public static class Builder {

		private Map<String, Object> responses = new LinkedHashMap<>();

		private static final String PREFIX_AVM_RESPONSE_TEMPLATE = "avmResponseTemplate_";

		private static final String CONTENT_TEMPLATE = "{\"text\":\"%s\"}";

		private int indice = 1;

		public Builder addResponseText(String text) {
			String key = PREFIX_AVM_RESPONSE_TEMPLATE + indice++;
			responses.put(key, String.format(CONTENT_TEMPLATE, text));
			return this;
		}

		public AvmResponseTemplate build() {
			return new AvmResponseTemplate(responses);
		}

	}
}
