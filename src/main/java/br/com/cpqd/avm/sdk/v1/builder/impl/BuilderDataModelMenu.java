package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.Content;
import br.com.cpqd.avm.sdk.v1.model.to.Menu;
import br.com.cpqd.avm.sdk.v1.utils.SdkConstantsExceptions;

public class BuilderDataModelMenu {

	private Menu menu = new Menu();

	private List<Content> listContent;

	public BuilderDataModelMenu addTitle(String title) {
		menu.setTitle(title);
		return this;
	}

	public BuilderDataModelMenu addImage(String imageUrl) {
		menu.setImageUrl(imageUrl);
		return this;
	}

	public BuilderDataModelMenu addInfo(String info) {
		menu.setInfo(info);
		return this;
	}

	public BuilderDataModelMenu addContent(Content content) {
		if (this.listContent == null) {
			this.listContent = new ArrayList<Content>();
		}
		this.listContent.add(content);
		return this;
	}

	public BuilderDataModelMenu addContent(Set<Content> content) {
		if (this.listContent == null) {
			this.listContent = new ArrayList<Content>();
		}
		this.listContent.addAll(content);
		return this;
	}

	public Menu build() throws SdkExceptions {
		if (listContent == null || listContent.isEmpty()) {
			throw new SdkExceptions(SdkConstantsExceptions.EXCEPTION_DATA_MODEL_MENU_CONTENT);
		}
		menu.setContent(listContent);
		return this.menu;
	}

}
