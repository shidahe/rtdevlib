package com.anjuke.devlib.utils.http;

import java.io.IOException;
import java.io.InputStream;

public interface PartSource {

	long getLength();

	String getFileName();

	InputStream createInputStream() throws IOException;

}