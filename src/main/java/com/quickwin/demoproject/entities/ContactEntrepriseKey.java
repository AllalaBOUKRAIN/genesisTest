package com.quickwin.demoproject.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import java.io.Serializable;

@Embeddable
public class ContactEntrepriseKey implements Serializable {

    @Column(name = "contact_id")
    Long contactId;

    @Column(name = "entreprise_id")
    Long entrepriseId;

    public Long getContactId() {
        return contactId;
    }

    public void setContactId(Long contactId) {
        this.contactId = contactId;
    }

    public Long getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(Long entrepriseId) {
        this.entrepriseId = entrepriseId;
    }
}
