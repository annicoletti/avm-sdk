package br.com.cpqd.avm.sdk.v2.enums;

public enum AvmResponseError {

	STATUS("status"), ERROR_MESSAGE("errorMessage"), ERROR_CODE("errorCode");

	private String valor;

	AvmResponseError(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
