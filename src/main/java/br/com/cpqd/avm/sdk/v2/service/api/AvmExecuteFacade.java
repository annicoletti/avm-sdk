package br.com.cpqd.avm.sdk.v2.service.api;

import java.util.Map;

import br.com.cpqd.avm.sdk.v1.exception.SdkExceptions;
import br.com.cpqd.avm.sdk.v2.model.to.AvmRequestTO;
import br.com.cpqd.avm.sdk.v2.model.to.AvmResponseTO;

/**
 * <h1>Interface responsável por executar o processamento do SDK AVM</h1>
 * <p>
 * Realiza a execução da interface {@link AvmIntegration}
 * <p>
 * Retornando os valores adequados para Integração correta com o AVM
 * 
 * {@link AvmRequestTO} {@link AvmResponseTO}
 * 
 * @author Nicoletti
 *
 */
public interface AvmExecuteFacade {

	/**
	 * <h1>Processamento do {@link AvmRequestTO} request</h1>
	 * 
	 * @param integration
	 * @param request
	 * @return {@link AvmResponseTO}
	 * @throws SdkExceptions
	 */
	public default AvmResponseTO process(AvmIntegration integration, Map<String, Object> request) {
		AvmResponseTO avmResponse = null;
		try {
			AvmRequestTO avmRequest = new AvmRequestTO.Builder().parseFromMap(request).build();
			avmResponse = integration.execute(avmRequest);
		} catch (SdkExceptions e) {
			System.err.printf("[%s] = %s\n", e.getCode(), e.getMessage());
		}
		return avmResponse;
	}

}
