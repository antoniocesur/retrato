package com.antonio.fp.retrato.controladores;

import com.antonio.fp.retrato.modelo.Retrato;
import com.antonio.fp.retrato.servicios.RetratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Principal {
    @Autowired
    RetratoService servicio;

    @GetMapping("/")
    public String principal(Model model, Authentication authentication){
        model.addAttribute("lista", servicio.findAll());
        model.addAttribute("authentication", authentication);
        return "index";
    }
}
