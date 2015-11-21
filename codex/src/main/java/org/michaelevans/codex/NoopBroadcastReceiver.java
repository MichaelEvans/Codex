package org.michaelevans.codex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class NoopBroadcastReceiver extends BroadcastReceiver {

  @Override public void onReceive(Context context, Intent intent) {
    //No-op!
  }
}
