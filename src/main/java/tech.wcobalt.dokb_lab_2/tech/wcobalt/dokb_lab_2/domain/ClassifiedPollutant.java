package tech.wcobalt.dokb_lab_2.domain;

public interface ClassifiedPollutant {
    int getId();

    int getCompany();

    int getPollutant();

    String getDangerClass();

    String getLfvGroup();

    /**this method is not supposed to be used with purpose of change the id field
     * in a persistence storage, it's supposed to change the id field only in context of java*/
    void setId(int id);

    /**this method is not supposed to be used with purpose of change the company's field
    * in a persistence storage, it's supposed to change the company's only in context of java*/
    void setCompany(int company);

    /**this method is not supposed to be used with purpose of change the pollutant's field
     * in a persistence storage, it's supposed to change the pollutant's field only in context of java*/
    void setPollutant(int pollutant);

    void setDangerClass(String dangerClass);

    void setLfvGroup(String lfvGroup);
}
