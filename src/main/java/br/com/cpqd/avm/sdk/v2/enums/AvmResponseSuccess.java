package br.com.cpqd.avm.sdk.v2.enums;

public enum AvmResponseSuccess {

	STATUS("status"), TYPE("type"), DATA_MODEL("datamodel");

	private String valor;

	AvmResponseSuccess(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
