package tech.wcobalt.dokb_lab_2.ui.stdcommands.views;

import tech.wcobalt.dokb_lab_2.application.data.CompanyData;
import tech.wcobalt.dokb_lab_2.application.data.DischargeData;
import tech.wcobalt.dokb_lab_2.application.data.PollutantData;
import tech.wcobalt.dokb_lab_2.application.data.TargetData;
import tech.wcobalt.dokb_lab_2.ui.View;

public interface ListView extends View {
    void showTarget(TargetData targetData);

    void showPollutant(PollutantData pollutantData);

    void showCompany(CompanyData companyData);

    void showDischarge(DischargeData dischargeData);
}
