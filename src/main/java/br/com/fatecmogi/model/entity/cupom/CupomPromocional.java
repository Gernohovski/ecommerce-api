package br.com.fatecmogi.model.entity.cupom;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@RegisterForReflection
public class CupomPromocional extends Cupom {

}
