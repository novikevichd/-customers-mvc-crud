package com.myproject.customercrud.controller;

import com.myproject.customercrud.dao.CustomerDAO;
import com.myproject.customercrud.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    // add an initBinder to trim input strings
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor =
                new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    CustomerDAO customerDAO;

    @Autowired
    CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get customer from db
        List<Customer> customers = customerDAO.findAll();

        // add to the spring model
        theModel.addAttribute("customers", customers);

        return "customers/customers-list";
    }

    @GetMapping("/showFormForAddCustomer")
    public String showFormForAddCustomer(Model theModel) {

        // create model attribute to bind data from add-new-customer form
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customers/add-new-customer";

    }

    @GetMapping("/showFormForUpdateCustomer")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        // get the customer from dao
        Customer theCustomer = customerDAO.findById(theId);

        // set customer as a model attribute
        theModel.addAttribute("customer", theCustomer);

        // send to form for customer saving
        return "customers/add-new-customer";


    }

    @PostMapping("/save")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer theCustomer,
                               BindingResult theBindingResult){

        // if BindingResult has errors return add/update customer form
        if (theBindingResult.hasErrors()) return "customers/add-new-customer";

        // save customer
        customerDAO.save(theCustomer);

        // use redirect to prevent duplicate submissions
        return "redirect:/customers/list";

    }

    @GetMapping("/delete")
    public String delete(@RequestParam("customerId") int theId) {

        // delete the customer
        customerDAO.deleteById(theId);

        // redirect to /customers/list
        return "redirect:/customers/list";
    }

}
