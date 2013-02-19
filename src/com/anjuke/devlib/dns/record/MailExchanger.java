package com.anjuke.devlib.dns.record;

import java.io.IOException;

import com.anjuke.devlib.dns.DNSInputStream;
import com.anjuke.devlib.dns.DNSRR;

public class MailExchanger extends DNSRR {
	private int preference;
	private String mx;

	protected void decode(DNSInputStream dnsIn) throws IOException {
		preference = dnsIn.readShort();
		mx = dnsIn.readDomainName();
	}

	public String getMX() {
		return mx;
	}

	public int getPreference() {
		return preference;
	}

	public String toString() {
		return getRRName() + "\tpreference = " + preference + ", mail exchanger = " + mx;
	}
}
