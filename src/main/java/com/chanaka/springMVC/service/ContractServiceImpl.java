package com.chanaka.springMVC.service;

import java.util.List;

import com.chanaka.springMVC.dao.ContractDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chanaka.springMVC.model.Contract;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractDAO contractDAO;

    public void setContractDAO(ContractDAO contractDAO) {
        this.contractDAO = contractDAO;
    }

    @Override
    @Transactional
    public void addContract(Contract p) {
        this.contractDAO.addContract(p);
    }

    @Override
    @Transactional
    public void updateContract(Contract p) {
        this.contractDAO.updateContract(p);
    }

    @Override
    @Transactional
    public List<Contract> listContracts() {
        return this.contractDAO.listContracts();
    }

    @Override
    @Transactional
    public Contract getContractById(int id) {
        return this.contractDAO.getContractById(id);
    }

    @Override
    @Transactional
    public void removeContract(int id) {
        this.contractDAO.removeContract(id);
    }

}
