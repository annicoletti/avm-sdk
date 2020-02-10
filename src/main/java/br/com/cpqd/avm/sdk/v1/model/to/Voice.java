package br.com.cpqd.avm.sdk.v1.model.to;

public class Voice {

	private String text;

	private String audio;

	private String ssml;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public String getSsml() {
		return ssml;
	}

	public void setSsml(String ssml) {
		this.ssml = ssml;
	}

	@Override
	public String toString() {
		return "VoiceTO [text=" + text + ", audio=" + audio + ", ssml=" + ssml + "]";
	}

}
