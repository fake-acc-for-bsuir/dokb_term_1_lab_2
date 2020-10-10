package tech.wcobalt.dokb_lab_2.domain.factories;

import tech.wcobalt.dokb_lab_2.domain.Pollutant;

public interface PollutantFactory {
    Pollutant createPollutant(int id, String name);
}
