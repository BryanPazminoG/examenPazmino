package ec.edu.espe.examen.Pazmino.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ec.edu.espe.examen.Pazmino.dao.EspecialidadRepository;
import ec.edu.espe.examen.Pazmino.domain.Especialidad;
import ec.edu.espe.examen.Pazmino.service.Exception.CreacionException;
import jakarta.transaction.Transactional;

@Service
public class EspecialidadService {

    private final EspecialidadRepository especialidadRepository;

    public EspecialidadService(EspecialidadRepository especialidadRepository){
        this.especialidadRepository = especialidadRepository;
    }

    @Transactional
    public Especialidad crearEspecialidad(Especialidad especialidad) {
        try {
            return this.especialidadRepository.save(especialidad);
        } catch (Exception e) {
            throw new CreacionException("Ocurrio un error al crear la especialidad: " + especialidad.toString(), e);
        }
    }

    public Especialidad buscarPorPatron(String patron) {
        try{
            return especialidadRepository.findByCodigo(patron);
        } catch (Exception e) {
            throw new RuntimeException("No se encontro ninguna especialidad con el patron: " + patron, e);
        }
        
    }

}
