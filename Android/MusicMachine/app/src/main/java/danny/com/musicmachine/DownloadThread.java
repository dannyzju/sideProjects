package danny.com.musicmachine;

import android.os.Looper;
import android.util.Log;

/**
 * Created by Dannyzju on 8/24/16.
 */
public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    public DownloadHandler mHandler;

    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
    }
}
