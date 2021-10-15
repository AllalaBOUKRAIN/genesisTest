package com.quickwin.demoproject.services;

import com.quickwin.demoproject.entities.Contact;
import com.quickwin.demoproject.entities.Entreprise;

import java.util.List;

public interface IEntrepriseService {

    Entreprise createEntreprise(Entreprise entreprise);

    Entreprise updateEntreprise(Entreprise entreprise);

    List< Entreprise > getAllEntreprise();

    Entreprise getEntrepriseById(long entrepriseId);

    void deleteEntreprise(long id);
}
