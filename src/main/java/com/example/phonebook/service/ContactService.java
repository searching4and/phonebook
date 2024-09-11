package com.example.phonebook.service;

import com.example.phonebook.model.Contact;
import com.example.phonebook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact getContactById(Long id) {
        // service berikut digunakan untuk mencari contact berdasarkan id
        return contactRepository.findById(id).orElse(null);
    }

    public Contact updateContactById(Long id, Contact contactDetails) {
        // service berikut digunakan untuk update contact berdasarkan id
        Contact contact = getContactById(id);
        if (contact != null) {
            contact.setName(contactDetails.getName());
            contact.setPhoneNumber(contactDetails.getPhoneNumber());
            contact.setEmail(contactDetails.getEmail());
            return saveContact(contact);
        } else {
            return null;
        }
    }

    public List<Contact> getAllContacts() {
        // service berikut digunakan untuk mencari semua contact
        return contactRepository.findAll();
    }

    public Contact saveContact(Contact contact) {
        // service berikut digunakan untuk menyimpan contact baru
        return contactRepository.save(contact);
    }

    public void deleteContact(Long id) {
        // service berikut digunakan untuk menghapus contact berdasarkan id
        contactRepository.deleteById(id);
    }
}