package com.example.phonebook.controller;

import com.example.phonebook.model.Contact;
import com.example.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            return ResponseEntity.ok(contact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody Contact contactDetails) {
        return ResponseEntity.ok(contactService.updateContactById(id, contactDetails));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        Contact contact = contactService.getContactById(id);
        if (contact != null) {
            contactService.deleteContact(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}