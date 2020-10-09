package tech.wcobalt.dokb_lab_2.persistence;

import tech.wcobalt.dokb_lab_2.domain.Target;

import java.util.List;

public interface TargetRetriever {
    List<Target> loadAllTargets() throws PersistenceException;
}
