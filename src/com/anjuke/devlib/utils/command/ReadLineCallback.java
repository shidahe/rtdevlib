package com.anjuke.devlib.utils.command;

public interface ReadLineCallback {
	void onReadLine(String line);
	void onReadError(String line);
}
