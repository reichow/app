package br.com.camila.app.web;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.camila.app.annotation.EventTemplate;
import br.com.camila.app.entity.Proposta;
import br.com.camila.app.message.AnalisarPosPropostaMessage;
import br.com.camila.app.message.AnalisarPrePropostaMessage;
import br.com.camila.app.message.AtualizarEmailValidadoMessage;
import br.com.camila.app.message.AtualizarInfosPessoaisMessage;
import br.com.camila.app.message.CriarPropostaMessage;
import br.com.camila.app.messaging.Messaging;
import br.com.camila.app.repository.PropostaRepository;
import br.com.camila.app.request.AnalisarPosPropostaRequest;
import br.com.camila.app.request.AnalisarPrePropostaRequest;
import br.com.camila.app.request.AtualizarEmailValidadoRequest;
import br.com.camila.app.request.AtualizarInfosPessoaisRequest;
import br.com.camila.app.request.CriarPropostaRequest;

@RestController
@EnableRabbit
public class AppController {

    @Autowired
    @EventTemplate
    private RabbitTemplate eventTemplate;

    @Autowired
    private PropostaRepository repository;

    @PostMapping("/cria-proposta")
    public void criarProposta(@RequestBody CriarPropostaRequest request) {

        CriarPropostaMessage message = CriarPropostaMessage.builder()
            .cpf(request.getCpf())
            .proposta(request.getProposta()).build();

        eventTemplate.convertAndSend(
            Messaging.CRIAR_PROPOSTA.getExchange(),
            Messaging.CRIAR_PROPOSTA.getRoutingKey(),
            message);
    }

    @PostMapping("/analisa-pre-proposta")
    public void analisarPreProposta(@RequestBody AnalisarPrePropostaRequest request) {

        AnalisarPrePropostaMessage message = AnalisarPrePropostaMessage.builder()
            .cpf(request.getCpf())
            .numeroProposta(request.getNumeroProposta()).build();
//            .proposta(request.getProposta()).build();

        eventTemplate.convertAndSend(
            Messaging.ANALISAR_PRE_PROPOSTA.getExchange(),
            Messaging.ANALISAR_PRE_PROPOSTA.getRoutingKey(),
            message);
    }

    @PostMapping("/atualiza-infos-pessoais")
    public void atualizarInfosPessoais(@RequestBody AtualizarInfosPessoaisRequest request) {

        AtualizarInfosPessoaisMessage message= AtualizarInfosPessoaisMessage.builder()
            .numeroProposta(request.getNumeroProposta())
            .proposta(request.getProposta()).build();

        eventTemplate.convertAndSend(
            Messaging.ATUALIZAR_INFOS_PESSOAIS.getExchange(),
            Messaging.ATUALIZAR_INFOS_PESSOAIS.getRoutingKey(),
            message);
    }

    @PostMapping("/atualiza-email-validado")
    public void atualizarEmailValidado(@RequestBody AtualizarEmailValidadoRequest request) {

        AtualizarEmailValidadoMessage message = AtualizarEmailValidadoMessage.builder()
            .numeroProposta(request.getNumeroProposta())
            .proposta(request.getProposta()).build();

        eventTemplate.convertAndSend(
            Messaging.ATUALIZAR_EMAIL_VALIDADO.getExchange(),
            Messaging.ATUALIZAR_EMAIL_VALIDADO.getRoutingKey(),
            message);
    }

    @PostMapping("/analisa-pos-proposta")
    public void analisarPosProposta(@RequestBody AnalisarPosPropostaRequest request) {

        AnalisarPosPropostaMessage message = AnalisarPosPropostaMessage.builder()
            .cpf(request.getCpf())
            .numeroProposta(request.getNumeroProposta())
            .proposta(request.getProposta()).build();

        eventTemplate.convertAndSend(
            Messaging.ANALISAR_POS_PROPOSTA.getExchange(),
            Messaging.ANALISAR_POS_PROPOSTA.getRoutingKey(),
            message);
    }

    @GetMapping("/{numero}")
    public Proposta buscarProposta(@PathVariable Long numero) {
        return repository.findByNumero(numero).orElse(null);
    }
}
