package com.myproject.customercrud.controller;

import com.myproject.customercrud.dao.CustomerDAO;
import com.myproject.customercrud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    CustomerDAO customerDAO;

    @Autowired
    CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        List<Customer> customers = customerDAO.findAll();

        theModel.addAttribute("customers", customers);

        return "customers/customers-list";
    }

    @GetMapping("/showFormForAddCustomer")
    public String showFormForAddCustomer(Model theModel) {

        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customers/add-new-customer";

    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer){

        customerDAO.save(theCustomer);

        return "redirect:/customers/list";

    }

}
