package mx.edu.unpa.reporteanualdocente.repositories;

import mx.edu.unpa.reporteanualdocente.domains.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
    Optional<Profesor> findByEmail(String email);
    Optional<Profesor> findByNumeroTrabajo(String numeroTrabajo);
}