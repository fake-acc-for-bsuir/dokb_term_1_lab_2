package tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.wcobalt.dokb_lab_2.application.ApplicationException;
import tech.wcobalt.dokb_lab_2.application.RetrieveDischargeUseCase;
import tech.wcobalt.dokb_lab_2.application.data.DischargeData;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.views.ShowView;

public class DefaultShowController implements ShowController {
    private ShowView showView;
    private RetrieveDischargeUseCase retrieveDischargeUseCase;

    private static final Logger logger = LogManager.getLogger(DefaultShowController.class.getName());

    public DefaultShowController(ShowView showView, RetrieveDischargeUseCase retrieveDischargeUseCase) {
        this.showView = showView;
        this.retrieveDischargeUseCase = retrieveDischargeUseCase;
    }

    @Override
    public void init() {
        showView.init();
    }

    @Override
    public void showDischargesByCompany(int discharge) {
        try {
            DischargeData dischargeData = retrieveDischargeUseCase.retrieveDischarge(discharge);

            showView.showDischarge(dischargeData);
        } catch (ApplicationException exc) {
            logger.error("Unable to retrieve discharge by id", exc);
        }
    }
}
