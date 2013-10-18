/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.repository;

import br.com.techcode.beans.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Peixe
 */
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
