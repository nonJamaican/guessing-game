package com.example.rachelhutchison.guessinggame;

import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class)
public abstract class RobolectricUnitTests {

    public MyApplication getApplication() {
        return RobolectricUnitTests.getStaticApplication();
    }

    public static MyApplication getStaticApplication() {
        return MyApplication.class.cast(RuntimeEnvironment.application);
    }
}
