package com.anjuke.devlib.dns.record;

import java.io.IOException;

import com.anjuke.devlib.dns.DNSInputStream;
import com.anjuke.devlib.dns.DNSRR;

public class HostInfo extends DNSRR {
	private String cpu, os;

	protected void decode(DNSInputStream dnsIn) throws IOException {
		cpu = dnsIn.readString();
		os = dnsIn.readString();
	}

	public String getCPUInfo() {
		return cpu;
	}

	public String getOSInfo() {
		return os;
	}

	public String toString() {
		return getRRName() + "\tOS = " + os + ", CPU = " + cpu;
	}
}
