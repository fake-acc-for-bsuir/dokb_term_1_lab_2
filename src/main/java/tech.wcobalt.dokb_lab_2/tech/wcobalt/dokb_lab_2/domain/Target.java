package tech.wcobalt.dokb_lab_2.domain;

public interface Target {
    int getId();

    String getName();

    double getDistance();

    /**this method is not supposed to be used with purpose of change the id field
     * in a persistence storage, it's supposed to change the id field only in context of java*/
    void setId(int id);

    void setName(String name);

    void setDistance(double distance);
}
