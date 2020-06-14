package zua.edu.cn.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

public class CrimeLab {
    private static CrimeLab mCrimes;

    public ArrayList<Crime> getCrimesList() {
        return mCrimesList;
    }

    private ArrayList<Crime> mCrimesList;
    private CrimeLab(){
       mCrimesList = new ArrayList<>();
       for(int i=0;i<100;i++){
           mCrimesList.add(new Crime("crime"+i,i%2==0?true:false));
       }
    }
    public static CrimeLab getInstance(){
        if(mCrimes == null)
            mCrimes = new CrimeLab();
        return mCrimes;

    }

    public Crime findCrimeById(UUID id){
        for(Crime c:mCrimesList){
            if(id.equals(c.getID()))
                return c;
        }
        return null;
    }



}
