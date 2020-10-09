package tech.wcobalt.dokb_lab_2.ui;

public interface Command {
    boolean isThisIt(String query);

    void run();
}
