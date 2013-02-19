package com.anjuke.devlib.dns.record;

import java.io.IOException;

import com.anjuke.devlib.dns.DNSInputStream;
import com.anjuke.devlib.dns.DNSRR;

public class MailForwarder extends DNSRR {
	private String mailForwarder;

	protected void decode(DNSInputStream dnsIn) throws IOException {
		mailForwarder = dnsIn.readDomainName();
	}

	public String getMailForwarder() {
		return mailForwarder;
	}

	public String toString() {
		return getRRName() + "\tmail forwarder = " + mailForwarder;
	}
}
