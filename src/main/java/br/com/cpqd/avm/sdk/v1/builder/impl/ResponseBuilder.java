package br.com.cpqd.avm.sdk.v1.builder.impl;

import java.lang.module.ModuleDescriptor.Requires;

public final class ResponseBuilder {

	public static final BuilderRequest REQUEST = new BuilderRequest();

	public static final BuilderResponseError RESPONSE_ERROR = new BuilderResponseError();

	/**
	 * {@link Requires}
	 * 
	 * 
	 */
	public static final BuilderResponseSuccess RESPONSE_SUCCESS = new BuilderResponseSuccess();

}
