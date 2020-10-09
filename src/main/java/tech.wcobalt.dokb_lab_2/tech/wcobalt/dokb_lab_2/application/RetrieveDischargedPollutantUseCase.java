package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.DischargedPollutantData;

import java.util.List;

public interface RetrieveDischargedPollutantUseCase {
    DischargedPollutantData retrieveDischargedPollutant(int id) throws ApplicationException;

    List<DischargedPollutantData> retrieveDischargedPollutantsByCompany(int company) throws ApplicationException;
}
