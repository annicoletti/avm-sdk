package br.com.cpqd.avm.sdk.v1.service.api;

import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelChoices;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelCollect;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelContent;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelMenu;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelShortText;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelVoice;

public interface BuilderService {

	public BuilderDataModelMenu MENU();

	public BuilderDataModelContent CONTENT();

	public BuilderDataModelCollect COLLECT();

	public BuilderDataModelVoice VOICE();

	public BuilderDataModelShortText SHORT_TEXT();

	public BuilderDataModelChoices CHOICES();

}
