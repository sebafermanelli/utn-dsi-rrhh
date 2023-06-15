package rrhh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rrhh.dao.EntrevistaDAO;
import rrhh.model.Entrevista;

import java.util.Collection;
import java.util.Date;

@Controller
public class ControladorConsultaEntrevistas {
    @Autowired
    private EntrevistaDAO entrevistaDao;

    @RequestMapping("/entrevista/buscar")
    public String agendarEntrevista(Model model) {
        return "entrevista/buscar";
    }

    @PostMapping("/entrevista/resultados")
    public String confirmarEntrevista(@RequestParam(value = "fecha") @DateTimeFormat(pattern = "dd-MM-yyyy") Date fechaDesde,
                                      Model model) {
        Collection<Entrevista> entrevistas = entrevistaDao.buscarEntrevistasPorFecha(fechaDesde);

        model.addAttribute("entrevistas", entrevistas);
        model.addAttribute("fechaDesde", fechaDesde);

        return "entrevista/resultados";
    }

}
