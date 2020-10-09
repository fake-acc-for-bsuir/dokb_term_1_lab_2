package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.DischargeData;

import java.util.Date;
import java.util.List;

public interface RetrieveDischargeUseCase {
    DischargeData retrieveDischarge(int id) throws ApplicationException;

    List<DischargeData> retrieveDischargesByCompany(int company) throws ApplicationException;

    List<DischargeData> retrieveDischargesBYCompanyAndTime(int company, Date since, Date until)
            throws ApplicationException;
}
