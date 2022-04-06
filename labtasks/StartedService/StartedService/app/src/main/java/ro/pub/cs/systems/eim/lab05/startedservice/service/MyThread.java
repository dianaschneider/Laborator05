package ro.pub.cs.systems.eim.lab05.startedservice.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;

public class MyThread extends Thread{

    Context context;

    public MyThread(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            Log.d(Constants.TAG, "Thread.run() was invoked, PID: " + android.os.Process.myPid() + " TID: " + android.os.Process.myTid());
            sendIntents(Constants.ACTION_STRING);
            threadSleep();
            sendIntents(Constants.ACTION_INTEGER);
            threadSleep();
            sendIntents(Constants.ACTION_ARRAY_LIST);
            threadSleep();
        }
    }

    public void threadSleep() {
        try {
            sleep(Constants.SLEEP_TIME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void sendIntents(String action) {
        Intent intent = new Intent();
        intent.setAction(action);
        switch (action) {
            case Constants.ACTION_STRING:
                intent.putExtra(Constants.DATA, Constants.STRING_DATA);
                break;
            case Constants.ACTION_INTEGER:
                intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
                break;
            case Constants.ACTION_ARRAY_LIST:
                intent.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
                break;
        }
        context.sendBroadcast(intent);
    }


}
