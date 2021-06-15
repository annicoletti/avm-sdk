package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.cpqd.avm.sdk.v1.model.to.Collect;
import br.com.cpqd.avm.sdk.v1.model.to.ShortText;
import br.com.cpqd.avm.sdk.v1.model.to.Voice;

@Deprecated
public class BuilderDataModelCollect {

	private Collect collectTO = new Collect();

	private List<Voice> listVoiceTO = new ArrayList<Voice>();

	public BuilderDataModelCollect addImage(String imageUrl) {
		collectTO.setImageUrl(imageUrl);
		return this;
	}

	public BuilderDataModelCollect addText(String text) {
		collectTO.setImageUrl(text);
		return this;
	}

	public BuilderDataModelCollect addValue(String value) {
		collectTO.setValue(value);
		return this;
	}

	public BuilderDataModelCollect addMatch(String match) {
		collectTO.setMatch(match);
		return this;
	}

	public BuilderDataModelCollect addUrl(String url) {
		collectTO.setUrl(url);
		return this;
	}

	public BuilderDataModelCollect addQuickReply(boolean quick_reply) {
		collectTO.setQuick_reply(quick_reply);
		return this;
	}

	public BuilderDataModelCollect addShortText(ShortText shortText) {
		collectTO.setShort_text(shortText);
		return this;
	}

	public BuilderDataModelCollect addVoice(Voice voice) {
		this.listVoiceTO.add(voice);
		return this;
	}

	public Collect build() {
		collectTO.setVoice(listVoiceTO);
		return this.collectTO;
	}
}
