package tech.wcobalt.dokb_lab_2;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.logging.log4j.*;
import tech.wcobalt.dokb_lab_2.application.*;
import tech.wcobalt.dokb_lab_2.application.data.DefaultCompanyData;
import tech.wcobalt.dokb_lab_2.application.data.DefaultTargetData;
import tech.wcobalt.dokb_lab_2.domain.DefaultCompany;
import tech.wcobalt.dokb_lab_2.domain.DefaultTarget;
import tech.wcobalt.dokb_lab_2.persistence.*;
import tech.wcobalt.dokb_lab_2.ui.Command;
import tech.wcobalt.dokb_lab_2.ui.DefaultMainLoop;
import tech.wcobalt.dokb_lab_2.ui.MainLoop;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.ListCommand;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters.DefaultListController;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters.DefaultListView;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters.ListController;
import tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters.ListView;

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
                    "list (targets|pollutants|companies|discharges (<company_id>|<since_date> <until_date>))\n" +
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
            PollutantRetriever pollutantRetriever = new DefaultPollutantRetriever(connection);
            RetrievePollutantUseCase retrievePollutantUseCase = new DefaultRetrievePollutantUseCase(pollutantRetriever);

            TargetRetriever targetRetriever = new DefaultTargetRetriever(connection, DefaultTarget::new);
            RetrieveTargetUseCase retrieveTargetUseCase = new DefaultRetrieveTargetUseCase(targetRetriever,
                    DefaultTargetData::new);

            CompanyRetriever companyRetriever = new DefaultCompanyRetriever(connection, DefaultCompany::new);
            RetrieveCompanyUseCase retrieveCompanyUseCase = new DefaultRetrieveCompanyUseCase(companyRetriever,
                    DefaultCompanyData::new);

            DischargeRetriever dischargeRetriever = new DefaultDischargeRetriever(connection);
            RetrieveDischargeUseCase retrieveDischargeUseCase = new DefaultRetrieveDischargeUseCase(dischargeRetriever);

            ListView listView = new DefaultListView();
            ListController listPresenter = new DefaultListController(listView, retrieveTargetUseCase,
                    retrievePollutantUseCase, retrieveCompanyUseCase, retrieveDischargeUseCase);
            Command listCommand = new ListCommand(listPresenter);

            MainLoop mainLoop = new DefaultMainLoop();
            mainLoop.addCommand(listCommand);

            System.out.println(PROGRAM_GREETINGS);

            mainLoop.run();
        } catch (SQLException exc) {
            logger.error("Unable to connect to MySQL", exc);
        }
    }
}
