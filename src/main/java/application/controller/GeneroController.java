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
import application.repository.GeneroRepository;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepo;
    
    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());

        return "/generos/list";
    }
    @RequestMapping("/insert")
    public String insert(Model ui) {
        ui.addAttribute("generos", generoRepo.findAll());

        return "/generos/insert";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestParam("nome") String nome){
        Genero genero = new Genero();
        genero.setNome(nome);
        generoRepo.save(genero);

        return "redirect:/generos/list";
    }
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model ui) {
        Optional<Genero> resultado = generoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("generos", resultado.get());
            return "/generos/update";
        }
    return "redirect:/generos/list";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String update(@RequestParam("nome") String nome, @RequestParam("id") long id){
        Optional<Genero> resultado = generoRepo.findById(id);
        if(resultado.isPresent()){
            resultado.get().setNome(nome);
            generoRepo.save(resultado.get());
        }

        return "redirect:/generos/list";
    }
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model ui) {
        Optional<Genero> resultado = generoRepo.findById(id);
        if (resultado.isPresent()) {
            ui.addAttribute("generos", resultado.get());
            return "/generos/delete";
        }
    return "redirect:/generos/list";
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        generoRepo.deleteById(id);
        
        return "redirect:/generos/list";
    }
}
