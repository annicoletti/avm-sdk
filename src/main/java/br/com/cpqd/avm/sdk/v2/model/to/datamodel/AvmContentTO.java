package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

public class AvmContentTO {

	private String text;

	private String value;

	private String match;

	private AvmContentTO(String text, String value, String match) {
		this.text = text;
		this.value = value;
		this.match = match;
	}

	public String getText() {
		return text;
	}

	public String getValue() {
		return value;
	}

	public String getMatch() {
		return match;
	}

	public static class Builder {

		private String text;

		private String value;

		private String match;

		public Builder addText(String texto) {
			this.text = texto;
			return this;
		}

		public Builder addValue(String value) {
			this.value = value;
			return this;
		}

		public Builder addMatch(String match) {
			this.match = match;
			return this;
		}

		public AvmContentTO build() {
			return new AvmContentTO(text, value, match);
		}

	}

}
