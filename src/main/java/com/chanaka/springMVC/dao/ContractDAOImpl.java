package com.chanaka.springMVC.dao;

import java.util.List;

import com.chanaka.springMVC.model.Contract;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class ContractDAOImpl implements ContractDAO{

    private static final Logger logger = LoggerFactory.getLogger(ContractDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addContract(Contract h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(h);
        logger.info("Contract saved successfully, Contract Details="+h);
    }

    @Override
    public void updateContract(Contract h) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(h);
        logger.info("Contract updated successfully, Contract Details="+h);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contract> listContracts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Contract> contractList = session.createQuery("from Contract").list();
        for(Contract h : contractList){
            logger.info("Contract List::"+h);
        }
        return contractList;
    }

    @Override
    public Contract getContractById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contract p = (Contract) session.load(Contract.class, new Integer(id));
        logger.info("Contract loaded successfully, Contract details="+p);
        return p;
    }

    @Override
    public void removeContract(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Contract p = (Contract) session.load(Contract.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Contract deleted successfully, contract details="+p);
    }
}
