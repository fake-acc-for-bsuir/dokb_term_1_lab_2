package tech.wcobalt.dokb_lab_2.application.data;

import tech.wcobalt.dokb_lab_2.domain.Discharge;

public interface DischargeDataToDischargeConverter {
    Discharge convertDischargeDataToDischarge(DischargeData dischargeData);
}
