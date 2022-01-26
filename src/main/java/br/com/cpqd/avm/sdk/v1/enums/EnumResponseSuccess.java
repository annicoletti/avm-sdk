package br.com.cpqd.avm.sdk.v1.enums;

@Deprecated
public enum EnumResponseSuccess {

	STATUS("status"), TYPE("type"), DATA_MODEL("datamodel");

	private String valor;

	EnumResponseSuccess(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return this.valor;
	}

}
