package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.model.Jogo;
import application.model.Modo;
import application.model.Plataforma;
import application.repository.GeneroRepository;
import application.repository.JogoRepository;
import application.repository.ModoRepository;
import application.repository.PlataformaRepository;

@Controller
@RequestMapping("/jogos")
public class JogoController {
    
    @Autowired
    private JogoRepository jogoRepo;
    @Autowired
    private GeneroRepository generoRepo;
    @Autowired
    private PlataformaRepository plataformaRepo;
    @Autowired
    private ModoRepository modoRepo;

    @RequestMapping("/list")
    public String list(Model ui){
        ui.addAttribute("jogos", jogoRepo.findAll());
        return "/jogos/list";
    }
    @RequestMapping("/insert")
    public String insert(Model ui){
        ui.addAttribute("jogos", jogoRepo.findAll());
        ui.addAttribute("generos", generoRepo.findAll());
        ui.addAttribute("plataformas", plataformaRepo.findAll());
        ui.addAttribute("modos", modoRepo.findAll());
        return "/jogos/insert";
    }
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String insert(@RequestParam("titulo") String titulo,
    @RequestParam("generos") long[] generos,
    @RequestParam("plataformas") long[] plataformas,
    @RequestParam("id_modo") long modos)
    {
        Optional<Modo> modo = modoRepo.findById(modos);
        if(modo.isPresent()){
            Jogo jogo = new Jogo();
            jogo.setTitulo(titulo);
            jogo.setModo(modo.get());
            for(long p_id:plataformas){
                Optional<Plataforma> result_p = plataformaRepo.findById(p_id);
                if(result_p.isPresent()){
                    jogo.getPlataformas().add(result_p.get());
                }
            }
            for(long g_id:generos){
                Optional<Genero> result_g = generoRepo.findById(g_id);
                if(result_g.isPresent()){
                    jogo.getGeneros().add(result_g.get());
                }
            }
            jogoRepo.save(jogo);
        }


        return "redirect:/jogos/list";
    }
    
}
