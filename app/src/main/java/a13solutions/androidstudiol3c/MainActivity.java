package a13solutions.androidstudiol3c;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Controller(this);

    }


    public void setFrameInMainContainer(CustonFragment fragment){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.frame_home, (Fragment) fragment);
        transaction.commit();


    }

    public void setFrameInMainContainer(Fragment fragment, boolean backstack){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_home, fragment);
        if(backstack){
            ft.addToBackStack(null);
        }
        ft.commit();

    }
}
