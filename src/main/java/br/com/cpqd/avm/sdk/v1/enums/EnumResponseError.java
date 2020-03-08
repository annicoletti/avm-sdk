package br.com.cpqd.avm.sdk.v1.enums;

public enum EnumResponseError {

	STATUS("status"), ERROR_MESSAGE("errorMessage"), ERROR_CODE("errorCode");

	private String valor;

	EnumResponseError(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
