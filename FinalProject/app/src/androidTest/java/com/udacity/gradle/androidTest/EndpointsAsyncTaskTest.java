package com.udacity.gradle.androidTest;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;

import com.example.androidjokelibrary.JokeDisplayIntent;
import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@RunWith(JUnit4.class)
public class EndpointsAsyncTaskTest {

    @Before
    public void checkThatActivityIsStarted() throws Exception {
        Instrumentation.ActivityMonitor am = InstrumentationRegistry.getInstrumentation().addMonitor(JokeDisplayIntent.class.getName(), null, true);
        am.waitForActivityWithTimeout(10);
        //Assert.assertEquals(1, am.getHits());
    }

    @Test
    public void testJokeIsNotEmptyString() throws Exception {
        EndpointsAsyncTask getJokeTask = new EndpointsAsyncTask(InstrumentationRegistry.getContext());
        getJokeTask.execute();
        String joke = getJokeTask.get(30, TimeUnit.SECONDS);
        Assert.assertNotNull(joke);
    }

}