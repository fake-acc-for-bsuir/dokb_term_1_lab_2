package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.ClassifiedPollutantData;

public interface ChangeClassifiedPollutantUseCase {
    void createClassifiedPollutant(ClassifiedPollutantData classifiedPollutantData) throws ApplicationException;
}
