package com.udacity.gradle.androidTest;

import android.support.test.InstrumentationRegistry;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.concurrent.TimeUnit;

/**
 *
 */
@RunWith(JUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void testJokeIsNotEmptyString() throws Exception {
        EndpointsAsyncTask getJokeTask = new EndpointsAsyncTask(InstrumentationRegistry.getTargetContext());
        getJokeTask.execute();
        String joke = getJokeTask.get(30, TimeUnit.SECONDS);
        Assert.assertNotNull(joke);
        Assert.assertTrue(!joke.isEmpty());
        System.out.println(joke);
    }

}