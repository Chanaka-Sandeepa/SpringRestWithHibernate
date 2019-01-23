package com.chanaka.springMVC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.chanaka.springMVC.model.Contract;
import com.chanaka.springMVC.service.ContractService;

import java.util.List;

@RestController
public class ContractController {

    private ContractService contractService;

    @Autowired(required=true)
    @Qualifier(value="contractService")
    public void setcontractService(ContractService hs){
        this.contractService = hs;
    }

    @RequestMapping(value = "/contracts", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<Contract> listContracts(Model model) {
        return this.contractService.listContracts();
    }

    //For add and update contract both
    @RequestMapping(value= "/contract/add", method = RequestMethod.POST)
    public List<Contract> addContract(@ModelAttribute("contract") Contract h, @RequestParam(value = "id", required = false) String id, @RequestParam("name") String name,
                                @RequestParam("address") String address, @RequestParam("city") String City,@RequestParam("country") String Country){
        if (id != null){
            this.contractService.updateContract(h);
        }else {
            this.contractService.addContract(h);
        }
        return this.contractService.listContracts();
    }

    @RequestMapping("contract/remove/{id}")
    public List<Contract> removeContract(@PathVariable("id") int id){

        this.contractService.removeContract(id);
        return this.contractService.listContracts();
    }

//    @RequestMapping("/edit/{id}")
//    public String editContract(@PathVariable("id") int id, Model model){
//        model.addAttribute("contract", this.contractService.getContractById(id));
//        model.addAttribute("listcontracts", this.contractService.listContracts());
//        return "contract";
//    }

}
