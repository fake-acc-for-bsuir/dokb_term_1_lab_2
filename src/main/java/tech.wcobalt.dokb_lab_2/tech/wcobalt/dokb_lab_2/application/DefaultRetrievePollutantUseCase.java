package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.PollutantData;
import tech.wcobalt.dokb_lab_2.persistence.PollutantRetriever;

import java.util.List;

public class DefaultRetrievePollutantUseCase implements RetrievePollutantUseCase {
    private PollutantRetriever pollutantRetriever;

    public DefaultRetrievePollutantUseCase(PollutantRetriever pollutantRetriever) {
        this.pollutantRetriever = pollutantRetriever;
    }

    @Override
    public List<PollutantData> retrieveAllPollutants() throws ApplicationException {
        return null;
    }
}
