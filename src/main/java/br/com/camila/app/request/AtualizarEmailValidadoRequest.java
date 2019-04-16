package br.com.camila.app.request;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.camila.app.domain.TipoProposta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class AtualizarEmailValidadoRequest implements Serializable {

    private static final long serialVersionUID = 2454303659149839270L;

    private Long numeroProposta;

    private TipoProposta proposta;
}
