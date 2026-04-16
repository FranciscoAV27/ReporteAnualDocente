package mx.edu.unpa.reporteanualdocente.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import mx.edu.unpa.reporteanualdocente.DTOs.profesor.request.ProfesorRequest;
import mx.edu.unpa.reporteanualdocente.DTOs.profesor.response.ProfesorResponse;
import mx.edu.unpa.reporteanualdocente.services.ProfesorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reporteAnual/profesores")
@RequiredArgsConstructor
public class ProfesorController {

    private final ProfesorService profesorService;

    @PostMapping
    public ResponseEntity<ProfesorResponse> create(@Valid @RequestBody ProfesorRequest request) {
        return new ResponseEntity<>(profesorService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfesorResponse> update(@PathVariable Long id, @Valid @RequestBody ProfesorRequest request) {
        return ResponseEntity.ok(profesorService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        profesorService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfesorResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(profesorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ProfesorResponse>> findAll() {
        return ResponseEntity.ok(profesorService.findAll());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ProfesorResponse> findByEmail(@PathVariable String email) {
        return ResponseEntity.ok(profesorService.findByEmail(email));
    }
}