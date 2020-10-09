package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.domain.Company;

import java.util.List;

public interface CompanyRetriever {
    Company loadCompanies(int id) throws PersistenceException;

    List<Company> loadAllCompanies() throws PersistenceException;
}
