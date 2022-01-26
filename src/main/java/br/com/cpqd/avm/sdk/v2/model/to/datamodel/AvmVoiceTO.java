package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

public class AvmVoiceTO {

	private String text;

	private String audio;

	private String ssml;

	private AvmVoiceTO(String text, String audio, String ssml) {
		this.text = text;
		this.audio = audio;
		this.ssml = ssml;
	}

	public String getText() {
		return text;
	}

	public String getAudio() {
		return audio;
	}

	public String getSsml() {
		return ssml;
	}

	public static class Builder {

		private String text;

		private String audio;

		private String ssml;

		public Builder addText(String text) {
			this.text = text;
			return this;
		}

		public Builder addAudio(String audio) {
			this.audio = audio;
			return this;
		}

		public Builder addSsml(String ssml) {
			this.ssml = ssml;
			return this;
		}

		public AvmVoiceTO build() {
			return new AvmVoiceTO(text, audio, ssml);
		}

	}

}
