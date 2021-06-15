package br.com.cpqd.avm.sdk.v2.model.to.datamodel;

import java.util.ArrayList;
import java.util.List;

import br.com.cpqd.avm.sdk.v2.builder.api.AvmDataModel;
import br.com.cpqd.avm.sdk.v2.enums.AvmDataModelType;

public class AvmChoicesTO extends AvmDataModel {

	private List<AvmItensChoicesTO> choices;

	public AvmChoicesTO(List<AvmItensChoicesTO> choices) {
		this.choices = choices;
	}

	public List<AvmItensChoicesTO> getChoices() {
		return choices;
	}

	public static class Builder {

		private List<AvmItensChoicesTO> choices = new ArrayList<>();

		public Builder addChoices(List<AvmItensChoicesTO> choices) {
			this.choices.addAll(choices);
			return this;
		}

		public Builder addChoices(AvmItensChoicesTO choices) {
			this.choices.add(choices);
			return this;
		}

		public AvmChoicesTO build() {
			return new AvmChoicesTO(choices);
		}
	}

	@Override
	public AvmDataModelType getType() {
		return AvmDataModelType.CHOICES;
	}

}
