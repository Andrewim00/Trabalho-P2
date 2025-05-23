package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Plataforma;
import application.repository.PlataformaRepository;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaRepository plataformaRepo;
    
    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("plataformas", plataformaRepo.findAll());

        return "/plataformas/list";
    }
    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("plataformas", plataformaRepo.findAll());

        return "/plataformas/insert";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestParam("descricao") String descricao){
        Plataforma plataforma = new Plataforma();
        plataforma.setDescricao(descricao);
        plataformaRepo.save(plataforma);

        return "redirect:/plataformas/list";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model ui) {
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("plataformas", resultado.get());
            return "/plataformas/update";
        }
    return "redirect:/plataformas/list";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("descricao") String descricao, @RequestParam("id") long id){
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if(resultado.isPresent()){
            resultado.get().setDescricao(descricao);
            plataformaRepo.save(resultado.get());
        }

        return "redirect:/plataformas/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model ui) {
        Optional<Plataforma> resultado = plataformaRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("plataformas", resultado.get());
            return "/plataformas/delete";
        }
    return "redirect:/plataformas/list";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        plataformaRepo.deleteById(id);
        
        return "redirect:/plataformas/list";
    }
}
