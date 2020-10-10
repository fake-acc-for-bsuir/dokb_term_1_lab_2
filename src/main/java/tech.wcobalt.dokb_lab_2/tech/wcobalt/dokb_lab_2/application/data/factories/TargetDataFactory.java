package tech.wcobalt.dokb_lab_2.application.data.factories;

import tech.wcobalt.dokb_lab_2.application.data.TargetData;

public interface TargetDataFactory {
    TargetData createTargetData(int id, String name, double distance);
}
