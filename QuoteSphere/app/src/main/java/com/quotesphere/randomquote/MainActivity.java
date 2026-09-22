package com.quotesphere.randomquote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView tvQuote;
    private TextView tvAuthor;
    private Button btnNewQuote;

    private final List<Quote> quoteList = new ArrayList<>();

    private final Random random = new Random();

    private int currentQuoteIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initializeViews();

        loadQuotes();

        showRandomQuote();

        setupListeners();
    }

    private void initializeViews() {

        tvQuote = findViewById(R.id.tvQuote);

        tvAuthor = findViewById(R.id.tvAuthor);

        btnNewQuote = findViewById(R.id.btnNewQuote);
    }

    private void loadQuotes() {

        quoteList.clear();

        quoteList.add(
                new Quote(
                        "Knowledge is power.",
                        "Francis Bacon"
                )
        );

        quoteList.add(
                new Quote(
                        "Well begun is half done.",
                        "Aristotle"
                )
        );

        quoteList.add(
                new Quote(
                        "The journey of a thousand miles begins with one step.",
                        "Lao Tzu"
                )
        );

        quoteList.add(
                new Quote(
                        "Time is money.",
                        "Benjamin Franklin"
                )
        );

        quoteList.add(
                new Quote(
                        "Action is the foundational key to all success.",
                        "Pablo Picasso"
                )
        );

        quoteList.add(
                new Quote(
                        "What we think, we become.",
                        "Buddha"
                )
        );

        quoteList.add(
                new Quote(
                        "Success is not final; failure is not fatal.",
                        "Winston Churchill"
                )
        );

        quoteList.add(
                new Quote(
                        "The secret of getting ahead is getting started.",
                        "Mark Twain"
                )
        );

        quoteList.add(
                new Quote(
                        "Do what you can, with what you have, where you are.",
                        "Theodore Roosevelt"
                )
        );

        quoteList.add(
                new Quote(
                        "It is never too late to be what you might have been.",
                        "George Eliot"
                )
        );

        quoteList.add(
                new Quote(
                        "Believe you can and you're halfway there.",
                        "Theodore Roosevelt"
                )
        );

        quoteList.add(
                new Quote(
                        "If you want to lift yourself up, lift up someone else.",
                        "Booker T. Washington"
                )
        );

        quoteList.add(
                new Quote(
                        "The future depends on what you do today.",
                        "Mahatma Gandhi"
                )
        );

        quoteList.add(
                new Quote(
                        "Everything you can imagine is real.",
                        "Pablo Picasso"
                )
        );

        quoteList.add(
                new Quote(
                        "Turn your wounds into wisdom.",
                        "Oprah Winfrey"
                )
        );

        quoteList.add(
                new Quote(
                        "The best way out is always through.",
                        "Robert Frost"
                )
        );

        quoteList.add(
                new Quote(
                        "Start where you are. Use what you have. Do what you can.",
                        "Arthur Ashe"
                )
        );

        quoteList.add(
                new Quote(
                        "Dream big and dare to fail.",
                        "Norman Vaughan"
                )
        );

        quoteList.add(
                new Quote(
                        "A person who never made a mistake never tried anything new.",
                        "Albert Einstein"
                )
        );

        quoteList.add(
                new Quote(
                        "The only impossible journey is the one you never begin.",
                        "Tony Robbins"
                )
        );
    }

    private void showRandomQuote() {

        if (quoteList.isEmpty()) {

            tvQuote.setText(
                    "No quotes available."
            );

            tvAuthor.setText("");

            return;
        }

        int newIndex;

        if (quoteList.size() == 1) {

            newIndex = 0;

        } else {

            do {

                newIndex = random.nextInt(
                        quoteList.size()
                );

            } while (newIndex == currentQuoteIndex);
        }

        currentQuoteIndex = newIndex;

        Quote selectedQuote =
                quoteList.get(currentQuoteIndex);

        displayQuote(selectedQuote);
    }

    private void displayQuote(Quote quote) {

        tvQuote.setText(
                "\"" + quote.getText() + "\""
        );

        tvAuthor.setText(
                "— " + quote.getAuthor()
        );

        animateQuote();
    }

    private void animateQuote() {

        tvQuote.setAlpha(0f);

        tvAuthor.setAlpha(0f);

        tvQuote.animate()
                .alpha(1f)
                .setDuration(350)
                .start();

        tvAuthor.animate()
                .alpha(1f)
                .setDuration(450)
                .start();
    }

    private void setupListeners() {

        btnNewQuote.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        showRandomQuote();

                        Toast.makeText(
                                MainActivity.this,
                                "New quote",
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );
    }
}