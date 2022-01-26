package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

import java.util.ArrayList;
import java.util.List;

public class AvmItensChoicesTO {

	private List<AvmVoiceTO> voice;

	private AvmShortTextTO short_text;

	private String imageUrl;

	private String text;

	private String value;

	private String match;

	private String url;

	private Boolean quick_reply;

	private AvmItensChoicesTO(List<AvmVoiceTO> voice, AvmShortTextTO short_text, String imageUrl, String text,
			String value, String match, String url, Boolean quick_reply) {
		this.voice = voice;
		this.short_text = short_text;
		this.imageUrl = imageUrl;
		this.text = text;
		this.value = value;
		this.match = match;
		this.url = url;
		this.quick_reply = quick_reply;
	}

	public List<AvmVoiceTO> getVoice() {
		return voice;
	}

	public AvmShortTextTO getShort_text() {
		return short_text;
	}

	public String getImageUrl() {
		return imageUrl;
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

	public String getUrl() {
		return url;
	}

	public Boolean getQuick_reply() {
		return quick_reply;
	}

	public static class Builder {

		private List<AvmVoiceTO> voice = new ArrayList<>();

		private AvmShortTextTO short_text;

		private String imageUrl;

		private String text;

		private String value;

		private String match;

		private String url;

		private Boolean quick_reply;

		public Builder addVoice(List<AvmVoiceTO> voice) {
			this.voice.addAll(voice);
			return this;
		}

		public Builder addVoice(AvmVoiceTO voice) {
			this.voice.add(voice);
			return this;
		}

		public Builder addShort_text(AvmShortTextTO short_text) {
			this.short_text = short_text;
			return this;
		}

		public Builder addImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}

		public Builder addText(String text) {
			this.text = text;
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

		public Builder addUrl(String url) {
			this.url = url;
			return this;
		}

		public Builder addQuick_reply(Boolean quick_reply) {
			this.quick_reply = quick_reply;
			return this;
		}

		public AvmItensChoicesTO build() {
			return new AvmItensChoicesTO(voice, short_text, imageUrl, text, value, match, url, quick_reply);
		}

	}

}
