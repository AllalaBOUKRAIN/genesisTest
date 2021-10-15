package com.quickwin.demoproject.entities;

import com.quickwin.demoproject.controllers.ContactController;
import com.quickwin.demoproject.utilities.ContactEntrepriseRelationType;

import javax.persistence.*;

@Entity
public class ContactEntreprise {

    @EmbeddedId
    ContactEntrepriseKey id;

    @ManyToOne
    @MapsId("contactId")
    @JoinColumn(name = "contact_id")
    Contact contact;

    @ManyToOne
    @MapsId("entrepriseId")
    @JoinColumn(name = "entreprise_id")
    Entreprise entreprise;

    private ContactEntrepriseRelationType typeRelation;

    public ContactEntrepriseKey getId() {
        return id;
    }

    public void setId(ContactEntrepriseKey id) {
        this.id = id;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    public ContactEntrepriseRelationType getTypeRelation() {
        return typeRelation;
    }

    public void setTypeRelation(ContactEntrepriseRelationType typeRelation) {
        this.typeRelation = typeRelation;
    }

}
