package tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers;

import tech.wcobalt.dokb_lab_2.ui.Controller;

public interface RemoveCommandController extends Controller {
    void removeCompany(int id);

    void removeDischarge(int id);

    void removeClassifiedPollutant(int id);

    void removeDischargedPollutant(int id);
}
