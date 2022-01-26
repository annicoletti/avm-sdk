package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

import java.util.ArrayList;
import java.util.List;

public class AvmItensMenuTO {

	private List<AvmContentTO> content;

	private String imageUrl;

	private String title;

	private String info;

	private AvmItensMenuTO(List<AvmContentTO> content, String imageUrl, String title, String info) {
		this.content = content;
		this.imageUrl = imageUrl;
		this.title = title;
		this.info = info;
	}

	public List<AvmContentTO> getContent() {
		return content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public String getInfo() {
		return info;
	}

	public static class Builder {

		private List<AvmContentTO> content = new ArrayList<>();

		private String imageUrl;

		private String title;

		private String info;

		public Builder addContent(List<AvmContentTO> content) {
			this.content.addAll(content);
			return this;
		}

		public Builder addContent(AvmContentTO content) {
			this.content.add(content);
			return this;
		}

		public Builder addImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
			return this;
		}

		public Builder addTitle(String title) {
			this.title = title;
			return this;
		}

		public Builder addInfo(String info) {
			this.info = info;
			return this;
		}

		public AvmItensMenuTO build() {
			return new AvmItensMenuTO(content, imageUrl, title, info);
		}

	}
}
