package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.DischargedPollutantData;

public interface ChangeDischargedPollutantUseCase {
    void changeDischargedPollutant(DischargedPollutantData dischargedPollutantData) throws ApplicationException;
}
