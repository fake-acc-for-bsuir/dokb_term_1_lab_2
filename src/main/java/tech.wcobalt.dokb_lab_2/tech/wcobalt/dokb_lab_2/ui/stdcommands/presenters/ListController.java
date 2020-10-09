package tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters;

import tech.wcobalt.dokb_lab_2.ui.Controller;

import java.util.Date;

/*actually it violates SRP and ISP but this is just a lab and i'm so lazy.
* So in a good way this must be split.*/
public interface ListController extends Controller {
    void listTargets();

    void listPollutants();

    void listCompanies();

    void listDischargesByCompany(int company);

    void listDischargesByCompanyAndTime(int company, Date since, Date until);
}
