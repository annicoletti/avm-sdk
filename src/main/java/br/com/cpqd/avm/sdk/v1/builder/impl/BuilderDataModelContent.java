package br.com.cpqd.avm.sdk.v1.builder.impl;

import br.com.cpqd.avm.sdk.v1.model.to.Content;

@Deprecated
public class BuilderDataModelContent {

	private Content contentTO = new Content();

	public BuilderDataModelContent addText(String text) {
		contentTO.setText(text);
		return this;
	}

	public BuilderDataModelContent addValue(String value) {
		contentTO.setValue(value);
		return this;
	}

	public BuilderDataModelContent addMatch(String match) {
		contentTO.setMatch(match);
		return this;
	}

	public Content build() {
		return contentTO;
	}

}
