package com.programming.android.sdu.gesturedetectionexercise2

import android.content.Context
import android.support.test.InstrumentationRegistry
import org.junit.Assert
import org.junit.Test

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext: Context = InstrumentationRegistry.getTargetContext()
        Assert.assertEquals("com.programming.android.sdu.gesturedetectionexercise2", appContext.packageName)
    }
}