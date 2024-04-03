package com.recursospropios.facturacion.controller;

import com.recursospropios.facturacion.entity.SocialSecurity;
import com.recursospropios.facturacion.entity.UserPatient;
import com.recursospropios.facturacion.exceptions.MyException;
import com.recursospropios.facturacion.service.SocialSecurityService;
import com.recursospropios.facturacion.service.UserPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialSecurity")
public class SocialSecurityController {

    @Autowired
    private SocialSecurityService service;

    @GetMapping("")
    public ResponseEntity<List<SocialSecurity>> searchAllSocialSecurity() {
        return ResponseEntity.ok(service.searchAllSocialSecurity());
    }

    @GetMapping("/{rnos}")
    public ResponseEntity<SocialSecurity> searchSocialSecurityByRnos(@PathVariable Long rnos) {
        return new ResponseEntity<>(service.searchUserSocialSecurityByRnos(rnos), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<SocialSecurity> createSocialSecurity(@RequestBody SocialSecurity socialSecurity) throws MyException {
        SocialSecurity createdSocialSecurity = service.createSocialSecurity(socialSecurity);
        return new ResponseEntity<>(createdSocialSecurity, HttpStatus.CREATED);
    }

    @PutMapping("/{rnos}")
    public ResponseEntity<?> updateSocialSecurity(@PathVariable Long rnos, @RequestBody SocialSecurity socialSecurity) throws MyException {
        service.updateSocialSecurityByRnos(rnos, socialSecurity);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{rnos}")
    public ResponseEntity<?> deleteSocialSecurityByRnos(@PathVariable Long rnos) {
        service.deleteSocialSecurityByRnos(rnos);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
