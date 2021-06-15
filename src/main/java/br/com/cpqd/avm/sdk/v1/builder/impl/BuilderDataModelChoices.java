package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.cpqd.avm.sdk.v1.model.to.Choices;
import br.com.cpqd.avm.sdk.v1.model.to.ShortText;
import br.com.cpqd.avm.sdk.v1.model.to.Voice;

@Deprecated
public class BuilderDataModelChoices {

	private Choices choicesTO = new Choices();

	private List<Voice> listVoiceTO = new ArrayList<Voice>();
	
	public BuilderDataModelChoices addImage(String imageUrl) {
		choicesTO.setImageUrl(imageUrl);
		return this;
	}

	public BuilderDataModelChoices addText(String text) {
		choicesTO.setImageUrl(text);
		return this;
	}

	public BuilderDataModelChoices addValue(String value) {
		choicesTO.setValue(value);
		return this;
	}

	public BuilderDataModelChoices addMatch(String match) {
		choicesTO.setMatch(match);
		return this;
	}

	public BuilderDataModelChoices addUrl(String url) {
		choicesTO.setUrl(url);
		return this;
	}

	public BuilderDataModelChoices addQuickReply(boolean quick_reply) {
		choicesTO.setQuick_reply(quick_reply);
		return this;
	}

	public BuilderDataModelChoices addShortText(ShortText shortText) {
		choicesTO.setShort_text(shortText);
		return this;
	}

	public BuilderDataModelChoices addVoice(Voice voice) {
		this.listVoiceTO.add(voice);
		return this;
	}

	public Choices build() {
		choicesTO.setVoice(listVoiceTO);
		return this.choicesTO;
	}
}
