package tech.wcobalt.dokb_lab_2.domain;

public interface ClassifiedPollutant {
    int getId();

    int getCompany();

    int getPollutant();

    String getDangerClass();

    String getLfvGroup();

    void setId(int id);

    void setCompany(int company);

    void setPollutant(int pollutant);

    void setDangerClass(String dangerClass);

    void setLfvGroup(String lfvGroup);
}
