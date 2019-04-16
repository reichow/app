package br.com.camila.app.message;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.camila.app.domain.TipoProposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@EqualsAndHashCode
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class AnalisarPrePropostaMessage implements Serializable {

    private static final long serialVersionUID = -5309835503044248174L;

    private String cpf;

    private Long numeroProposta;

    private TipoProposta proposta;
}
