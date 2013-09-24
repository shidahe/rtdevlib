package com.anjuke.devlib.network;

public interface SocketClientCallback {
	void onCallback(String msg);
	void onError(String msg);
}
