package com.recursospropios.facturacion.service;

import com.recursospropios.facturacion.entity.SocialSecurity;
import com.recursospropios.facturacion.exceptions.MyException;
import com.recursospropios.facturacion.repository.ISocialSecurityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialSecurityService {
    @Autowired
    private ISocialSecurityRepository repository;

    @Transactional()
    public List<SocialSecurity> searchAllSocialSecurity() {
        return repository.findAll();
    }

    @Transactional()
    public SocialSecurity searchUserSocialSecurityByRnos(Long rnos) {
        return repository.searchByRnos(rnos);
    }

    @Transactional()
    public void deleteSocialSecurityByRnos(Long rnos) {
        repository.deleteByRnos(rnos);
    }

    @Transactional()
    public SocialSecurity createSocialSecurity(SocialSecurity socialSecurity
    ) throws MyException {

        validate(socialSecurity.getRnos(),
                socialSecurity.getCompanyName(),
                socialSecurity.getAddress(),
                socialSecurity.getZipCode(),
                socialSecurity.getProvince(),
                socialSecurity.getCuit(),
                socialSecurity.getIva(),
                socialSecurity.getCity());

        SocialSecurity newSocialSecurity = new SocialSecurity();

        newSocialSecurity.setRnos(socialSecurity.getRnos());
        newSocialSecurity.setCompanyName(socialSecurity.getCompanyName());
        newSocialSecurity.setInitials(socialSecurity.getInitials());
        newSocialSecurity.setAddress(socialSecurity.getAddress());
        newSocialSecurity.setWeb(socialSecurity.getWeb());
        newSocialSecurity.setZipCode(socialSecurity.getZipCode());
        newSocialSecurity.setProvince(socialSecurity.getProvince());
        newSocialSecurity.setCuit(socialSecurity.getCuit());
        newSocialSecurity.setIva(socialSecurity.getIva());
        newSocialSecurity.setCity(socialSecurity.getCity());

        repository.save(newSocialSecurity);
        return newSocialSecurity;
    }

    @Transactional()
    public void updateSocialSecurityByRnos(Long rnos, SocialSecurity socialSecurity
    ) throws MyException {

        SocialSecurity newSocialSecurity = searchUserSocialSecurityByRnos(rnos);

        if (socialSecurity != null && socialSecurity.getRnos().equals(rnos)) {

            validate(socialSecurity.getRnos(),
                    socialSecurity.getCompanyName(),
                    socialSecurity.getAddress(),
                    socialSecurity.getZipCode(),
                    socialSecurity.getProvince(),
                    socialSecurity.getCuit(),
                    socialSecurity.getIva(),
                    socialSecurity.getCity());

            SocialSecurity newSocialSecurity1 = new SocialSecurity();

            newSocialSecurity1.setCompanyName(socialSecurity.getCompanyName());
            newSocialSecurity1.setInitials(socialSecurity.getInitials());
            newSocialSecurity1.setAddress(socialSecurity.getAddress());
            newSocialSecurity1.setWeb(socialSecurity.getWeb());
            newSocialSecurity1.setZipCode(socialSecurity.getZipCode());
            newSocialSecurity1.setProvince(socialSecurity.getProvince());
            newSocialSecurity1.setCuit(socialSecurity.getCuit());
            newSocialSecurity1.setIva(socialSecurity.getIva());
            newSocialSecurity1.setCity(socialSecurity.getCity());

            repository.save(newSocialSecurity1);
        } else {
            throw new MyException("No se puede modificar el contacto la obra social.");
        }
    }

    public void  validate(Long rnos,
                          String companyName,
                          String address,
                          String zipCode,
                          String province,
                          String cuit,
                          String iva,
                          String city) throws  MyException {
        if (rnos == null) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (companyName.isEmpty() || companyName.isBlank()) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (address.isEmpty() || address.isBlank()) {
            throw new MyException("El campo Apellido no puede estar vacio");
        }
        if (province.isEmpty() || province.isBlank()) {
            throw new MyException("El campo Apellido no puede estar vacio");
        }
        if (iva.isEmpty() || iva.isBlank()) {
            throw new MyException("El campo Apellido no puede estar vacio");
        }
        if (city.isEmpty() || city.isBlank()) {
            throw new MyException("El campo Apellido no puede estar vacio");
        }
        if (zipCode == null) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }
        if (cuit == null) {
            throw new MyException("El campo Nombre no puede estar vacio");
        }

    }

}
