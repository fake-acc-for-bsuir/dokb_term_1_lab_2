package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.PollutantData;

import java.util.List;

public interface RetrievePollutantUseCase {
    List<PollutantData> retrieveAllPollutants() throws ApplicationException;
}
