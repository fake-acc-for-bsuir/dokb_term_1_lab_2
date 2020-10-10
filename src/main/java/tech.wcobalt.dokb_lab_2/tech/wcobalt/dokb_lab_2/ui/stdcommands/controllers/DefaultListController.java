package tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.wcobalt.dokb_lab_2.application.*;
import tech.wcobalt.dokb_lab_2.application.data.CompanyData;
import tech.wcobalt.dokb_lab_2.application.data.DischargeData;
import tech.wcobalt.dokb_lab_2.application.data.PollutantData;
import tech.wcobalt.dokb_lab_2.application.data.TargetData;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.views.ListView;

import java.util.Date;
import java.util.List;

public class DefaultListController implements ListController {
    private ListView listView;
    private RetrieveTargetUseCase retrieveTargetUseCase;
    private RetrievePollutantUseCase retrievePollutantUseCase;
    private RetrieveCompanyUseCase retrieveCompanyUseCase;
    private RetrieveDischargeUseCase retrieveDischargeUseCase;

    private static final Logger logger = LogManager.getLogger(DefaultListController.class.getName());

    public DefaultListController(ListView listView, RetrieveTargetUseCase retrieveTargetUseCase,
                                 RetrievePollutantUseCase retrievePollutantUseCase,
                                 RetrieveCompanyUseCase retrieveCompanyUseCase,
                                 RetrieveDischargeUseCase retrieveDischargeUseCase) {
        this.listView = listView;
        this.retrieveTargetUseCase = retrieveTargetUseCase;
        this.retrievePollutantUseCase = retrievePollutantUseCase;
        this.retrieveCompanyUseCase = retrieveCompanyUseCase;
        this.retrieveDischargeUseCase = retrieveDischargeUseCase;
    }

    @Override
    public void init() {
        listView.init();
    }

    @Override
    public void listTargets() {
        try {
            List<TargetData> targets = retrieveTargetUseCase.retrieveAllTargets();

            for (TargetData target : targets)
                listView.showTarget(target);
        } catch (ApplicationException exc) {
            logger.error("Unable to retrieve targets", exc);
        }
    }

    @Override
    public void listPollutants() {
        try {
            List<PollutantData> pollutants = retrievePollutantUseCase.retrieveAllPollutants();

            for (PollutantData pollutant : pollutants)
                listView.showPollutant(pollutant);
        } catch (ApplicationException exc) {
            logger.error("Unable to retrieve pollutants", exc);
        }
    }

    @Override
    public void listCompanies() {
        try {
            List<CompanyData> companies = retrieveCompanyUseCase.retrieveAllCompanies();

            for (CompanyData company : companies)
                listView.showCompany(company);
        } catch (ApplicationException exc) {
            logger.error("Unable to retrieve company", exc);
        }
    }

    @Override
    public void listDischargesByCompany(int company) {
        try {
            List<DischargeData> discharges = retrieveDischargeUseCase.retrieveDischargesByCompany(company);

            showDischarges(discharges);
        } catch (ApplicationException exc) {
            logger.error("Unable to retrieve discharges by company", exc);
        }
    }

    @Override
    public void listDischargesByCompanyAndTime(int company, Date since, Date until) {
        try {
            List<DischargeData> discharges = retrieveDischargeUseCase.
                    retrieveDischargesByCompanyAndTime(company, since, until);

            showDischarges(discharges);
        } catch (ApplicationException exc) {
            logger.error("Unable to retrieve discharges by company and time", exc);
        }
    }

    private void showDischarges(List<DischargeData> discharges) {
        for (DischargeData discharge : discharges)
            listView.showDischarge(discharge);
    }
}
