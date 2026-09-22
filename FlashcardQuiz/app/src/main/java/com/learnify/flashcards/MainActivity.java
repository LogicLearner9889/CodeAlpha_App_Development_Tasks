package com.learnify.flashcards;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuestion;
    private TextView tvAnswer;
    private TextView tvCounter;
    private TextView tvCardLabel;

    private Button btnShowAnswer;
    private Button btnPrevious;
    private Button btnNext;
    private Button btnAdd;
    private Button btnEdit;
    private Button btnDelete;

    private DatabaseHelper databaseHelper;

    private ArrayList<Flashcard> flashcards;

    private int currentIndex = 0;

    private boolean answerVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);

        initializeViews();

        loadFlashcards();

        setupListeners();
    }

    private void initializeViews() {

        tvQuestion = findViewById(R.id.tvQuestion);
        tvAnswer = findViewById(R.id.tvAnswer);
        tvCounter = findViewById(R.id.tvCounter);
        tvCardLabel = findViewById(R.id.tvCardLabel);

        btnShowAnswer = findViewById(R.id.btnShowAnswer);
        btnPrevious = findViewById(R.id.btnPrevious);
        btnNext = findViewById(R.id.btnNext);
        btnAdd = findViewById(R.id.btnAdd);
        btnEdit = findViewById(R.id.btnEdit);
        btnDelete = findViewById(R.id.btnDelete);
    }

    private void loadFlashcards() {

        flashcards = databaseHelper.getAllFlashcards();

        if (flashcards.size() == 0) {

            currentIndex = 0;

            showEmptyState();

            return;
        }

        if (currentIndex >= flashcards.size()) {
            currentIndex = flashcards.size() - 1;
        }

        showCurrentCard();
    }

    private void showCurrentCard() {

        if (flashcards == null || flashcards.isEmpty()) {

            showEmptyState();

            return;
        }

        Flashcard card = flashcards.get(currentIndex);

        tvQuestion.setText(card.getQuestion());

        tvAnswer.setText(card.getAnswer());

        tvAnswer.setVisibility(
                android.view.View.GONE
        );

        tvQuestion.setVisibility(
                android.view.View.VISIBLE
        );

        tvCardLabel.setText("QUESTION");

        btnShowAnswer.setText("Show Answer");

        answerVisible = false;

        tvCounter.setText(
                "Card " +
                        (currentIndex + 1) +
                        " of " +
                        flashcards.size()
        );

        btnPrevious.setEnabled(currentIndex > 0);

        btnNext.setEnabled(
                currentIndex < flashcards.size() - 1
        );

        btnEdit.setEnabled(true);

        btnDelete.setEnabled(true);
    }

    private void showEmptyState() {

        tvQuestion.setText(
                "No flashcards available"
        );

        tvAnswer.setText("");

        tvAnswer.setVisibility(
                android.view.View.GONE
        );

        tvCardLabel.setText("FLASHCARDS");

        tvCounter.setText("0 cards");

        btnShowAnswer.setEnabled(false);

        btnPrevious.setEnabled(false);

        btnNext.setEnabled(false);

        btnEdit.setEnabled(false);

        btnDelete.setEnabled(false);
    }

    private void setupListeners() {

        btnShowAnswer.setOnClickListener(v -> {

            if (flashcards == null || flashcards.isEmpty()) {
                return;
            }

            if (!answerVisible) {

                tvAnswer.setVisibility(
                        android.view.View.VISIBLE
                );

                tvCardLabel.setText("ANSWER");

                btnShowAnswer.setText("Hide Answer");

                answerVisible = true;

            } else {

                tvAnswer.setVisibility(
                        android.view.View.GONE
                );

                tvCardLabel.setText("QUESTION");

                btnShowAnswer.setText("Show Answer");

                answerVisible = false;
            }
        });

        btnNext.setOnClickListener(v -> {

            if (currentIndex < flashcards.size() - 1) {

                currentIndex++;

                showCurrentCard();
            }
        });

        btnPrevious.setOnClickListener(v -> {

            if (currentIndex > 0) {

                currentIndex--;

                showCurrentCard();
            }
        });

        btnAdd.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity.this,
                    AddEditFlashcardActivity.class
            );

            startActivity(intent);
        });

        btnEdit.setOnClickListener(v -> {

            if (flashcards == null ||
                    flashcards.isEmpty()) {
                return;
            }

            Flashcard card =
                    flashcards.get(currentIndex);

            Intent intent = new Intent(
                    MainActivity.this,
                    AddEditFlashcardActivity.class
            );

            intent.putExtra(
                    "id",
                    card.getId()
            );

            intent.putExtra(
                    "question",
                    card.getQuestion()
            );

            intent.putExtra(
                    "answer",
                    card.getAnswer()
            );

            startActivity(intent);
        });

        btnDelete.setOnClickListener(v -> {

            if (flashcards == null ||
                    flashcards.isEmpty()) {
                return;
            }

            showDeleteConfirmation();
        });
    }

    private void showDeleteConfirmation() {

        new AlertDialog.Builder(this)
                .setTitle("Delete Flashcard")
                .setMessage(
                        "Are you sure you want to delete this flashcard?"
                )
                .setNegativeButton(
                        "Cancel",
                        null
                )
                .setPositiveButton(
                        "Delete",
                        (dialog, which) -> deleteCurrentCard()
                )
                .show();
    }

    private void deleteCurrentCard() {

        Flashcard card =
                flashcards.get(currentIndex);

        int result =
                databaseHelper.deleteFlashcard(
                        card.getId()
                );

        if (result > 0) {

            Toast.makeText(
                    this,
                    "Flashcard deleted",
                    Toast.LENGTH_SHORT
            ).show();

            if (currentIndex > 0 &&
                    currentIndex >= flashcards.size() - 1) {

                currentIndex--;
            }

            loadFlashcards();

        } else {

            Toast.makeText(
                    this,
                    "Unable to delete flashcard",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    @Override
    protected void onResume() {

        super.onResume();

        loadFlashcards();
    }
}