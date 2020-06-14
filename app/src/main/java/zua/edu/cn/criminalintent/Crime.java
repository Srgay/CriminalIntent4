package zua.edu.cn.criminalintent;

import java.util.Date;
import java.util.UUID;

public class Crime {
    private UUID mID;
    private String mTitle;
    private Date mDate;
    private boolean isSolved;

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public UUID getID() {
        return mID;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDate(Date date) {
        mDate = date;
    }

    public void setSolved(boolean solved) {
        isSolved = solved;
    }

    public Crime(){
        mID = UUID.randomUUID();
        mDate = new Date();
    }

    public Crime(String title, boolean isSolved){
        this();
        this.isSolved = isSolved;
        this.mTitle = title;
    }
}
