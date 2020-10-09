package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.domain.Discharge;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class DefaultDischargeRetriever implements DischargeRetriever {
    private Connection connection;

    public DefaultDischargeRetriever(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Discharge loadDischarge(int id) throws PersistenceException {
        return null;
    }

    @Override
    public List<Discharge> loadDischargesByCompany(int company) throws PersistenceException {
        return null;
    }

    @Override
    public List<Discharge> loadDischargesByCompanyAndTime(int company, Date since, Date until) throws PersistenceException {
        return null;
    }
}
