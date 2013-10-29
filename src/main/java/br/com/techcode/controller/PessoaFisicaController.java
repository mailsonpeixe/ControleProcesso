/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.techcode.controller;

import br.com.techcode.beans.PessoaFisica;
import br.com.techcode.repository.PessoaFisicaRepository;
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
@RequestMapping("/pessoafisica")
public class PessoaFisicaController {

    @Autowired
    private PessoaFisicaRepository pessoaFisicaRepository;

    @RequestMapping("/pessoafisicalist.json")
    @ResponseBody
    public List<PessoaFisica> getPessoaList() {
//        return cidadeService.getAllPessoa();
        return pessoaFisicaRepository.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public void addPessoaFisica(@RequestBody PessoaFisica pessoaFisica) {
//        cidadeService.addPessoaFisica(cidade);
        pessoaFisicaRepository.save(pessoaFisica);
    }

    @RequestMapping(value = "/editPessoaFisica/{p}")
    public @ResponseBody
    PessoaFisica editPessoaFisica(@PathVariable("p") PessoaFisica p) {
        return p;
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public void updatePessoaFisica(@RequestBody PessoaFisica cidade) {
//        cidadeService.updatePessoaFisica(cidade);
        pessoaFisicaRepository.save(cidade);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removePessoaFisica(@PathVariable("id") Long id) {
//        cidadeService.deletePessoaFisicaById(id);
        pessoaFisicaRepository.delete(id);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeAllPessoas() {
        pessoaFisicaRepository.deleteAll();
    }

//    @RequestMapping("/layout")
//    public String getPessoaPartialPage(ModelMap modelMap) {
//        return "pessoas/layout";
//    }
    @RequestMapping("/list")
    public String getPessoaFisicaPartialPageList() {
        return "pessoafisica/list";
    }

    @RequestMapping("/new")
    public String getPessoaFisicaPartialPageEdit() {
        return "pessoafisica/edit";
    }

    @RequestMapping("/edit")
    public String getPessoaFisicaPartialPageNew() {
        return "pessoafisica/edit";
    }
}
