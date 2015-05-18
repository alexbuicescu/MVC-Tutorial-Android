package example.com.mvctutorial;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


/**
 * Created by alexandru.buicescu on 15/05/2015.
 */
public class MainActivity extends Activity {

    public static final String TAG = "MainActivity";

    private MainLayout rootLayout;
    private MainModel rootModel;
    private MainLayout.ViewListener viewListener = new MainLayout.ViewListener() {
        @Override
        public void onChangeCreditButtonClicked() {
            rootModel.setCredit(rootModel.getCredit() + 1, true);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initLayout();
        initModel();
        setContentView(rootLayout);
        rootLayout.setModel(rootModel);
    }

    private void initLayout()
    {
        rootLayout = (MainLayout) View.inflate(this, R.layout.activity_main, null);
        rootLayout.setViewListener(viewListener);
    }

    private void initModel()
    {
        rootModel = new MainModel();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
