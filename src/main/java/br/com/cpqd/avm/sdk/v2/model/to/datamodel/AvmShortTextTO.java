package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

public class AvmShortTextTO {

	private String text;

	private AvmShortTextTO(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public static class Builder {

		private String text;

		public Builder addText(String text) {
			this.text = text;
			return this;
		}

		public AvmShortTextTO build() {
			return new AvmShortTextTO(text);
		}

	}

}
