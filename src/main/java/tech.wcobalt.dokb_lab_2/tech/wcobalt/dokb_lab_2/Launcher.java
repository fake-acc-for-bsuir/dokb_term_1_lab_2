package tech.wcobalt.dokb_lab_2;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.logging.log4j.*;
import tech.wcobalt.dokb_lab_2.application.*;
import tech.wcobalt.dokb_lab_2.application.data.DefaultCompanyData;
import tech.wcobalt.dokb_lab_2.application.data.DefaultDischargeData;
import tech.wcobalt.dokb_lab_2.application.data.DefaultPollutantData;
import tech.wcobalt.dokb_lab_2.application.data.DefaultTargetData;
import tech.wcobalt.dokb_lab_2.domain.DefaultCompany;
import tech.wcobalt.dokb_lab_2.domain.DefaultDischarge;
import tech.wcobalt.dokb_lab_2.domain.DefaultPollutant;
import tech.wcobalt.dokb_lab_2.domain.DefaultTarget;
import tech.wcobalt.dokb_lab_2.persistence.*;
import tech.wcobalt.dokb_lab_2.ui.Command;
import tech.wcobalt.dokb_lab_2.ui.DefaultMainLoop;
import tech.wcobalt.dokb_lab_2.ui.MainLoop;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.ListCommand;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.ShowCommand;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers.DefaultListController;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers.DefaultShowController;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers.ShowController;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.views.DefaultListView;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.controllers.ListController;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.views.DefaultShowView;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.views.ListView;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.views.ShowView;

import java.sql.Connection;
import java.sql.SQLException;

public class Launcher {
    private final static Logger logger = LogManager.getLogger(Launcher.class.getName());
    private final static String PROGRAM_GREETINGS =
            "Welcome to dokb_lab_2!\n" +
                    "Available commands:\n" +
                    "create (company|discharge|classified_pollutant|discharged_pollutant)\n" +
                    "edit (company|discharge|classified_pollutant|discharged_pollutant) <id>\n" +
                    "remove (company|discharge|classified_pollutant|discharged_pollutant) <id>\n" +
                    "list (targets|pollutants|companies|discharges (<company_id>|<since_date> <until_date>)|\n..." +
                    "...classified_pollutants <company>|discharged_pollutants <company>) // date format: dd/MM/yyyy\n" +
                    "show discharge <id>";

    public static void main(String... args) {
        logger.debug("Entered the program");

        //connecting to MySQL
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("dokb_lab_2_db");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        dataSource.setServerName("localhost");

        try {
            Connection connection = dataSource.getConnection();

            //composing all needed objects

            //list command
            PollutantRetriever pollutantRetriever = new DefaultPollutantRetriever(connection, DefaultPollutant::new);
            RetrievePollutantUseCase retrievePollutantUseCase = new DefaultRetrievePollutantUseCase(pollutantRetriever,
                    DefaultPollutantData::new);

            TargetRetriever targetRetriever = new DefaultTargetRetriever(connection, DefaultTarget::new);
            RetrieveTargetUseCase retrieveTargetUseCase = new DefaultRetrieveTargetUseCase(targetRetriever,
                    DefaultTargetData::new);

            CompanyRetriever companyRetriever = new DefaultCompanyRetriever(connection, DefaultCompany::new);
            RetrieveCompanyUseCase retrieveCompanyUseCase = new DefaultRetrieveCompanyUseCase(companyRetriever,
                    DefaultCompanyData::new);

            DischargeRetriever dischargeRetriever = new DefaultDischargeRetriever(connection, DefaultDischarge::new);
            RetrieveDischargeUseCase retrieveDischargeUseCase = new DefaultRetrieveDischargeUseCase(dischargeRetriever,
                    DefaultDischargeData::new);

            ListView listView = new DefaultListView();
            ListController listController = new DefaultListController(listView, retrieveTargetUseCase,
                    retrievePollutantUseCase, retrieveCompanyUseCase, retrieveDischargeUseCase);
            Command listCommand = new ListCommand(listController);

            //show command
            ShowView showView = new DefaultShowView();
            ShowController showController = new DefaultShowController(showView, retrieveDischargeUseCase);
            Command showCommand = new ShowCommand(showController);

            MainLoop mainLoop = new DefaultMainLoop();
            mainLoop.addCommand(listCommand);
            mainLoop.addCommand(showCommand);

            System.out.println(PROGRAM_GREETINGS);

            mainLoop.run();
        } catch (SQLException exc) {
            logger.error("Unable to connect to MySQL", exc);
        }
    }
}
