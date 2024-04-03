package com.recursospropios.facturacion.service;

import com.recursospropios.facturacion.entity.UserPatient;
import com.recursospropios.facturacion.exceptions.MyException;
import com.recursospropios.facturacion.repository.IUserPatientRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserPatientService {
    @Autowired
    private IUserPatientRepository iUserPatientRepository;

    @Transactional()
    public List<UserPatient> searchAllUserPatient() {
        return iUserPatientRepository.findAll();
    }

    @Transactional()
    public UserPatient searchUserPatientByDni(Long dni) {
        return iUserPatientRepository.searchByDni(dni);
    }

    @Transactional()
    public void deleteUserPatientByDni(Long dni) {
        iUserPatientRepository.deleteByDni(dni);
    }

    @Transactional()
    public UserPatient createUserPatient(UserPatient userPatient
    ) throws MyException {

        validate(userPatient.getDni(),
                userPatient.getNombre(),
                userPatient.getApellido(),
                userPatient.getTipo(),
                userPatient.getCantidad(),
                userPatient.getCodigo(),
                userPatient.getFechaInicio());

        UserPatient pacient = new UserPatient();

        pacient.setDni(userPatient.getDni());
        pacient.setNombre(userPatient.getNombre());
        pacient.setApellido(userPatient.getApellido());
        pacient.setTipo(userPatient.getTipo());
        pacient.setCantidad(userPatient.getCantidad());
        pacient.setCodigo(userPatient.getCodigo());
        pacient.setFechaInicio(userPatient.getFechaInicio());
        pacient.setFechaFin(userPatient.getFechaFin());
        pacient.setRnos(userPatient.getRnos());

        iUserPatientRepository.save(pacient);
        return pacient;
    }

    @Transactional()
    public void updateUserPatientByDni(Long dni, UserPatient userPatient
    ) throws MyException {

        UserPatient patient = searchUserPatientByDni(dni);
        if (userPatient != null && userPatient.getDni().equals(dni)) {

            validate(dni,
                    userPatient.getNombre(),
                    userPatient.getApellido(),
                    userPatient.getTipo(),
                    userPatient.getCantidad(),
                    userPatient.getCodigo(),
                    userPatient.getFechaInicio());

            patient.setNombre(userPatient.getNombre());
            patient.setApellido(userPatient.getApellido());
            patient.setTipo(userPatient.getTipo());
            patient.setCantidad(userPatient.getCantidad());
            patient.setCodigo(userPatient.getCodigo());
            patient.setFechaInicio(userPatient.getFechaInicio());
            patient.setFechaFin(userPatient.getFechaFin());
            patient.setRnos(userPatient.getRnos());

            iUserPatientRepository.save(patient);
        } else {
            throw new MyException("No se puede modificar el contacto del usuario.");
        }
    }

    public void validate(Long dni, String nombre, String apellido, String tipo, Integer cantidad,
                         Double codigo, LocalDate fechaInicio) throws MyException, MyException {
        if (dni == null) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (nombre.isEmpty() || nombre.isBlank()) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (apellido.isEmpty() || apellido.isBlank()) {
            throw new MyException("El campo Apellido no puede estar vacio");
        }
        if (tipo.isEmpty() || tipo.isBlank()) {
            throw new MyException("El campo Apellido no puede estar vacio");
        }
        if (cantidad == null) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (codigo == null) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (fechaInicio == null || fechaInicio.toString() == "") {
            throw new MyException("Fecha incorrecta");
        }
    }

}
