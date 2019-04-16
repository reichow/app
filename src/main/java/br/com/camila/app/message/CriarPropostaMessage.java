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
public class CriarPropostaMessage implements Serializable {

    private static final long serialVersionUID = 562537463428642447L;

    private String cpf;

    private TipoProposta proposta;
}
