/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.service;

import br.com.techcode.beans.Cidade;
import java.util.List;

/**
 *
 * @author Peixe
 */
public interface CidadeService {

 public List<Cidade> getAllCidades();

    public Cidade getCidadeById(Long id);

    public void addCidade(Cidade cidade);

    public void deleteCidadeById(Long id);

    public void deleteAll();

    public void updateCidade(Cidade cidade);
}
