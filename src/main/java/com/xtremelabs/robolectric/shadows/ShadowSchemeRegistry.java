package com.xtremelabs.robolectric.shadows;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;

import com.xtremelabs.robolectric.internal.Implementation;
import com.xtremelabs.robolectric.internal.Implements;

@Implements(SchemeRegistry.class)
public class ShadowSchemeRegistry {
	
	@Implementation
	public final synchronized Scheme get(String name) {
		
		System.out.println("Do we have a scheme for: " + name);
		if (name.equals("http")    ||
			name.equals("market")  ||
			name.equals("https")   ||
			name.equals("ftp")) {
			return new Scheme(name, null, 80);
		}
		
		return null;
	}
}
