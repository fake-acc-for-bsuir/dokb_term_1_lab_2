package tech.wcobalt.dokb_lab_2.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tech.wcobalt.dokb_lab_2.persistence.DischargePlacer;
import tech.wcobalt.dokb_lab_2.persistence.PersistenceException;

public class DefaultRemoveDischargeUseCase implements RemoveDischargeUseCase {
    private DischargePlacer dischargePlacer;

    private static final Logger logger = LogManager.getLogger(DefaultRemoveCompanyUseCase.class.getName());

    public DefaultRemoveDischargeUseCase(DischargePlacer dischargePlacer) {
        this.dischargePlacer = dischargePlacer;
    }

    @Override
    public void removeDischarge(int discharge) throws ApplicationException {
        try {
            dischargePlacer.removeDischarge(discharge);
        } catch (PersistenceException exc) {
            String mes = "Unable to retrieve data from the persistence layer";

            logger.error(mes, exc);

            throw new ApplicationException(mes);
        }
    }
}
