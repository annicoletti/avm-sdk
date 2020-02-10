package br.com.cpqd.avm.sdk.v1.service.impl;

import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelChoices;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelCollect;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelContent;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelMenu;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelShortText;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelVoice;
import br.com.cpqd.avm.sdk.v1.service.api.BuilderService;

public class BuilderServiceBean implements BuilderService {

	@Override
	public BuilderDataModelMenu MENU() {
		return new BuilderDataModelMenu();
	}

	@Override
	public BuilderDataModelContent CONTENT() {
		return new BuilderDataModelContent();
	}

	@Override
	public BuilderDataModelCollect COLLECT() {
		return new BuilderDataModelCollect();
	}

	@Override
	public BuilderDataModelVoice VOICE() {
		return new BuilderDataModelVoice();
	}

	@Override
	public BuilderDataModelShortText SHORT_TEXT() {
		return new BuilderDataModelShortText();
	}

	@Override
	public BuilderDataModelChoices CHOICES() {
		return new BuilderDataModelChoices();
	}

}
