package br.com.camila.app.messaging;

/**
 * Interface para definição de nomes de exchanges, queues e routing keys.
 */
public interface Messaging {

    MessageOutbox CRIAR = new MessageOutbox("proposta.criar-proposta.message");
    MessageOutbox ANALISAR_PRE = new MessageOutbox("proposta.analisar-pre-proposta.message");
    MessageOutbox ATUALIZAR_INFOS_PESSOAIS = new MessageOutbox("proposta.atualizar-infos-pessoais.message");
    MessageOutbox ATUALIZAR_EMAIL_VALIDADO = new MessageOutbox("proposta.atualizar-email-validado.message");
    MessageOutbox ANALISAR_POS = new MessageOutbox("proposta.analisar-pos-proposta.message");

    String EXCHANGE_EVENTS = "app.events.exchange";
}
