package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.domain.Company;

import java.sql.Connection;
import java.util.List;

public class DefaultCompanyRetriever implements CompanyRetriever {
    private Connection connection;

    public DefaultCompanyRetriever(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Company loadCompanies(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Company> loadAllCompanies() throws PersistenceException {
        return null;
    }
}
