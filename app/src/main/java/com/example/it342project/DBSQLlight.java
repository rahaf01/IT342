package com.example.it342project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBSQLlight <pubilc> extends SQLiteOpenHelper {

    //........................................................................
    public static final String NameofDB = "Users.db";

    public DBSQLlight (Context context) {
        super(context, "Users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create Table Usersinfo (email TEXT primary key, password TEXT, CurrentDate Text, CurrentTime Text)");
    }// End of onCreate

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop Table if exists Usersinfo");
    }// End of onUpgrade
    //........................................................................

    public Boolean doesEmailExist(String email) {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usersinfo where email = ?", new String[]{email});

        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }// End of doesUsernameExist
    //........................................................................

    public Boolean doesAccountExist(String email, String password){

        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usersinfo where email = ? and password = ?", new String[] {email,password});

        if(cursor.getCount() > 0 )
            return true;
        else
            return false;
    }// End of isAccountExist
    //........................................................................

    public Boolean insertData(String email, String password, String CurrentDate, String CurrentTime){

        SQLiteDatabase DB = this.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("date", CurrentDate);
        contentValues.put("time", CurrentTime);


        long result = DB.insert("Usersinfo", null, contentValues);

        if(result == -1)
            return false;
        else
            return true;
    } // End of insertData
    //........................................................................

    public Cursor getUsersInfo ()
    {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from Usersinfo", null);
        return cursor;
    } // End of getUserData ()
    //........................................................................

    //Update users email (from view profile page)
    public boolean updateEmail (String email, String newEmail ) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email", newEmail);

        Cursor cursor = DB.rawQuery("Select * from Usersinfo where email = ?", new String[]{email});

        if (cursor.getCount() > 0) {
            int result = DB.update("Usersinfo", contentValues, "email=?", new String[]{email});
            if (result == -1) {
                return false;
            }// End if inner if statement - result == -1
            else {
                return true;
            }// End of else statement - result != -1
        }// End of if statement - cursor > 0
        else {
            return false;
        }// End of else statement - cursor <= 0
    }// End of insertCallerData
    //........................................................................

    //Update users password (from view profile page)
    public boolean updatePassword (String email, String newPassword ) {

        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("password", newPassword);

        Cursor cursor = DB.rawQuery("Select * from Usersinfo where email = ?", new String[]{email});

        if (cursor.getCount() > 0) {
            int result = DB.update("Usersinfo", contentValues, "email=?", new String[]{email});
            if (result == -1) {
                return false;
            }// End if inner if statement - result == -1
            else {
                return true;
            }// End of else statement - result != -1
        }// End of if statement - cursor > 0
        else {
            return false;
        }// End of else statement - cursor <= 0
    }// End of insertCallerData

    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select currentDate from Usersinfo", null);
        return cursor;
    }
    //........................................................................

    //........................................................................
}// End of class
