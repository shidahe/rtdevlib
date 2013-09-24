package com.anjuke.devlib.dns.record;

import java.io.IOException;

import com.anjuke.devlib.dns.DNSInputStream;
import com.anjuke.devlib.dns.DNSRR;

public class MailGroup extends DNSRR {
	private String mailGroup;

	protected void decode(DNSInputStream dnsIn) throws IOException {
		mailGroup = dnsIn.readDomainName();
	}

	public String getMailGroup() {
		return mailGroup;
	}

	public String toString() {
		return getRRName() + "\tmail group = " + mailGroup;
	}
}
