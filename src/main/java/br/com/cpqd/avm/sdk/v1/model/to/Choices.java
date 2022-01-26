package br.com.cpqd.avm.sdk.v1.model.to;

import java.util.List;

import br.com.cpqd.avm.sdk.v1.builder.api.DataModel;

@Deprecated
public class Choices implements DataModel {

	private List<Voice> voice;

	private ShortText short_text;

	private String imageUrl;

	private String text;

	private String value;

	private String match;

	private String url;

	private Boolean quick_reply;

	public List<Voice> getVoice() {
		return voice;
	}

	public void setVoice(List<Voice> voice) {
		this.voice = voice;
	}

	public ShortText getShort_text() {
		return short_text;
	}

	public void setShort_text(ShortText short_text) {
		this.short_text = short_text;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getMatch() {
		return match;
	}

	public void setMatch(String match) {
		this.match = match;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getQuick_reply() {
		return quick_reply;
	}

	public void setQuick_reply(Boolean quick_reply) {
		this.quick_reply = quick_reply;
	}

}
