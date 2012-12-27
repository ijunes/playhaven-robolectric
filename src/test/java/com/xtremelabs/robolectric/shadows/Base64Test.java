package com.xtremelabs.robolectric.shadows;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import android.util.Base64;

import com.xtremelabs.robolectric.WithTestDefaultsRunner;

@RunWith(WithTestDefaultsRunner.class)
public class Base64Test {
	@Ignore("This seems to be crashing for some strange reason. Need to fix.")
	@Test
	public void testEncode() throws Exception {
		// TODO: actually run this thing (fix AndroidManifest.xml)
		String strToEncode = "Hi, I'm a sheep";
		byte[] byteStr = strToEncode.getBytes("UTF8");
		
		assertThat(byteStr, notNullValue());
		
		byte[] encodedByteStr = Base64.encode(byteStr, 0);
		
		assertThat(encodedByteStr, notNullValue());
		
		String encodedStr = new String(encodedByteStr, "UTF8");
		
		assertThat(encodedStr, equalTo("SGksIEknbSBhIHNoZWVw"));
	}
}
