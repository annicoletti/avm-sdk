package br.com.cpqd.avm.sdk.v1.builder.impl;

import br.com.cpqd.avm.sdk.v1.model.to.ShortText;

@Deprecated
public class BuilderDataModelShortText {

	private ShortText shortTextTO = new ShortText();

	public BuilderDataModelShortText addText(String text) {
		shortTextTO.setText(text);
		return this;
	}

	public ShortText build() {
		return this.shortTextTO;
	}
}
