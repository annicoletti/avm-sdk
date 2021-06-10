package br.com.cpqd.avm.sdk.v1.service.api;

import java.util.Map;

import br.com.cpqd.avm.sdk.v1.builder.impl.BuilderRequest;
import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v1.model.to.RequestAvmTO;
import br.com.cpqd.avm.sdk.v1.model.to.ResponseAvmTO;

/**
 * <h1>Interface responsável por executar o processamento do SDK AVM</h1>
 * <p>
 * Realiza a execução da interface {@link Integration}
 * <p>
 * Retornando os valores adequados para Integração correta com o AVM
 * 
 * {@link RequestAvmTO} {@link ResponseAvmTO}
 * 
 * @author Nicoletti
 *
 */
public interface ExecuteAvmFacade {

	/**
	 * <h1>Processamento do {@link RequestAvmTO} request</h1>
	 * 
	 * @param integration
	 * @param request
	 * @return {@link ResponseAvmTO}
	 */
	public default ResponseAvmTO process(Integration integration, Map<String, Object> request) {
		ResponseAvmTO avmResponse = new ResponseAvmTO();
		try {
			RequestAvmTO avmRequest;
			avmRequest = new BuilderRequest().parseFromMap(request).build();
			avmResponse = integration.execute(avmRequest);
		} catch (SdkExceptions e) {
			e.printStackTrace();
		}
		return avmResponse;
	}

}
