package rrhh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rrhh.dao.BusquedaLaboralDAO;
import rrhh.dao.CandidatoDAO;
import rrhh.dao.ConocimientoDAO;
import rrhh.model.BusquedaLaboral;
import rrhh.model.Candidato;
import rrhh.model.Conocimiento;

import java.util.Collection;

@SpringBootApplication
public class Application implements CommandLineRunner {
    @Autowired
    private BusquedaLaboralDAO busquedaLaboralDao;
    @Autowired
    private CandidatoDAO candidatoDao;
    @Autowired
    private ConocimientoDAO conocimientoDao;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Conocimiento ingles = new Conocimiento("Inglés");
        conocimientoDao.save(ingles);
        Conocimiento italiano = new Conocimiento("Italiano");
        conocimientoDao.save(italiano);
        Conocimiento frances = new Conocimiento("Frances");
        conocimientoDao.save(frances);
        Conocimiento aleman = new Conocimiento("Aleman");
        conocimientoDao.save(aleman);
        Conocimiento java = new Conocimiento("Java");
        conocimientoDao.save(java);
        Conocimiento spring = new Conocimiento("Spring");
        conocimientoDao.save(spring);
        Conocimiento jpa = new Conocimiento("JPA");
        conocimientoDao.save(jpa);
        Conocimiento javascript = new Conocimiento("JavaScript");
        conocimientoDao.save(javascript);
        Conocimiento net = new Conocimiento(".NET");
        conocimientoDao.save(net);
        Conocimiento csharp = new Conocimiento("C#");
        conocimientoDao.save(csharp);
        Conocimiento html = new Conocimiento("HTML");
        conocimientoDao.save(html);
        Conocimiento css = new Conocimiento("CSS");
        conocimientoDao.save(css);
        Conocimiento angular = new Conocimiento("Angular");
        conocimientoDao.save(angular);
        Conocimiento nodejs = new Conocimiento("Nodejs");
        conocimientoDao.save(nodejs);

        BusquedaLaboral traductorIngles = new BusquedaLaboral("Traductor de Inglés");
        traductorIngles.agregarConocimiento(ingles);
        traductorIngles.desactivar();
        busquedaLaboralDao.save(traductorIngles);

        BusquedaLaboral traductorItaliano = new BusquedaLaboral("Traductor de Italiano");
        traductorItaliano.agregarConocimiento(italiano);
        busquedaLaboralDao.save(traductorItaliano);

        BusquedaLaboral traductorFrances = new BusquedaLaboral("Traductor de Frances");
        traductorFrances.agregarConocimiento(frances);
        traductorFrances.desactivar();
        busquedaLaboralDao.save(traductorFrances);

        BusquedaLaboral traductorAleman = new BusquedaLaboral("Traductor de Aleman");
        traductorAleman.agregarConocimiento(aleman);
        busquedaLaboralDao.save(traductorAleman);

        BusquedaLaboral javaDev = new BusquedaLaboral("Desarrollador Java");
        javaDev.agregarConocimiento(java);
        javaDev.agregarConocimiento(spring);
        javaDev.agregarConocimiento(jpa);
        busquedaLaboralDao.save(javaDev);

        BusquedaLaboral frontend = new BusquedaLaboral("Desarrollador Front End");
        frontend.agregarConocimiento(html);
        frontend.agregarConocimiento(css);
        frontend.agregarConocimiento(angular);
        busquedaLaboralDao.save(frontend);

        BusquedaLaboral backend = new BusquedaLaboral("Desarrollador Back End");
        backend.agregarConocimiento(nodejs);
        busquedaLaboralDao.save(backend);

        BusquedaLaboral netDev = new BusquedaLaboral("Desarrollador .NET");
        netDev.agregarConocimiento(csharp);
        netDev.agregarConocimiento(net);
        busquedaLaboralDao.save(netDev);

        BusquedaLaboral netFullStack = new BusquedaLaboral("Desarrollador .NET Full Stack");
        netFullStack.agregarConocimiento(css);
        netFullStack.agregarConocimiento(net);
        netFullStack.agregarConocimiento(html);
        busquedaLaboralDao.save(netFullStack);

        Candidato candidatoJava = new Candidato("Jose", "Fernández");
        candidatoJava.agregarConocimiento(java);
        candidatoJava.agregarConocimiento(spring);
        candidatoJava.agregarConocimiento(jpa);
        candidatoDao.save(candidatoJava);

        Candidato sabeTodo = new Candidato("Juan", "López");
        Collection<Conocimiento> casiTodo = conocimientoDao.findAll();
        casiTodo.remove(italiano);
        sabeTodo.agregarConocimientos(casiTodo);
        candidatoDao.save(sabeTodo);

        Candidato candidatoJavaIngles = new Candidato("Martín", "García");
        candidatoJavaIngles.agregarConocimiento(java);
        candidatoJavaIngles.agregarConocimiento(spring);
        candidatoJavaIngles.agregarConocimiento(jpa);
        candidatoJavaIngles.agregarConocimiento(html);
        candidatoJavaIngles.agregarConocimiento(css);
        candidatoJavaIngles.agregarConocimiento(ingles);
        candidatoDao.save(candidatoJavaIngles);

        Candidato candidatoNet = new Candidato("Pedro", "Martínez");
        candidatoNet.agregarConocimiento(net);
        candidatoNet.agregarConocimiento(csharp);
        candidatoNet.agregarConocimiento(aleman);
        candidatoDao.save(candidatoNet);

        Candidato candidatoNetFS = new Candidato("Santiago", "Torres");
        candidatoNetFS.agregarConocimiento(net);
        candidatoNetFS.agregarConocimiento(csharp);
        candidatoNetFS.agregarConocimiento(css);
        candidatoNetFS.agregarConocimiento(html);
        candidatoNetFS.agregarConocimiento(angular);
        candidatoDao.save(candidatoNetFS);
    }
}
