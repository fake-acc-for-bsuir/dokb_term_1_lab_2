package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.CompanyData;
import tech.wcobalt.dokb_lab_2.persistence.CompanyRetriever;

import java.util.List;

public class DefaultRetrieveCompanyUseCase implements RetrieveCompanyUseCase {
    private CompanyRetriever companyRetriever;

    public DefaultRetrieveCompanyUseCase(CompanyRetriever companyRetriever) {
        this.companyRetriever = companyRetriever;
    }

    @Override
    public List<CompanyData> retrieveAllCompanies() throws ApplicationException {
        return null;
    }

    @Override
    public CompanyData retrieveCompany(int id) throws ApplicationException {
        return null;
    }
}
