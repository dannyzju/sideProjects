package danny.com.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Dannyzju on 8/24/16.
 */
public class DownloadService extends Service {
    private static final String TAG = DownloadThread.class.getSimpleName();
    private DownloadHandler mHandler;

    @Override
    public void onCreate() {
        DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();
        while (thread.mHandler == null) {
            //Wait until the mHandler is created.
        }
        mHandler = thread.mHandler;
        mHandler.setService(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        Message message = Message.obtain();
        message.obj = song;
        message.arg1 = startId;
        mHandler.sendMessage(message);
        return Service.START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void downloadSong(String song) {
        long endTime = System.currentTimeMillis() + 10 * 1000;
        while (System.currentTimeMillis() < endTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + " downloaded!");
    }
}
