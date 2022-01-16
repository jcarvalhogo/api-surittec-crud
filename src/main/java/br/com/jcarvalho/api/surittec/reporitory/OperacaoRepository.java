package br.com.jcarvalho.api.surittec.reporitory;

import br.com.jcarvalho.api.surittec.entity.Operacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
}
