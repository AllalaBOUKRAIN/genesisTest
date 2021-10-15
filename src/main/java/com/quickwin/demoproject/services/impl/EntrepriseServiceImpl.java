package com.quickwin.demoproject.services.impl;

import com.quickwin.demoproject.entities.Contact;
import com.quickwin.demoproject.entities.Entreprise;
import com.quickwin.demoproject.errors.ResourceNotFoundException;
import com.quickwin.demoproject.repositories.IContactRepo;
import com.quickwin.demoproject.repositories.IEntrepriseRepo;
import com.quickwin.demoproject.services.IContactService;
import com.quickwin.demoproject.services.IEntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EntrepriseServiceImpl implements IEntrepriseService {

    @Autowired
    private IEntrepriseRepo entrepriseRepo;

    @Override
    public Entreprise createEntreprise(Entreprise entreprise) {
        return entrepriseRepo.save(entreprise);
    }

    @Override
    public Entreprise updateEntreprise(Entreprise entreprise) {
        Optional< Entreprise > entrepriseDb = this.entrepriseRepo.findById(entreprise.getId());

        if (entrepriseDb.isPresent()) {

            Entreprise entrepriseUpdate = entrepriseDb.get();
            entrepriseUpdate.setId(entreprise.getId());
            entrepriseUpdate.setAddress(entreprise.getAddress());
            entrepriseUpdate.setNumeroTva(entreprise.getNumeroTva());
            entrepriseUpdate.setContacts(entreprise.getContacts());
            return entrepriseUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + entreprise.getId());
        }
    }

    @Override
    public List<Entreprise> getAllEntreprise() {
        return this.entrepriseRepo.findAll();
    }

    @Override
    public Entreprise getEntrepriseById(long entrepriseId) {
        Optional < Entreprise > entrepriseDb = this.entrepriseRepo.findById(entrepriseId);

        if (entrepriseDb.isPresent()) {
            return entrepriseDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + entrepriseId);
        }
    }

    @Override
    public void deleteEntreprise(long id) {
        Optional < Entreprise > entrepriseDb = this.entrepriseRepo.findById(id);

        if (entrepriseDb.isPresent()) {
            this.entrepriseRepo.delete(entrepriseDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
