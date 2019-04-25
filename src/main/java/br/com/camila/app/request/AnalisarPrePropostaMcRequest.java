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
public class AnalisarPrePropostaMcRequest implements Serializable {

    private static final long serialVersionUID = -4693824107761654994L;

    private String cpf;

    private Long numeroProposta;

    private Tipo proposta;
}
