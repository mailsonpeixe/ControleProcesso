/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.service;

import br.com.techcode.beans.Cidade;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Peixe
 */
@Service("cidadeService")
public class CidadeServiceImpl implements CidadeService {

    List<Cidade> cidades = new ArrayList<Cidade>();
    private static Long id = 0L;

    public List<Cidade> getAllCidades() {
        return cidades;
    }

    public void addCidade(Cidade cidade) {
        cidade.setId(++id);
        cidades.add(cidade);
    }

    public void deleteCidade(Cidade cidade) {
        cidades.remove(cidade);
    }

    public void deleteAll() {
        cidades.clear();
        id = 0L;
    }

    public Cidade getCidadeById(Long id) {
        return findCidadeById(id);
    }

    private Cidade findCidadeById(Long id) {
        for (Cidade cid : cidades) {
            if (cid.getId() == id) {
                return cid;
            }
        }
        return null;
    }

    public void deleteCidadeById(Long id) {
        Cidade found = findCidadeById(id);
        if (found != null) {
            cidades.remove(found);
            id--;
        }
    }

    public void updateCidade(Cidade cidade) {
        Cidade found = findCidadeById(cidade.getId());
        if (found != null) {
            cidades.remove(found);
            cidades.add(cidade);
        }
    }
}
