package com.quickwin.demoproject.controllers;

import com.quickwin.demoproject.entities.Contact;
import com.quickwin.demoproject.repositories.IContactRepo;
import com.quickwin.demoproject.services.IContactService;
import com.quickwin.demoproject.utilities.ContactValidationUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ContactController {

    @Autowired
    private IContactService contactService;

    @GetMapping("/contacts")
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok().body(contactService.getAllContact());
    }

    @GetMapping("/contacts/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        return ResponseEntity.ok().body(contactService.getContactById(id));
    }

    @PostMapping("/contacts")
    public ResponseEntity<Contact> saveContact(@RequestBody Contact contact) {
        return ResponseEntity.ok().body(this.contactService.createContact(contact));
    }

    @PutMapping("/contacts")
    public ResponseEntity<Contact> updateContact(@PathVariable long id, @RequestBody Contact contact) {
        contact.setId(id);
        return ResponseEntity.ok().body(this.contactService.updateContact(contact));
    }

    @DeleteMapping("/contacts/{id}")
    public HttpStatus deleteContact(@PathVariable Long id) {
        this.contactService.deleteContact(id);
        return HttpStatus.OK;
    }
}
