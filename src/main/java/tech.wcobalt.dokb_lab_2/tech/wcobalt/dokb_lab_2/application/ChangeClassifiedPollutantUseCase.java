package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.ClassifiedPollutantData;

public interface ChangeClassifiedPollutantUseCase {
    void changeClassifiedPollutant(ClassifiedPollutantData classifiedPollutantData) throws ApplicationException;
}
