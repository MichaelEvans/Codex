package org.michaelevans.dexter;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.test.InstrumentationTestCase;
import java.util.List;
import org.michaelevans.codex.NoopBroadcastReceiver;

public class ApplicationTest extends InstrumentationTestCase {

  public void testReceiverRegistered() throws Exception {
    Intent intent = new Intent(Intent.ACTION_MY_PACKAGE_REPLACED);

    Context context = getInstrumentation().getTargetContext();

    List<ResolveInfo> list = context.getPackageManager().queryBroadcastReceivers(intent, 0);

    boolean receiverRegistered = false;

    for (ResolveInfo resolveInfo : list) {
      if (resolveInfo.activityInfo.name.equals(NoopBroadcastReceiver.class.getName())) {
        receiverRegistered = true;
        break;
      }
    }

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      assertFalse(receiverRegistered);
    } else {
      assertTrue(receiverRegistered);
    }
  }
}

