package lk.mobitel.abcbank.api;

import lk.mobitel.abcbank.dto.CustomerDTO;
import lk.mobitel.abcbank.service.custom.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class CustomerHttpController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String welcomePage(){

        return "home";
    }

//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String loginPage(){
////        System.out.println("Incoming request");
//        return "home";
//    }

    @RequestMapping(value = "/customers",method = RequestMethod.GET)
    public String getAllCustomers(ModelMap model){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "view-customers";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String registerCustomer(ModelMap model){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "add-customer";
    }

    @RequestMapping(value = "/update",method = RequestMethod.GET)
    public String updateCustomer(ModelMap model){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "updateCustomer";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteCustomer(ModelMap model){
        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "delete-customer";
    }

    @RequestMapping(value = "/update/{customerNic}",method = RequestMethod.GET,produces = "application/json")
    public String editCustomer(ModelMap model,@PathVariable String customerNic){
        CustomerDTO customerDetails = customerService.getCustomerDetails(customerNic);
        model.put("customerDetails",customerDetails);
        return "edit-customer";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/x-www-form-urlencoded")
    public String registerCustomer(@Validated CustomerDTO customerDTO, ModelMap model) throws InterruptedException {
//        if (result.hasErrors()){
//            return "add-customer";
//        }

        customerService.saveCustomer(customerDTO);

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "add-customer";
    }



    @RequestMapping(value = "/delete/{customerNic}",method = RequestMethod.GET)
    public String deleteCustomer(@PathVariable String customerNic,ModelMap model){
        customerService.deleteCustomer(customerNic);

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "redirect:/delete";
    }


    @RequestMapping(value = "/update/{customerNic}",consumes = "application/x-www-form-urlencoded",method = RequestMethod.POST)
    public String updateCustomer(@PathVariable String customerNic,@Validated CustomerDTO customerDTO,ModelMap model){
        customerDTO.setNic(customerNic);
        customerService.updateCustomer(customerDTO);

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();
        model.put("customerList",allCustomers);
        return "redirect:/update";
    }

}
