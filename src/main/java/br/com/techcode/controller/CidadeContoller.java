/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.controller;

import br.com.techcode.beans.Cidade;
import br.com.techcode.repository.CidadeRepository;
import br.com.techcode.service.CidadeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Peixe
 */
@Controller
@RequestMapping("/cidades")
public class CidadeContoller {

    @Autowired
    private CidadeService cidadeService;
    @Autowired
    private CidadeRepository cidadeRepository;

    @RequestMapping("cidadeslist.json")
    @ResponseBody
    public List<Cidade> getCidadesList() {
//        return cidadeService.getAllCidades();
        return cidadeRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void addCidade(@RequestBody Cidade cidade) {
//        cidadeService.addCidade(cidade);
        cidadeRepository.save(cidade);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCidade(@RequestBody Cidade cidade) {
//        cidadeService.updateCidade(cidade);
        cidadeRepository.save(cidade);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCidade(@PathVariable("id") Long id) {
//        cidadeService.deleteCidadeById(id);
        cidadeRepository.delete(id);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeAllCidades() {
        cidadeRepository.deleteAll();
    }

    @RequestMapping("/layout")
    public String getCidadesPartialPage(ModelMap modelMap) {
        return "cidades/layout";
    }
}
