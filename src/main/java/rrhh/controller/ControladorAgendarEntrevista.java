package rrhh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import rrhh.dao.BusquedaLaboralDAO;
import rrhh.dao.CandidatoDAO;
import rrhh.model.BusquedaLaboral;
import rrhh.model.Candidato;
import rrhh.model.Conocimiento;

import java.util.Collection;
import java.util.Date;

@Controller
public class ControladorAgendarEntrevista {
    @Autowired
    private BusquedaLaboralDAO busquedasDao;
    @Autowired
    private CandidatoDAO candidatoDao;

    private BusquedaLaboral busquedaLaboral;

    @RequestMapping("/entrevista/agendar")
    public String verBusquedasLaborales(Model model) {
        Collection<BusquedaLaboral> busquedas = busquedasDao.buscarBusquedasActivas();

        model.addAttribute("busquedas", busquedas);

        return "entrevista/busquedas";
    }

    @RequestMapping("/entrevista/candidatos")
    public String buscarCandidatos(@RequestParam(value = "idBusquedaLaboral", required = false, defaultValue = "") Long idBusquedaLaboral,
                                   Model model) {

        busquedaLaboral = busquedasDao.getOne(idBusquedaLaboral);

        Collection<Conocimiento> conocimientosBuscados = busquedaLaboral.getConocimientosBuscados();

        Collection<Candidato> candidatos = candidatoDao.buscarPorConocimientos(conocimientosBuscados);

        model.addAttribute("candidatos", candidatos);
        model.addAttribute("busquedaLaboral", busquedaLaboral);

        return "entrevista/candidatos";
    }

    @PostMapping("/entrevista/confirmacion")
    public String confirmarEntrevista(@RequestParam(value = "fecha", required = true) @DateTimeFormat(pattern = "dd-MM-yyyy") Date fecha,
                                      @RequestParam(value = "codCandidato", required = false, defaultValue = "") Long codCandidato,
                                      @RequestParam(value = "idBusquedaLaboral", required = true) Long idBusquedaLaboral,
                                      Model model) {
        Candidato candidato = candidatoDao.getOne(codCandidato);
        busquedaLaboral = busquedasDao.getOne(idBusquedaLaboral);

        busquedaLaboral.agregarEntrevista(candidato, fecha);

        busquedasDao.save(busquedaLaboral);

        model.addAttribute("candidato", candidato);
        model.addAttribute("busquedaLaboral", busquedaLaboral);
        model.addAttribute("fecha", fecha);

        return "/entrevista/confirmacion";
    }
}
