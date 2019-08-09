package uz.nursoft.nurbek.makhmudov.kurs.bestblogtest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

/**
 * Created by Nurbek Makhmudov on 31.07.2019
 */

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "best_blog.db";
    public static final int DB_VERSION = 1;

    public static final String tabUserData = "tabUserData";

    public static final String colId = "colId";
    public static final String colUserName = "colUserName";
    public static final String colPass = "colPass";

    private static DbHelper instance;

    public static DbHelper getInstance(Context context) {
        if (instance == null) instance = new DbHelper(context);
        return instance;
    }

    public DbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + tabUserData + "(" +
                colId + " integer primary key, " +
                colUserName + " text, " +
                colPass + " text " +
                ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion > newVersion)
            db.execSQL(" drop table if exists " + tabUserData);

        onCreate(db);
    }

    /*************************************************************************************************************
     * insert user data
     */
    public boolean insertUserData(int id, String userName, String pass) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        try {
            cv.put(colId, id);
            cv.put(colUserName, userName);
            cv.put(colPass, pass);

            database.insert(tabUserData, null, cv);
            database.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(database, null);
        }
    }

    /*************************************************************************************************************
     *  Get User Data
     */
    public String[] getUserData() {
        String data[] = new String[3];
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from " + tabUserData, null);
        try {
            if (cursor.moveToFirst()) {
                do {
                    data[0] = cursor.getString(cursor.getColumnIndex(colId));
                    data[1] = cursor.getString(cursor.getColumnIndex(colUserName));
                    data[2] = cursor.getString(cursor.getColumnIndex(colPass));

                } while (cursor.moveToNext());

                cursor.close();
                database.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(database, cursor);
        }
        return data;
    }

    public boolean deleteUserData(){
        SQLiteDatabase database = this.getWritableDatabase();
        try {
            database.delete(tabUserData, null, null);
            database.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(database, null);
        }
    }

    private void closeAll(SQLiteDatabase db, Cursor cursor) {
        if (cursor != null)
            if (!cursor.isClosed())
                cursor.close();

        if (db.isOpen())
            db.close();
    }


}
