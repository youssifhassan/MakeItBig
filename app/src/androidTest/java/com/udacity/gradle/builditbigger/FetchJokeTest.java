package com.udacity.gradle.builditbigger;

import org.junit.Test;

import static org.junit.Assert.*;


import android.app.Application;
        import android.support.test.runner.AndroidJUnit4;
        import android.test.ApplicationTestCase;

        import org.junit.Test;
        import org.junit.runner.RunWith;

        import java.util.concurrent.CountDownLatch;
        import java.util.concurrent.TimeUnit;



@RunWith(AndroidJUnit4.class)
public class FetchJokeTest extends ApplicationTestCase<Application> {
    private CountDownLatch signal;
    private String joke;

    public FetchJokeTest() {
        super(Application.class);
    }

    @Test
    public void testJoke() {
        try {
            signal = new CountDownLatch(1);
            new FetchJoke() {
                @Override
                protected void onPostExecute(String s) {

                    joke = s;
                    signal.countDown();

                }
            }.execute();
            signal.await(10, TimeUnit.SECONDS);
            assertNotNull("Null joke received!", joke);
            assertFalse("Empty joke received!", joke.isEmpty());
        } catch (Exception e) {
            fail();
        }
    }


}

