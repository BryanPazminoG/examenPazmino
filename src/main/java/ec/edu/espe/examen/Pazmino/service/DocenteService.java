package ec.edu.espe.examen.Pazmino.service;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Pazmino.dao.DocenteRepository;
import ec.edu.espe.examen.Pazmino.dao.EspecialidadRepository;
import ec.edu.espe.examen.Pazmino.domain.Docente;
import ec.edu.espe.examen.Pazmino.domain.Especialidad;
import ec.edu.espe.examen.Pazmino.service.Exception.CreacionException;
import jakarta.transaction.Transactional;



@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;
    private final EspecialidadRepository especialidadRepository;

    public DocenteService(DocenteRepository docenteRepository, EspecialidadRepository especialidadRepository) {
        this.docenteRepository = docenteRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Docente crearDocente(Docente docente) {
        Especialidad especialidad = especialidadRepository.findByCodigo(docente.getCodigoEspecialidad());
        if (especialidad == null) {
            throw new RuntimeException("La especialidad con código " + docente.getCodigoEspecialidad() + " no existe.");
        }

        Date fechaActual = new Date(System.currentTimeMillis());
        Date fechaIngresoDocente = docente.getFechaCreacion(); 

        if (fechaIngresoDocente.before(fechaActual)) {
            throw new RuntimeException("La fecha de ingreso debe ser mayor a la fecha actual.");
        }

        try {
            return this.docenteRepository.save(docente); 
        } catch (Exception e) {
            throw new CreacionException("Ocurrió un error al crear el docente: " + docente.toString(), e);
        }
    }

}
