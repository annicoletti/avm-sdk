package br.com.cpqd.avm.sdk.v1.model.to;

import java.util.List;

import br.com.cpqd.avm.sdk.v1.builder.api.DataModel;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstants;

public class Menu implements DataModel {

	private List<Content> content;

	private String imageUrl;

	private String title;

	private String info;
	
	@Override
	public String getDataModelValue() {
		return SdkConstants.DataModel.MENU;
	}

	public List<Content> getContent() {
		return content;
	}

	public void setContent(List<Content> content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "MenuTO [content=" + content + ", imageUrl=" + imageUrl + ", title=" + title + ", info=" + info + "]";
	}
	

}
