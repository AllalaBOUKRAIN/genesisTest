package com.quickwin.demoproject.services;

import com.quickwin.demoproject.entities.Contact;

import java.util.List;

public interface IContactService {

    Contact createContact(Contact contact);

    Contact updateContact(Contact contact);

    List< Contact > getAllContact();

    Contact getContactById(long contactId);

    void deleteContact(long id);
}
