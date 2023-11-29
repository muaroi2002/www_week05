package fit.iuh.edu.vn.week5.controllers;

import fit.iuh.edu.vn.week5.entities.Address;
import fit.iuh.edu.vn.week5.entities.Candidate;
import fit.iuh.edu.vn.week5.entities.Company;
import fit.iuh.edu.vn.week5.repositories.AddressRepository;
import fit.iuh.edu.vn.week5.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/companys")
    private  String  showCandidateList(Model model){
        model.addAttribute("companyList",companyRepository.findAll());
        return "company/list";
    }
    @GetMapping ("/companys/show-add-form")
    private String showFormAdd(Model model){
        Company company = new Company();
        List<Address> addressList = addressRepository.findAll();
        model.addAttribute("companyAdd", company);
        model.addAttribute("addressList", addressList);
        return "/company/add";
    }
    @PostMapping("/companys/add")
    public String addCandidate(
            @ModelAttribute("companyAdd")    Company company,
            BindingResult result , Model model) {
        companyRepository.save(company);
        return "redirect:/companys";
    }
    @GetMapping("/companys/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id){
        Company company = companyRepository.findById(id).orElse(new Company());
        companyRepository.delete(company);
        return "redirect:/companys";
    }
    @GetMapping("/companys/show-edit-form/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Company company = companyRepository.findById(id).orElse(null);
        List<Address> addressList = addressRepository.findAll();
        model.addAttribute("companyUpdate", company);
        model.addAttribute("addressList", addressList);
        return "company/update";
    }
    @PostMapping("/companys/update/{id}")
    public String updateCompany(@PathVariable("id") long id,
                                  @ModelAttribute("companyUpdate")  Company updateCompany) {
        Company company = companyRepository.findById(id).orElse(null);
        if (company != null) {
            company.setName(updateCompany.getName());
            company.setAbout(updateCompany.getAbout());
            company.setEmail(updateCompany.getEmail());
            company.setPhone(updateCompany.getPhone());
            company.setWebUrl(updateCompany.getWebUrl());
            company.setAddress(updateCompany.getAddress());
            companyRepository.save(company);
        }
        return "redirect:/companys";
    }

}
