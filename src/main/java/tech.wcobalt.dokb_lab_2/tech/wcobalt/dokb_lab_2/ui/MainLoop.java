package tech.wcobalt.dokb_lab_2.ui;

public interface MainLoop {
    void run();

    void stop();

    void addCommand(Command command);
}
