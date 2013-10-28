package br.com.techcode.controller;

import br.com.techcode.beans.Cidade;
import br.com.techcode.beans.EventoDiario;
import br.com.techcode.repository.CidadeRepository;
import br.com.techcode.repository.EventoDiarioRepository;
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

@Controller
@RequestMapping("/eventodiario")
public class EventoDiarioContoller {

   
    @Autowired
    private EventoDiarioRepository eventoDiarioRepository;

    @RequestMapping("eventoslist.json")
    @ResponseBody
    public List<EventoDiario> getEventosList() {
        return eventoDiarioRepository.findAll();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public void saveEventoDiario(@RequestBody EventoDiario evento) {
        eventoDiarioRepository.save(evento);
    }
    
      @RequestMapping(value = "/edit/{id}")
    public @ResponseBody
    EventoDiario editEvento(@PathVariable("id") Long id) {
        return eventoDiarioRepository.findOne(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public void updateCidade(@RequestBody EventoDiario evento) {
        eventoDiarioRepository.save(evento);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeCidade(@PathVariable("id") Long id) {
        eventoDiarioRepository.delete(id);
    }

    @RequestMapping(value = "/removeAll", method = RequestMethod.DELETE)
    @ResponseBody
    public void removeAllCidades() {
        eventoDiarioRepository.deleteAll();
    }

    @RequestMapping("/list")
    public String getPartialPageList() {
        return "eventodiario/list";
    }

    @RequestMapping("/edit")
    public String getPartialPageEdit() {
        return "eventodiario/edit";
    }

    @RequestMapping("/new")
    public String getPartialPageNew() {
        return "eventodiario/edit";
    }
}
