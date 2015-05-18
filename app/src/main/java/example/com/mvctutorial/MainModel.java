package example.com.mvctutorial;

import example.com.mvctutorial.interfaces.SimpleObservable;

/**
 * Created by alexandru.buicescu on 15/05/2015.
 */
public class MainModel extends SimpleObservable<MainModel> {

    private float credit;

    public float getCredit() {
        return credit;
    }

    public void setCredit(float credit, boolean... isNotificationRequired) {
        this.credit = credit;
        if (isNotificationRequired.length > 0 && isNotificationRequired[0]) notifyObservers();
    }
}
