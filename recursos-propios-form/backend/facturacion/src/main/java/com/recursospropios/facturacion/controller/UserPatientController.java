package com.recursospropios.facturacion.controller;

import com.recursospropios.facturacion.entity.UserPatient;
import com.recursospropios.facturacion.exceptions.MyException;
import com.recursospropios.facturacion.service.UserPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserPatientController {
    @Autowired
    private UserPatientService service;

    @GetMapping("")
    public ResponseEntity<List<UserPatient>> searchAllAccountants() {
        return ResponseEntity.ok(service.searchAllUserPatient());
    }

    @GetMapping("/{dni}")
    public ResponseEntity<UserPatient> searchUserPatientByDni(@PathVariable Long dni) {
        return new ResponseEntity<>(service.searchUserPatientByDni(dni), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserPatient> createUserPacient(@RequestBody UserPatient userPatient) throws MyException {
        UserPatient createdUserPatient = service.createUserPatient(userPatient);
        return new ResponseEntity<>(createdUserPatient, HttpStatus.CREATED);
    }

    @PutMapping("/{dni}")
    public ResponseEntity<?> updateUserPatient(@PathVariable Long dni, @RequestBody UserPatient userPatient) throws MyException {
        service.updateUserPatientByDni(dni, userPatient);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{dni}")
    public ResponseEntity<?> deleteUserPatientByDni(@PathVariable Long dni) {
        service.deleteUserPatientByDni(dni);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
