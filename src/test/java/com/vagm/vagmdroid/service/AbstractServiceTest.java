/**
 * 
 */
package com.vagm.vagmdroid.service;

import static org.mockito.Mockito.RETURNS_DEEP_STUBS;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import roboguice.RoboGuice;
import roboguice.activity.RoboActivity;
import android.app.Application;
import android.content.Context;

/**
 * The Class AbstractServiceTest.
 * @author roman_konovalov
 */
@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner.class)
public class AbstractServiceTest {

	/**
	 * application.
	 */
	protected Application application = mock(Application.class, RETURNS_DEEP_STUBS);
	
	/**
	 * context.
	 */
	protected Context context = mock(RoboActivity.class, RETURNS_DEEP_STUBS);

	/**
	 * setup.
	 */
	@Before
	public void setup() {
		RoboGuice.setBaseApplicationInjector(application, RoboGuice.DEFAULT_STAGE);
		when(context.getApplicationContext()).thenReturn(application);
		when(application.getApplicationContext()).thenReturn(application);
	}

	/**
	 * teardown.
	 */
	@After
	public void teardown() {
		RoboGuice.util.reset();
	}

}
