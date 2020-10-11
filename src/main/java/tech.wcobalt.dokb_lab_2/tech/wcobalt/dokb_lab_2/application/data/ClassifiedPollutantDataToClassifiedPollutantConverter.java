package tech.wcobalt.dokb_lab_2.application.data;

import tech.wcobalt.dokb_lab_2.domain.ClassifiedPollutant;

public interface ClassifiedPollutantDataToClassifiedPollutantConverter {
    ClassifiedPollutant convertClassifiedPollutantDataToClassifiedPollutant(ClassifiedPollutantData classifiedPollutantData);
}
