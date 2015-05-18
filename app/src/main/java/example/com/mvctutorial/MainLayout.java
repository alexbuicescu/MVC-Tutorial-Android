package example.com.mvctutorial;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import example.com.mvctutorial.interfaces.OnChangeListener;

/**
 * Created by alexandru.buicescu on 15/05/2015.
 */
public class MainLayout extends RelativeLayout implements OnChangeListener<MainModel> {

    private final static String TAG = "MainLayout";
    /**
     * The main model.
     */
    private MainModel rootModel;
    /**
     * The listener.
     */
    private ViewListener viewListener;
    /**
     * The button that changes the credit.
     */
    private Button changeCreditButton;
    /**
     * The credit textview.
     */
    private TextView creditTextView;

    public MainLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        initAll();
    }

    private void initAll() {
        changeCreditButton = (Button) findViewById(R.id.activity_main_change_credit_button);
        changeCreditButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getViewListener().onChangeCreditButtonClicked();
            }
        });

        creditTextView = (TextView) findViewById(R.id.activity_main_credit_textview);
    }

    public MainModel getModel() {
        return rootModel;
    }

    public void setModel(MainModel model) {
        this.rootModel = model;
        this.rootModel.addListener(this);
        updateView();
    }

    public void updateView() {
        creditTextView.setText("" + getModel().getCredit());
    }

    public ViewListener getViewListener() {
        return viewListener;
    }

    public void setViewListener(ViewListener viewListener) {
        this.viewListener = viewListener;
    }

    @Override
    public void onChange() {
        updateView();
    }

    /**
     * The listener interface for receiving view events. The class that is interested in processing a view event
     * implements this interface, and the object created with that class is registered with a component using the
     * component's <code>addViewListener<code> method. When
     * the view event occurs, that object's appropriate
     * method is invoked.
     */
    public interface ViewListener {
        public void onChangeCreditButtonClicked();
    }
}
