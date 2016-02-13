package com.exemple.bookstore;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.exemple.bookstore.Activities.BookActivity;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
public class BookActivityTest extends ActivityInstrumentationTestCase2<BookActivity> {

    public BookActivityTest() {
        super(BookActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        getActivity();
    }

    @Test
    public void testCheckBookTitle(){
        onView(withId(R.id.book_title)).check(matches(isDisplayed()));
    }
}
