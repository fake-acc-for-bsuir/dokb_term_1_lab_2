package tech.wcobalt.dokb_lab_2.domain.factories;

import tech.wcobalt.dokb_lab_2.domain.ClassifiedPollutant;

public interface ClassifiedPollutantFactory {
    ClassifiedPollutant createClassifiedPollutant(int id, int company, int pollutant, String dangerClass, String lfvGroup);
}
