package zua.edu.cn.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {

    private static String CrimeID = "CrimeID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        UUID id = (UUID)getIntent().getSerializableExtra("CrimeID");
        Crime c = CrimeLab.getInstance().findCrimeById(id);
        Log.d("CrimeActivity",c.getTitle());

    }

    @Override
    public Fragment getFragment() {
        UUID id = (UUID)getIntent().getSerializableExtra("CrimeID");
        return CrimeFragment.newCrimeFragment(id);
    }

    public static Intent getIntent(Context c,UUID id){
        Intent intent = new Intent(c, CrimeActivity.class);
        intent.putExtra(CrimeID,id);
        return intent;
    }
}
