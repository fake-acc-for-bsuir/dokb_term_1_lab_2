package tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters;

import tech.wcobalt.dokb_lab_2.application.data.PollutantData;
import tech.wcobalt.dokb_lab_2.application.data.TargetData;

public interface ListView {
    void showTarget(TargetData targetData);

    void showPollutant(PollutantData pollutantData);
}
