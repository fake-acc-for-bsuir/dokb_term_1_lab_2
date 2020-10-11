package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.CompanyData;

public interface ChangeCompanyUseCase {
    void changeCompany(CompanyData companyData) throws ApplicationException;
}
