package com.exemple.bookstore;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;
import android.widget.EditText;

import com.exemple.bookstore.Activities.MainActivity;

import org.junit.Before;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.swipeUp;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@LargeTest
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        getActivity();
    }

    @Test
    public void testScrollActivity(){
        onView(withId(R.id.activityMainScrollview)).check(matches(isDisplayed()));
        onView(withId(R.id.activityMainScrollview)).perform(swipeUp());
    }

    @Test
    public void testBookRecycler(){
        onView(withId(R.id.book_recycler)).check(matches(isDisplayed()));
        onView(withId(R.id.book_recycler)).perform(swipeLeft());
        onView(withId(R.id.book_recycler)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }

    @Test
    public void testCommentsIsDisplayed(){
        //onView(withText(R.string.comments)).check(matches(isDisplayed()));
    }

    @Test
    public void testSearchFalseBooks() throws InterruptedException {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("test"), pressKey(66));
        Thread.sleep(1500);
        onView(withText(R.string.emptyBooks)).check(matches(isDisplayed()));
    }

    @Test
    public void testSearchRealBooks() throws InterruptedException {
        onView(withId(R.id.action_search)).perform(click());
        onView(isAssignableFrom(EditText.class)).perform(typeText("halo"), pressKey(66));
        Thread.sleep(1500);
        onView(withText(R.string.emptyBooks)).check(matches(not(isDisplayed())));
    }
}
