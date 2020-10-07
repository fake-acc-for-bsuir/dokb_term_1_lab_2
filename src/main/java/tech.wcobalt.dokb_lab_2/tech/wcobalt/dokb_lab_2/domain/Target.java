package tech.wcobalt.dokb_lab_2.domain;

public interface Target {
    int getId();

    String getName();

    double getDistance();

    void setId(int id);

    void setName(String name);

    void setDistance(double distance);
}
