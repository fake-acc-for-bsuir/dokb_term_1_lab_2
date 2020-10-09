package tech.wcobalt.dokb_lab_2.application;

import tech.wcobalt.dokb_lab_2.application.data.TargetData;

import java.util.List;

public interface RetrieveTargetUseCase {
    List<TargetData> retrieveAllTargets() throws ApplicationException;
}
