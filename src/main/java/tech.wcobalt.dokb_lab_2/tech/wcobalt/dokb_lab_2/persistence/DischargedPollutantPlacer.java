package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.domain.DischargedPollutant;

public interface DischargedPollutantPlacer {
    DischargedPollutant createDischargedPollutant(DischargedPollutant dischargedPollutant) throws PersistenceException;

    void saveDischargedPollutant(DischargedPollutant dischargedPollutant) throws PersistenceException;

    void removeDischargedPollutant(int id) throws PersistenceException;
}
