package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.ClassifiedPollutantData;

import java.util.List;

public interface RetrieveClassifiedPollutantUseCase {
    ClassifiedPollutantData retrieveClassifiedPollutant(int id) throws ApplicationException;

    List<ClassifiedPollutantData> retrieveClassifiedPollutantsByCompany(int company) throws ApplicationException;
}
