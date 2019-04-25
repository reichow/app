package br.com.camila.app.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.camila.app.domain.Tipo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class AtualizarInfosPessoaisRequest implements Serializable {

    private static final long serialVersionUID = 23900199367484230L;

    private Long numeroProposta;

    private Tipo proposta;
}
