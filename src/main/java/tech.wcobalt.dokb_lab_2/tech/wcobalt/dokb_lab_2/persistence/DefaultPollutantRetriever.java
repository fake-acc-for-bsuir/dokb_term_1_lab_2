package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.application.ApplicationException;
import tech.wcobalt.dokb_lab_2.domain.Pollutant;

import java.sql.Connection;
import java.util.List;

public class DefaultPollutantRetriever implements PollutantRetriever {
    private Connection connection;

    public DefaultPollutantRetriever(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Pollutant> loadAllPollutants() throws ApplicationException {
        return null;
    }
}
