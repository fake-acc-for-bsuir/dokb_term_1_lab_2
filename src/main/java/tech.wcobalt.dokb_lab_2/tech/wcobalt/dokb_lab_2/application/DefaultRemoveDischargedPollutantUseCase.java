package tech.wcobalt.dokb_lab_2.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.wcobalt.dokb_lab_2.persistence.DischargedPollutantPlacer;
import tech.wcobalt.dokb_lab_2.persistence.PersistenceException;

public class DefaultRemoveDischargedPollutantUseCase implements RemoveDischargedPollutantUseCase {
    private DischargedPollutantPlacer dischargedPollutantPlacer;

    private static final Logger logger = LogManager.getLogger(DefaultRemoveDischargedPollutantUseCase.class.getName());

    public DefaultRemoveDischargedPollutantUseCase(DischargedPollutantPlacer dischargedPollutantPlacer) {
        this.dischargedPollutantPlacer = dischargedPollutantPlacer;
    }

    @Override
    public void removeDischargedPollutant(int dischargedPollutant) throws ApplicationException {
        try {
            dischargedPollutantPlacer.removeDischargedPollutant(dischargedPollutant);
        } catch (PersistenceException exc) {
            String mes = "Unable to retrieve data from the persistence layer";

            logger.error(mes, exc);

            throw new ApplicationException(mes);
        }
    }
}
