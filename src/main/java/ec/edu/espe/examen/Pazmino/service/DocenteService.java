package ec.edu.espe.examen.Pazmino.service;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Pazmino.dao.DocenteRepository;
import ec.edu.espe.examen.Pazmino.domain.Docente;
import ec.edu.espe.examen.Pazmino.service.Exception.CreacionException;
import jakarta.transaction.Transactional;



@Service
public class DocenteService {

    private final DocenteRepository docenteRepository;

    public DocenteService(DocenteRepository docenteRepository) {
        this.docenteRepository = docenteRepository;
    }

    @Transactional
    public Docente crearDocente(Docente docente) {
        try {
            return this.docenteRepository.save(docente);
        } catch (Exception e) {
            throw new CreacionException("Ocurrio un error al crear el docente: " + docente.toString(), e);
        }
    }

}
