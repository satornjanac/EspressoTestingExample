package com.arm.satornjanac.esspressotestsexamples;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.hamcrest.Matchers;

public class TearDownTest extends ActivityInstrumentationTestCase2<FormActivity>{

    public TearDownTest(){
        super(FormActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @LargeTest
    public void test_populateForm() {
        Espresso.onView(ViewMatchers.withId(R.id.name)).
                perform(ViewActions.typeText("Aleksandar"));
        Espresso.onView(ViewMatchers.withId(R.id.name)).
                check(ViewAssertions.matches(ViewMatchers.withText("Aleksandar")));
        Espresso.pressBack();
        sleep(1000);

        Espresso.onView(ViewMatchers.withId(R.id.surname)).
                perform(ViewActions.typeText("Marjanovic"), ViewActions.closeSoftKeyboard());
        // we need to close keyboard so that next action won't cause test to fail
        Espresso.onView(ViewMatchers.withId(R.id.surname)).
                check(ViewAssertions.matches(ViewMatchers.withText("Marjanovic")));
        Espresso.onView(ViewMatchers.withId(R.id.name)).
                check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Aleksandar"))));
        sleep(1000);

        Espresso.onView(ViewMatchers.withId(R.id.male)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.male)).
                check(ViewAssertions.matches(ViewMatchers.isChecked()));
        Espresso.onView(ViewMatchers.withId(R.id.female)).
                check(ViewAssertions.matches(ViewMatchers.isNotChecked()));
        sleep(1000);

        Espresso.onView(ViewMatchers.withId(R.id.current_team)).perform(ViewActions.click());
        Espresso.onData(Matchers.allOf(Matchers.is(Matchers.instanceOf(String.class)), Matchers.is
                ("Sony"))).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.current_team)).
                check(ViewAssertions.matches(ViewMatchers.withSpinnerText(Matchers.containsString
                        ("Sony"))));

        Espresso.onView(ViewMatchers.withId(R.id.new_team)).perform(ViewActions.click());
        Espresso.onData(Matchers.allOf(Matchers.is(Matchers.instanceOf(String.class)), Matchers.is
                ("12Rockets"))).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.new_team))
                .check(ViewAssertions.matches(ViewMatchers.withSpinnerText(Matchers.containsString
                        ("12Rockets"))));
        sleep(1000);

        Espresso.onView(ViewMatchers.withId(R.id.technology)).perform(ViewActions.click());
        Espresso.onData(Matchers.allOf(Matchers.is(Matchers.instanceOf(String.class)), Matchers.is
                ("Objectiv-C/iOS"))).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.technology))
                .check(ViewAssertions.matches(ViewMatchers.withSpinnerText(Matchers.containsString
                        ("Objectiv-C/iOS"))));
        sleep(1000);

        Espresso.onView(ViewMatchers.withId(R.id.level)).perform(ViewActions.click());
        Espresso.onData(Matchers.allOf(Matchers.is(Matchers.instanceOf(String.class)), Matchers.is
                ("Ninja"))).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.level))
                .check(ViewAssertions.matches(ViewMatchers.withSpinnerText(Matchers.containsString
                        ("Ninja"))));
        sleep(1000);

        Espresso.onView(ViewMatchers.withId(R.id.submit)).
                perform(ViewActions.scrollTo(), ViewActions.click());
        sleep(1000);

        Espresso.openActionBarOverflowOrOptionsMenu(getActivity());
        sleep(1000);
        Espresso.onView(ViewMatchers.withText("Show requests")).
                perform(ViewActions.click());
        sleep(1000);

        Espresso.pressBack();
        sleep(1000);
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
