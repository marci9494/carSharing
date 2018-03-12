package com.wwi16.util;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class XssUtil {
	public static String sanitize(String value){
		if(value != null){
			PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
			return policy.sanitize(value);
		}else{
			return null;
		}
	}

}
