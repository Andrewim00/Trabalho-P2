package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Modo;
import application.repository.GeneroRepository;
import application.repository.ModoRepository;

@Controller
@RequestMapping("/plataformas")
public class PlataformaController {

    @Autowired
    private ModoRepository modoRepo;
    
    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("modos", modoRepo.findAll());

        return "/modos/list";
    }
    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("modos", modoRepo.findAll());

        return "/modos/insert";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestParam("descricao") String descricao){
        Modo modo = new Modo();
        modo.setDescricao(descricao);
        modoRepo.save(modo);

        return "redirect:/modos/list";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model ui) {
        Optional<Modo> resultado = modoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("modos", resultado.get());
            return "/modos/update";
        }
    return "redirect:/modos/list";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("descricao") String descricao, @RequestParam("id") long id){
        Optional<Modo> resultado = modoRepo.findById(id);
        if(resultado.isPresent()){
            resultado.get().setDescricao(descricao);
            modoRepo.save(resultado.get());
        }

        return "redirect:/modos/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model ui) {
        Optional<Modo> resultado = modoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("modos", resultado.get());
            return "/modos/delete";
        }
    return "redirect:/modos/list";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        modoRepo.deleteById(id);
        
        return "redirect:/modos/list";
    }
}
