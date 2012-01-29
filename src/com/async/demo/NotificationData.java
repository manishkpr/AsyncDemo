package com.async.demo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class NotificationData {
	 public static NotificationManager mNotificationManager;
	 public static int SIMPLE_NOTFICATION_ID;
	    private Context _context;
		public NotificationData(Context context){
		  _context=context;
		 }
		public void clearNotification(){			
		  mNotificationManager.cancel(SIMPLE_NOTFICATION_ID);
		}
        public void SetNotification(int drawable,String msg,String action_string,Class cls){
    	  mNotificationManager = (NotificationManager)_context.getSystemService(Context.NOTIFICATION_SERVICE);
	      final Notification notifyDetails = new Notification(drawable,"Post Timer",System.currentTimeMillis());
	      long[] vibrate = {100,100,200,300};
          notifyDetails.vibrate = vibrate;
          notifyDetails.ledARGB = 0xff00ff00;
          notifyDetails.ledOnMS = 300;
          notifyDetails.ledOffMS = 1000;
         // notifyDetails.number=4;
          notifyDetails.defaults =Notification.DEFAULT_ALL;
          Context context = _context;
          CharSequence contentTitle = msg;
          CharSequence contentText = action_string;      
          Intent notifyIntent = new Intent(context,  cls);
          PendingIntent intent = PendingIntent.getActivity(_context, 0,notifyIntent, android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
          notifyDetails.setLatestEventInfo(context, contentTitle, contentText, intent);
	      mNotificationManager.notify(SIMPLE_NOTFICATION_ID, notifyDetails);	      
        }
}
