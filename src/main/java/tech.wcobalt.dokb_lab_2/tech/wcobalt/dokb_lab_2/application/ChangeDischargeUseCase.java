package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.DischargeData;

import java.util.Date;

public interface ChangeDischargeUseCase {
    void createDischarge(DischargeData dischargeData) throws ApplicationException;
}
