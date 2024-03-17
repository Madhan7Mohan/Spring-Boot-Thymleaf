package com.integrate.form;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
    @Autowired
    private FormDataRepository formDataRepository;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("formData", new FormData());
        return "form";
    }

    @PostMapping("/form")
    public String submitForm(@ModelAttribute FormData formData, Model model) {
        formDataRepository.save(formData);
        model.addAttribute("successMessage", true);
        return "redirect:/form";
    }
}
