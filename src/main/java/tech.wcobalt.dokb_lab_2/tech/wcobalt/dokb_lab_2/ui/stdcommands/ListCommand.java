package tech.wcobalt.dokb_lab_2.ui.stdcommands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.wcobalt.dokb_lab_2.ui.Command;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters.ListController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ListCommand implements Command {
    private final String COMMAND = "list";
    private final String TARGETS = "targets";
    private final String POLLUTANTS = "pollutants";
    private final String COMPANIES = "companies";
    private final String DISCHARGES = "discharges";
    private final String UNDEFINED_COMMAND = "The subcommand is undefined";
    private final String WRONG_FORMAT = "Wrong format of the command";

    private boolean isPresenterInitialized = false;

    private static final Logger logger = LogManager.getLogger(ListCommand.class.getName());
    private ListController listPresenter;

    public ListCommand(ListController listPresenter) {
        this.listPresenter = listPresenter;
    }

    @Override
    public boolean isThisIt(String query) {
        return query.split(" ")[0].toLowerCase().equals(COMMAND);
    }

    @Override
    public void run(String commandString) {
        if (!isPresenterInitialized)
            listPresenter.init();

        String[] splitQuery = commandString.split(" ");

        if (splitQuery.length > 1) {
            String subject = splitQuery[1].toLowerCase();

            switch (subject) {
                case TARGETS:
                    listPresenter.listTargets();

                    break;

                case POLLUTANTS:
                    listPresenter.listPollutants();

                    break;

                case COMPANIES:
                    listPresenter.listCompanies();

                    break;

                case DISCHARGES:
                    handleDischarges(splitQuery);

                    break;

                default:
                    printUndefinedCommand();
            }
        } else
            printUndefinedCommand();
    }

    private void handleDischarges(String[] splitQuery) {
        if (splitQuery.length >= 3) {
            //by company

            try {
                int company = Integer.parseInt(splitQuery[2]);

                if (splitQuery.length == 5) {
                    //by company + time

                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

                    try {
                        Date since = simpleDateFormat.parse(splitQuery[3]);
                        Date until = simpleDateFormat.parse(splitQuery[4]);

                        listPresenter.listDischargesByCompanyAndTime(company, since, until);
                    } catch (ParseException exc) {
                        logger.error("Input: " + splitQuery[3] + ", " + splitQuery[4], exc);
                        printWrongFormat();
                    }
                } else if (splitQuery.length == 3)
                    listPresenter.listDischargesByCompany(company);
                else
                    printWrongFormat();
            } catch (NumberFormatException exc) {
                logger.error("Input: " + splitQuery[2], exc);
                printWrongFormat();
            }
        }
    }

    private void printUndefinedCommand() {
        System.out.println(UNDEFINED_COMMAND);
    }

    private void printWrongFormat() {
        System.out.println(WRONG_FORMAT);
    }
}
