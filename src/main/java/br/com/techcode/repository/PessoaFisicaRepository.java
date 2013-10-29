/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.repository;

import br.com.techcode.beans.PessoaFisica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Peixe
 */
public interface PessoaFisicaRepository extends JpaRepository<PessoaFisica, Long> {
}
