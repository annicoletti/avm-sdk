package br.com.cpqd.avm.sdk.v1.builder.impl;

import br.com.cpqd.avm.sdk.v1.model.to.Voice;

@Deprecated
public class BuilderDataModelVoice {

	private Voice voiceTO = new Voice();

	public BuilderDataModelVoice addAudio(String audio) {
		voiceTO.setAudio(audio);
		return this;
	}

	public BuilderDataModelVoice addSsml(String ssml) {
		voiceTO.setSsml(ssml);
		return this;
	}

	public BuilderDataModelVoice addText(String text) {
		voiceTO.setText(text);
		return this;
	}

	public Voice build() {
		return voiceTO;
	}

}
