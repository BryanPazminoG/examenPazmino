package ec.edu.espe.examen.Pazmino.dao;


import org.springframework.data.repository.CrudRepository;

import ec.edu.espe.examen.Pazmino.domain.Especialidad;

public interface EspecialidadRepository extends CrudRepository<Especialidad, Integer>{

    public Especialidad findByCodigo(String codigoEspecialidad);

}
