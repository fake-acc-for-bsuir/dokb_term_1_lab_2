package tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers;

import tech.wcobalt.dokb_lab_2.ui.Controller;

/*actually it violates SRP and ISP but this is just a lab and i'm so lazy.
 * So in a good way this must be split.*/
public interface CreateCommandController extends Controller {
    void createCompany();

    void createDischarge();

    void createClassifiedPollutant();

    void createDischargedPollutant();
}
