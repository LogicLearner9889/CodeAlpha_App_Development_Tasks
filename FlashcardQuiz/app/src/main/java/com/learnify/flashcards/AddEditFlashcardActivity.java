package com.learnify.flashcards;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddEditFlashcardActivity
        extends AppCompatActivity {

    private EditText etQuestion;
    private EditText etAnswer;

    private TextView tvFormTitle;

    private Button btnSave;
    private Button btnCancel;

    private DatabaseHelper databaseHelper;

    private int flashcardId = -1;

    private boolean editMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_add_edit_flashcard
        );

        databaseHelper =
                new DatabaseHelper(this);

        initializeViews();

        checkEditMode();

        setupListeners();
    }

    private void initializeViews() {

        tvFormTitle =
                findViewById(R.id.tvFormTitle);

        etQuestion =
                findViewById(R.id.etQuestion);

        etAnswer =
                findViewById(R.id.etAnswer);

        btnSave =
                findViewById(R.id.btnSave);

        btnCancel =
                findViewById(R.id.btnCancel);
    }

    private void checkEditMode() {

        if (getIntent().hasExtra("id")) {

            editMode = true;

            flashcardId =
                    getIntent().getIntExtra(
                            "id",
                            -1
                    );

            String question =
                    getIntent().getStringExtra(
                            "question"
                    );

            String answer =
                    getIntent().getStringExtra(
                            "answer"
                    );

            tvFormTitle.setText(
                    "Edit Flashcard"
            );

            btnSave.setText(
                    "Update Flashcard"
            );

            etQuestion.setText(question);

            etAnswer.setText(answer);

        } else {

            editMode = false;

            tvFormTitle.setText(
                    "Add Flashcard"
            );

            btnSave.setText(
                    "Save Flashcard"
            );
        }
    }

    private void setupListeners() {

        btnSave.setOnClickListener(v ->
                saveFlashcard()
        );

        btnCancel.setOnClickListener(v ->
                finish()
        );
    }

    private void saveFlashcard() {

        String question =
                etQuestion.getText()
                        .toString()
                        .trim();

        String answer =
                etAnswer.getText()
                        .toString()
                        .trim();

        if (question.isEmpty()) {

            etQuestion.setError(
                    "Enter a question"
            );

            etQuestion.requestFocus();

            return;
        }

        if (answer.isEmpty()) {

            etAnswer.setError(
                    "Enter an answer"
            );

            etAnswer.requestFocus();

            return;
        }

        if (editMode) {

            int result =
                    databaseHelper.updateFlashcard(
                            flashcardId,
                            question,
                            answer
                    );

            if (result > 0) {

                Toast.makeText(
                        this,
                        "Flashcard updated",
                        Toast.LENGTH_SHORT
                ).show();

                finish();

            } else {

                Toast.makeText(
                        this,
                        "Unable to update flashcard",
                        Toast.LENGTH_SHORT
                ).show();
            }

        } else {

            long result =
                    databaseHelper.addFlashcard(
                            question,
                            answer
                    );

            if (result != -1) {

                Toast.makeText(
                        this,
                        "Flashcard added",
                        Toast.LENGTH_SHORT
                ).show();

                finish();

            } else {

                Toast.makeText(
                        this,
                        "Unable to add flashcard",
                        Toast.LENGTH_SHORT
                ).show();
            }
        }
    }
}