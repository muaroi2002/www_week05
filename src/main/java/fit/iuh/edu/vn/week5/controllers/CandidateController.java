package fit.iuh.edu.vn.week5.controllers;

import fit.iuh.edu.vn.week5.entities.Address;
import fit.iuh.edu.vn.week5.entities.Candidate;
import fit.iuh.edu.vn.week5.repositories.AddressRepository;
import fit.iuh.edu.vn.week5.repositories.CandidateRepository;
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
public class CandidateController {
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private AddressRepository addressRepository;
    @GetMapping("/candidates")
    private  String  showCandidateList(Model model){
        model.addAttribute("candidateList",candidateRepository.findAll());
        return "candidate/list";
    }
    @GetMapping ("/candidates/show-add-form")
    private String showFormAdd(Model model){
        Candidate candidate = new Candidate();
        List<Address> addressList = addressRepository.findAll();
        model.addAttribute("candidateAdd", candidate);
        model.addAttribute("addressList", addressList);
        return "/candidate/add";
    }

    @PostMapping("/candidates/add")
    public String addCandidate(
            @ModelAttribute("candidateAdd")    Candidate candidate,
            BindingResult result , Model model) {
        candidateRepository.save(candidate);
        return "redirect:/candidates";
    }

    @GetMapping("/candidates/delete/{id}")
    public String deleteCandidate(@PathVariable("id") long id){
        Candidate candidate = candidateRepository.findById(id).orElse(new Candidate());
        candidateRepository.delete(candidate);
        return "redirect:/candidates";
    }
    @GetMapping("/candidates/show-edit-form/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        List<Address> addressList = addressRepository.findAll();
        model.addAttribute("candidateUpdate", candidate);
        model.addAttribute("addressList", addressList);
        return "candidate/update";
    }
    @PostMapping("/candidates/update/{id}")
    public String updateCandidate(@PathVariable("id") long id,
                                 @ModelAttribute("candidateUpdate")  Candidate updateCandidate) {
        Candidate candidate = candidateRepository.findById(id).orElse(null);
        if (candidate != null) {
            candidate.setFullName(updateCandidate.getFullName());
            candidate.setDob(updateCandidate.getDob());
            candidate.setEmail(updateCandidate.getEmail());
            candidate.setPhone(updateCandidate.getPhone());
            candidate.setAddress(updateCandidate.getAddress());
            candidateRepository.save(candidate);
        }
        return "redirect:/candidates";
    }

}
