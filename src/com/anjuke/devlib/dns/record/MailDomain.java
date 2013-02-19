package com.anjuke.devlib.dns.record;

import java.io.IOException;

import com.anjuke.devlib.dns.DNSInputStream;
import com.anjuke.devlib.dns.DNSRR;

public class MailDomain extends DNSRR {
	private String mailDestination;

	protected void decode(DNSInputStream dnsIn) throws IOException {
		mailDestination = dnsIn.readDomainName();
	}

	public String getMailDestination() {
		return mailDestination;
	}

	public String toString() {
		return getRRName() + "\tmail destination = " + mailDestination;
	}
}
