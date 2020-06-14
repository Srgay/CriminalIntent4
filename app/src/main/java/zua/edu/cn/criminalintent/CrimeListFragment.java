package zua.edu.cn.criminalintent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;

public class CrimeListFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private ArrayList<Crime> mCrimes;
    private CrimeAdapter mAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCrimes = CrimeLab.getInstance().getCrimesList();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_crime_list,container,false);
        mRecyclerView = v.findViewById(R.id.recyclerview);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);

        mAdapter = new CrimeAdapter();
        mRecyclerView.setAdapter(mAdapter);

        return v;
    }
   private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder> {

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View v = LayoutInflater.from(getActivity()).inflate(R.layout.item_crime,viewGroup,false);
            CrimeHolder holder = new CrimeHolder(v);

            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder crimeHolder, int i) {
            Crime c = mCrimes.get(i);
            crimeHolder.bind(c);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }


    }
    private class CrimeHolder extends RecyclerView.ViewHolder  {

        private TextView mTextViewTitle;
        private TextView mTextViewDate;
        private Crime mCrime;

        public CrimeHolder(View v){
            super(v);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = CrimeActivity.getIntent(getActivity(),mCrime.getID());
                    startActivity(intent);
                }
            });
            mTextViewTitle = v.findViewById(R.id.item_textview_title);
            mTextViewDate = v.findViewById(R.id.item_textview_date);
        }

        public void bind(Crime c){
            mCrime = c;
            mTextViewTitle.setText(c.getTitle());
            mTextViewDate.setText(c.getDate().toString());
        }
    }


    @Override
    public void onResume() {
        super.onResume();
        if(mAdapter == null){
            mAdapter = new CrimeAdapter();
            mRecyclerView.setAdapter(mAdapter);
        }
        else{
            mAdapter.notifyDataSetChanged();
        }


    }
}



