package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.domain.Pollutant;

import java.util.List;

public interface PollutantRetriever {
    List<Pollutant> loadAllPollutants() throws PersistenceException;
}
