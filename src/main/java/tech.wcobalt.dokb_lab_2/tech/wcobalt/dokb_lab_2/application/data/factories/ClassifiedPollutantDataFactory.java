package tech.wcobalt.dokb_lab_2.application.data.factories;

import tech.wcobalt.dokb_lab_2.application.data.ClassifiedPollutantData;

public interface ClassifiedPollutantDataFactory {
    ClassifiedPollutantData createClassifiedPollutantData(int id, int company, int pollutant, String dangerClass,
                                                          String lfvGroup);
}
