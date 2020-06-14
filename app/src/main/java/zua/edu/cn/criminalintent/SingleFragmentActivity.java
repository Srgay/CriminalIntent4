package zua.edu.cn.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public abstract class SingleFragmentActivity extends AppCompatActivity {



    public abstract Fragment getFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime);
        FragmentManager m = getSupportFragmentManager();
        Fragment f =  m.findFragmentById(R.id.fragment_container);
        if(f == null){

            FragmentTransaction t = m.beginTransaction();
            t.add(R.id.fragment_container,getFragment());
          //
            //
            // t.addToBackStack(null);
            t.commit();
        }




    }
}
