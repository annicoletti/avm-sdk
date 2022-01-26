package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

import java.util.ArrayList;
import java.util.List;

import br.com.cpqd.avm.sdk.v2.builder.api.AvmDataModel;
import br.com.cpqd.avm.sdk.v2.enums.AvmDataModelType;

public class AvmMenuTO implements AvmDataModel {

	private List<AvmItensMenuTO> menu;

	private AvmMenuTO(List<AvmItensMenuTO> menu) {
		this.menu = menu;
	}

	public List<AvmItensMenuTO> getMenu() {
		return menu;
	}

	public void addItensMenu(List<AvmItensMenuTO> itensMenu) {
		this.menu.addAll(itensMenu);
	}

	public void addItensMenu(AvmItensMenuTO itensMenu) {
		this.menu.add(itensMenu);
	}

	public static class Builder {

		private List<AvmItensMenuTO> menu = new ArrayList<>();

		public Builder addItensMenu(AvmItensMenuTO avmItensMenu) {
			this.menu.add(avmItensMenu);
			return this;
		}

		public AvmMenuTO build() {
			return new AvmMenuTO(menu);
		}

	}

	@Override
	public AvmDataModelType getType() {
		return AvmDataModelType.MENU;
	}

	@Override
	public Object getDataModel() {
		return menu;
	}

}
