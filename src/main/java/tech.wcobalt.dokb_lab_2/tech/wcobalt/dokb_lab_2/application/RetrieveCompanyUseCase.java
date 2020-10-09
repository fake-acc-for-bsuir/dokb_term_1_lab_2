package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.CompanyData;

import java.util.List;

public interface RetrieveCompanyUseCase {
    List<CompanyData> retrieveAllCompanies() throws ApplicationException;

    CompanyData retrieveCompany(int id) throws ApplicationException;
}
