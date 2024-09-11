package com.example.phonebook.controller;

import com.example.phonebook.model.Contact;
import com.example.phonebook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contacts")
public class ContactThymeleafController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public String getAllContacts(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "index";
    }

    @PostMapping
    public String addContact(@ModelAttribute Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }

    @GetMapping("/delete/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return "redirect:/contacts";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Contact contact = contactService.getContactById(id);
        model.addAttribute("contact", contact);
        return "edit";
    }

    @PostMapping("/update")
    public String updateContact(@ModelAttribute Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/contacts";
    }
}
