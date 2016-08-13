package me.leeingnyo.memo;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MemoManager {
    private static MemoManager instance;
    public static MemoManager getInstance(Context context){
        if (instance == null){
            instance = new MemoManager(context);
        }
        return instance;
    }
    private MemoManager(Context context){
        this.context = context;
        memoList = load(context);
    }

    private ArrayList<Memo> memoList;
    private Context context;

    private ArrayList<Memo> load(Context context){
        try {
            FileInputStream fis = context.openFileInput("list");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Memo> memoList = (ArrayList<Memo>)ois.readObject();
            ois.close();
            return memoList;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<Memo>();
    }
    private void save(Context context){
        try {
            FileOutputStream fos = context.openFileOutput("list", Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(memoList);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Memo memo){
        memoList.add(memo);
        save(context);
    }

    public void remove(Memo memo){
        memoList.remove(memo);
        save(context);
    }

    public void listToAdapter(MemoAdapter adapter){
        adapter.setData(memoList);
    }
}
