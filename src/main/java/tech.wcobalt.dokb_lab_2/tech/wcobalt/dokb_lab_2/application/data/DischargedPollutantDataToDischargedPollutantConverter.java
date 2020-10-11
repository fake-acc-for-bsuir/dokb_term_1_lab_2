package tech.wcobalt.dokb_lab_2.application.data;

import tech.wcobalt.dokb_lab_2.domain.DischargedPollutant;

public interface DischargedPollutantDataToDischargedPollutantConverter {
    DischargedPollutant convertDischargedPollutantDataToDischargedPollutant(DischargedPollutantData dischargedPollutantData);
}
