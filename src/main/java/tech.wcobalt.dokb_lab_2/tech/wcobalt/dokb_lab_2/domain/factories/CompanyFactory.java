package tech.wcobalt.dokb_lab_2.domain.factories;

import tech.wcobalt.dokb_lab_2.domain.Company;

public interface CompanyFactory {
    Company createCompany(int id, String name);
}
