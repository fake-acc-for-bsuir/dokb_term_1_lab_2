package tech.wcobalt.dokb_lab_2.application.data.factories;

import tech.wcobalt.dokb_lab_2.application.data.DischargedPollutantData;

public interface DischargedPollutantDataFactory {
    DischargedPollutantData createDischargedPollutantData(int id, int discharge, int pollutant, double concentration,
                                                          double ncc, double backgroundConcentration, double mpc);
}
