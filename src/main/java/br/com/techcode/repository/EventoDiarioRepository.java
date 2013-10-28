package br.com.techcode.repository;

import br.com.techcode.beans.EventoDiario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventoDiarioRepository extends JpaRepository<EventoDiario, Long> {
}
