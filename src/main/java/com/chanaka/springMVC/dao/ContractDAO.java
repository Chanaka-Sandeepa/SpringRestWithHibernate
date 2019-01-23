package com.chanaka.springMVC.dao;

import java.util.List;

import com.chanaka.springMVC.model.Contract;

public interface ContractDAO {

    public void addContract(Contract h);
    public void updateContract(Contract h);
    public List<Contract> listContracts();
    public Contract getContractById(int id);
    public void removeContract(int id);
}