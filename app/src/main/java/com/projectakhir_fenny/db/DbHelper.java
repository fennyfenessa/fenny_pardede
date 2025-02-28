package com.projectakhir_fenny.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import .projectakhir.model.Masyarakat;

import com.projectakhir_fenny.model.Masyarakat;

import java.security.Key;
import java.util.ArrayList;

public class DbHelper extends SQLiteOpenHelper {
    public static String DATABASE_NAME = "dbmasyarakat";
    private static final int DATABASE_VERSI0N = 1;
    private static final String TABLE_STD = "masyarakat";
    private static final String KEY_ID = "id";
    private static final String KEY_NIK = "nik";
    private static final String KEY_NAMA = "nama";

    private static final String CREATE_TABLE_MASYARAKAT = "CREATE TABLE "
            + TABLE_STD + "(" + KEY_ID + ” Integer PRIMARY Key AUTOINCREMENT," +
            KEY_NIK + "TEXT, ” + KEY_NAMA + ” TEXT );";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSI0N);
    }

        @Override
        public void onCreate(SQLiteDatabase db) { // Perintah DDL untuk Create Tabel

            db.execSQL(CREATE_TABLE_MASYARAKAT);
        }

            @Override
            public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { // Perindah
        //DDL untuk Upgrade Tabel, dalam hal ini menghapus Tabel
                db.execSQL("DROP TABLE IF EXISTS '" + TABLE_STD + "'");
                onCreate(db);
            }

                public long addUserDetail(String nik, String nama) {
                    SQLiteDatabase db = this.getWritableDatabase();

                    ContentValues values —new ContentValues();
                    values.put(KEY_NIK, nik);
                    values.put(KEY_NAMA, nama);
                    long insert = db.insert(TABLE_STD, null, values);

                    return insert;
                }

                @SuppressLint("Range")
                public ArrayList<Masyarakat> getAllUsers() {
                    ArrayList<Masyarakat> userModelArrayList = new ArrayList<Masyarakat>();

                    String selectQuery = "SELECT * FROM ” + TABLE_STD;
                    SQLiteDatabase db = this,getReadab1eDatabase();
                    Cursor c = db.rawQuery(selectQuery, null);

                    if (c.moveToFirst()) {
                       do{

                        Masyarakat std = new Masyarakat();
                        std.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                        std.setNik(c.getString(c.getColumnIndex(KEY_NIK));
                        std.setNama(c.getString(c.getColumnIndex(KEY_NAMA)));
                        // menambahkan ke List Masyarakat
                        userModelArrayList.add(std);
                    } while (c.moveToFirst());
                    }

                    return userModelArrayList;
                }

                    public void deleteUser(int id) {
                        SQLiteDatabase db = this.getWritableDatabase();
                        db.delete(TABLE_STD, KEY_ID + " = ?",
                                new String[](String.valueOf(id)});
                }

                    public int updateUser(int id, String nik, String nama) {
                     SQLiteDatabase db = this.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(KEY_NIK, nik);
                    values.put(KEY_NAMA, nama);

                    return db.update(TABLE_STD,values, KEY_ID + " = ?”, " +
                         new String[](String.valueOf(id)});
        }
}
