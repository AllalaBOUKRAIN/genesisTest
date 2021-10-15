package com.quickwin.demoproject.services.impl;

import com.quickwin.demoproject.entities.Contact;
import com.quickwin.demoproject.errors.ResourceNotFoundException;
import com.quickwin.demoproject.repositories.IContactRepo;
import com.quickwin.demoproject.services.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactRepo contactRepo;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    }

    @Override
    public Contact updateContact(Contact contact) {
        Optional< Contact > contactDb = this.contactRepo.findById(contact.getId());

        if (contactDb.isPresent()) {
            Contact contactUpdate = contactDb.get();
            contactUpdate.setId(contact.getId());
            contactUpdate.setName(contact.getName());
            contactUpdate.setFirstname(contact.getFirstname());
            contactUpdate.setAddress(contact.getAddress());
            contactUpdate.setRelationType(contact.getRelationType());
            contactUpdate.setNumeroTva(contact.getNumeroTva());
            contactUpdate.setEntreprises(contact.getEntreprises());
            return contactUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + contact.getId());
        }
    }

    @Override
    public List<Contact> getAllContact() {
        return this.contactRepo.findAll();
    }

    @Override
    public Contact getContactById(long contactId) {
        Optional < Contact > contactDb = this.contactRepo.findById(contactId);

        if (contactDb.isPresent()) {
            return contactDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + contactId);
        }
    }

    @Override
    public void deleteContact(long id) {
        Optional < Contact > contactDb = this.contactRepo.findById(id);

        if (contactDb.isPresent()) {
            this.contactRepo.delete(contactDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
}
