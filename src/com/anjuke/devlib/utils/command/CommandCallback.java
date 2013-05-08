package com.anjuke.devlib.utils.command;

public interface CommandCallback {
	void onReadLine(String line);
	void onReadError(String line);
	void onCommandFinish();
}
