package tech.wcobalt.dokb_lab_2.ui.stdcommands.views;

import tech.wcobalt.dokb_lab_2.application.data.*;
import tech.wcobalt.dokb_lab_2.ui.View;

public interface ListCommandView extends View {
    void showTarget(TargetData targetData);

    void showPollutant(PollutantData pollutantData);

    void showCompany(CompanyData companyData);

    void showDischarge(DischargeData dischargeData);

    void showClassifiedPollutant(ClassifiedPollutantData classifiedPollutantData);

    void showDischargedPollutant(DischargedPollutantData dischargedPollutantData);
}
