package br.com.camila.app.repository;

import java.util.Optional;

import org.springframework.data.repository.Repository;

import br.com.camila.app.entity.Proposta;


public interface PropRepository extends Repository<Proposta, Long> {

    Optional<Proposta> findByNumero(Long numero);
}
