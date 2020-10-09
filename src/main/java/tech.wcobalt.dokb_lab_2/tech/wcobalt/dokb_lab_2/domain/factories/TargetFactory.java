package tech.wcobalt.dokb_lab_2.domain.factories;

import tech.wcobalt.dokb_lab_2.domain.Target;

public interface TargetFactory {
    Target createTarget(int id, String name, double distance);
}
