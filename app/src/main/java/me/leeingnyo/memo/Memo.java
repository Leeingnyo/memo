package me.leeingnyo.memo;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Memo implements Parcelable, Serializable {
    private String title;
    private String contents;
    private Date date;

    public Memo(String title, String contents){
        this.title = title;
        this.contents = contents;
    }

    public Memo(String title, String contents, Date date){
        this.title = title;
        this.contents = contents;
        this.date = date;
    }

    protected Memo(Parcel in) {
        title = in.readString();
        contents = in.readString();
        int flag = in.readInt();
        if (flag != 0) {
            date = new Date(in.readLong());
        } else {
            date = null;
        }
    }

    public static final Creator<Memo> CREATOR = new Creator<Memo>() {
        @Override
        public Memo createFromParcel(Parcel in) {
            return new Memo(in);
        }

        @Override
        public Memo[] newArray(int size) {
            return new Memo[size];
        }
    };

    public String getTitle() {
        return title;
    }
    public String getContents() {
        return contents;
    }
    public String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        if (date != null) {
            return sdf.format(date);
        } else {
            return "";
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(contents);
        dest.writeInt(date == null ? 0 : 1);
        if (date != null) {
            dest.writeLong(date.getTime());
        }
    }
}
