package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.DischargeData;
import tech.wcobalt.dokb_lab_2.persistence.DischargeRetriever;

import java.util.Date;
import java.util.List;

public class DefaultRetrieveDischargeUseCase implements RetrieveDischargeUseCase {
    private DischargeRetriever dischargeRetriever;

    public DefaultRetrieveDischargeUseCase(DischargeRetriever dischargeRetriever) {
        this.dischargeRetriever = dischargeRetriever;
    }

    @Override
    public DischargeData retrieveDischarge(int id) throws ApplicationException {
        return null;
    }

    @Override
    public List<DischargeData> retrieveDischargesByCompany(int company) throws ApplicationException {
        return null;
    }

    @Override
    public List<DischargeData> retrieveDischargesByCompanyAndTime(int company, Date since, Date until) throws ApplicationException {
        return null;
    }
}
