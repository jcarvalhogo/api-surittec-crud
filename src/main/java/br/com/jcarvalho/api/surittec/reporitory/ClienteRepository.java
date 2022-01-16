package br.com.jcarvalho.api.surittec.reporitory;

import br.com.jcarvalho.api.surittec.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
