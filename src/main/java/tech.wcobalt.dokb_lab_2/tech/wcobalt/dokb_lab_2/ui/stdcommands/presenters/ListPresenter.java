package tech.wcobalt.dokb_lab_2.ui.stdcommands.presenters;

import tech.wcobalt.dokb_lab_2.ui.Presenter;

/*actually it violates SRP and ISP but this is just a lab and i'm so lazy.
* So in a good way this must be split.*/
public interface ListPresenter extends Presenter {
    void listTargets();

    void listPollutants();
}
