package tech.wcobalt.dokb_lab_2.domain.factories;

import tech.wcobalt.dokb_lab_2.domain.Discharge;

import java.util.Date;

public interface DischargeFactory {
    Discharge createDischarge(int id, int company, int usedTarget, String name, Date date, double diameter,
                              double minimalWaterSpeed, double wastewaterConsumption, double angle,
                              double distanceToSurface, double distanceToShore);
}
