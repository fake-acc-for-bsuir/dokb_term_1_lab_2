package tech.wcobalt.dokb_lab_2.application.data.factories;

import tech.wcobalt.dokb_lab_2.application.data.CompanyData;

public interface CompanyDataFactory {
    CompanyData createCompanyData(int id, String name);
}
