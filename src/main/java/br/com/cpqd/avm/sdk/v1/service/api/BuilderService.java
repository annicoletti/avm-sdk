package br.com.cpqd.avm.sdk.v1.service.api;

import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelChoices;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelCollect;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelContent;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelMenu;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelShortText;
import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderDataModelVoice;
import br.com.cpqd.avm.sdk.v1.model.to.Menu;

public interface BuilderService {

	/**
	 * Método construtor do DataModel {@link Menu}
	 * 
	 * {@code BuilderService}
	 * 
	 * @return {@link Menu}
	 */
	public BuilderDataModelMenu MENU();

	public BuilderDataModelContent CONTENT();

	public BuilderDataModelCollect COLLECT();

	public BuilderDataModelVoice VOICE();

	public BuilderDataModelShortText SHORT_TEXT();

	public BuilderDataModelChoices CHOICES();

}
