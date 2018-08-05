package com.mytaxi.android_demo;

        import org.junit.Rule;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import android.support.test.espresso.ViewInteraction;
        import android.support.test.espresso.matcher.RootMatchers;
        import android.support.test.rule.ActivityTestRule;
        import android.support.test.runner.AndroidJUnit4;
        import static android.support.test.espresso.Espresso.onView;
        import static android.support.test.espresso.action.ViewActions.click;
        import static android.support.test.espresso.action.ViewActions.typeText;
        import static android.support.test.espresso.matcher.ViewMatchers.withId;
        import static android.support.test.espresso.matcher.ViewMatchers.withText;
        import com.mytaxi.android_demo.activities.MainActivity;

@RunWith(AndroidJUnit4.class)
public class searchDriver {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    //Test to search driver with name Sarah Scott and click on call button
    @Test
    public void searchAndCallDriver() throws InterruptedException {

        //Login into MyTaxi app
        onView(withId(R.id.edt_username)).perform(typeText("crazydog335"));
        onView(withId(R.id.edt_password)).perform(typeText("venture"));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(2000);

        //Perform search for driver Sarah Scott
        onView(withId(R.id.textSearch)).perform(typeText("sa"));
        ViewInteraction driver_name=  onView(withText("Sarah Scott")).inRoot(RootMatchers.isPlatformPopup());
        driver_name.perform(click());

        //Click on call button
        onView(withId(R.id.fab)).perform(click());
    }
}
