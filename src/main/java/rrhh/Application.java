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
        Conocimiento italiano = new Conocimiento("Italiano");
        Conocimiento java = new Conocimiento("Java");
        Conocimiento spring = new Conocimiento("Spring");
        Conocimiento jpa = new Conocimiento("JPA");
        Conocimiento javascript = new Conocimiento("Javascript");
        Conocimiento net = new Conocimiento(".Net");
        Conocimiento csharp = new Conocimiento("C#");
        Conocimiento angularJs = new Conocimiento("AngularJs");
        Conocimiento css = new Conocimiento("CSS");
        Conocimiento html = new Conocimiento("HTML");

        conocimientoDao.save(ingles);
        conocimientoDao.save(italiano);
        conocimientoDao.save(java);
        conocimientoDao.save(spring);
        conocimientoDao.save(javascript);
        conocimientoDao.save(net);
        conocimientoDao.save(angularJs);
        conocimientoDao.save(css);
        conocimientoDao.save(html);
        conocimientoDao.save(jpa);
        conocimientoDao.save(csharp);

        BusquedaLaboral traductor = new BusquedaLaboral("Traductor Inglés");
        traductor.agregarConocimiento(ingles);
        traductor.desactivar();
        busquedaLaboralDao.save(traductor);

        BusquedaLaboral traductorItaliano = new BusquedaLaboral("Traductor de Italiano");
        traductorItaliano.agregarConocimiento(italiano);
        busquedaLaboralDao.save(traductorItaliano);

        BusquedaLaboral javaDev = new BusquedaLaboral("Desarrollador Java");
        javaDev.agregarConocimiento(java);
        javaDev.agregarConocimiento(spring);
        javaDev.agregarConocimiento(jpa);

        busquedaLaboralDao.save(javaDev);

        BusquedaLaboral frontend = new BusquedaLaboral("Desarrollador Front End");
        frontend.agregarConocimiento(css);
        frontend.agregarConocimiento(angularJs);
        frontend.agregarConocimiento(html);

        busquedaLaboralDao.save(frontend);

        BusquedaLaboral netDev = new BusquedaLaboral("Desarrollador .Net");
        netDev.agregarConocimiento(csharp);
        netDev.agregarConocimiento(net);
        busquedaLaboralDao.save(netDev);

        BusquedaLaboral netFullStack = new BusquedaLaboral("Desarrollador .Net Full Stack");
        netFullStack.agregarConocimiento(css);
        netFullStack.agregarConocimiento(net);
        netFullStack.agregarConocimiento(html);

        busquedaLaboralDao.save(netFullStack);

        Candidato candidatoJava = new Candidato("Jose", "Java");
        candidatoJava.agregarConocimiento(java);
        candidatoJava.agregarConocimiento(spring);
        candidatoJava.agregarConocimiento(jpa);
        candidatoJava.agregarConocimiento(html);
        candidatoJava.agregarConocimiento(css);

        candidatoDao.save(candidatoJava);

        Candidato sabeTodo = new Candidato("Juan", "Sabetodo");
        Collection<Conocimiento> casiTodo = conocimientoDao.findAll();
        casiTodo.remove(italiano);
        sabeTodo.agregarConocimientos(casiTodo);

        candidatoDao.save(sabeTodo);

        Candidato candidatoJavaIngles = new Candidato("John", "Java");
        candidatoJavaIngles.agregarConocimiento(java);
        candidatoJavaIngles.agregarConocimiento(spring);
        candidatoJavaIngles.agregarConocimiento(jpa);
        candidatoJavaIngles.agregarConocimiento(html);
        candidatoJavaIngles.agregarConocimiento(css);

        candidatoDao.save(candidatoJavaIngles);

        Candidato candidatoNet = new Candidato("Peter", "PuntoNet");
        candidatoNet.agregarConocimiento(net);
        candidatoNet.agregarConocimiento(csharp);
        candidatoDao.save(candidatoNet);

        Candidato candidatoNetFS = new Candidato("Peter", "FullNet");
        candidatoNetFS.agregarConocimiento(net);
        candidatoNetFS.agregarConocimiento(csharp);
        candidatoNetFS.agregarConocimiento(css);
        candidatoNetFS.agregarConocimiento(html);
        candidatoNetFS.agregarConocimiento(angularJs);

        candidatoDao.save(candidatoNetFS);
    }
}
