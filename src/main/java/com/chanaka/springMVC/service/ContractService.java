package com.chanaka.springMVC.service;

import java.util.List;

import com.chanaka.springMVC.model.Contract;

public interface ContractService {

    public void addContract(Contract p);
    public void updateContract(Contract p);
    public List<Contract> listContracts();
    public Contract getContractById(int id);
    public void removeContract(int id);

}