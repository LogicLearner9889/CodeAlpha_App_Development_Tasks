package com.learnify.flashcards;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "flashcards.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "flashcards";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_ANSWER = "answer";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_QUESTION + " TEXT NOT NULL, " +
                COLUMN_ANSWER + " TEXT NOT NULL)";

        db.execSQL(createTable);

        insertDefaultCards(db);
    }

    private void insertDefaultCards(SQLiteDatabase db) {

        insertCard(db,
                "What is Java?",
                "Java is a high-level, object-oriented programming language.");

        insertCard(db,
                "What is Android?",
                "Android is a mobile operating system and application platform.");

        insertCard(db,
                "What is SQLite?",
                "SQLite is a lightweight local relational database.");
    }

    private void insertCard(SQLiteDatabase db,
                            String question,
                            String answer) {

        ContentValues values = new ContentValues();

        values.put(COLUMN_QUESTION, question);
        values.put(COLUMN_ANSWER, answer);

        db.insert(TABLE_NAME, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion,
                          int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public ArrayList<Flashcard> getAllFlashcards() {

        ArrayList<Flashcard> flashcards = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABLE_NAME +
                        " ORDER BY " + COLUMN_ID + " ASC",
                null
        );

        if (cursor.moveToFirst()) {

            do {

                int id = cursor.getInt(
                        cursor.getColumnIndexOrThrow(COLUMN_ID)
                );

                String question = cursor.getString(
                        cursor.getColumnIndexOrThrow(COLUMN_QUESTION)
                );

                String answer = cursor.getString(
                        cursor.getColumnIndexOrThrow(COLUMN_ANSWER)
                );

                flashcards.add(
                        new Flashcard(id, question, answer)
                );

            } while (cursor.moveToNext());
        }

        cursor.close();

        return flashcards;
    }

    public long addFlashcard(String question,
                             String answer) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_QUESTION, question);
        values.put(COLUMN_ANSWER, answer);

        return db.insert(TABLE_NAME, null, values);
    }

    public int updateFlashcard(int id,
                               String question,
                               String answer) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(COLUMN_QUESTION, question);
        values.put(COLUMN_ANSWER, answer);

        return db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
    }

    public int deleteFlashcard(int id) {

        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(
                TABLE_NAME,
                COLUMN_ID + " = ?",
                new String[]{String.valueOf(id)}
        );
    }
}