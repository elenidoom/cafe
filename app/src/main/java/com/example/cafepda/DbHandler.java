package com.example.cafepda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Η κλάση αυτή διαχειρείζεται τη βάση δεδομένων της εφαρμογής
 * για την αποθήκευση των δεδομένων των σερβιτόρων.
 */
public class DbHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "waiters.db";
    public static final String TABLE_WAITERS = "waiters";
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String PASSWORD ="password";

    public DbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_WAITERS_TABLE = "CREATE TABLE " + TABLE_WAITERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + PASSWORD + " INTEGER" + ")";
        db.execSQL(CREATE_WAITERS_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WAITERS);
        onCreate(db);

    }

    /**
     * Ποσθήκη ενός σερβιτόρου στη βάσηη δεδομένων
     * @param name το όνομα του σερβιτόρου
     * @param password ο κωδικός του ερβιτόρου που θα χρησιμοποιηθεί για να συνδεθεί.
     */
    public void addWaiter(String name ,int password){
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name);
        values.put(PASSWORD, password);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_WAITERS, null, values);
        db.close();
    }

    /**
     * Εύρεη σερβιτόρου στη βάση μέσω του κωδικού του
     * @return το όνομα του εκάστοτε σερβιτόρου
     */
    public String findWaiter(int password){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_WAITERS + " WHERE " + PASSWORD + " = " + password;
        Cursor cursor = db.rawQuery(query, null);
        String name = null;
        if (cursor.moveToFirst()) {
            name = cursor.getString(1);
        }
        else{
            name = "not found";
        }
        db.close();
        return name;
    }

    /**
     *Ελέγχει εαν το δοσμένο name υπάρχει στη βάση.
     */
    public boolean userNameExists(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT 1 FROM " + TABLE_WAITERS + " WHERE " + KEY_NAME + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{name});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        db.close();
        return exists;
    }
}
