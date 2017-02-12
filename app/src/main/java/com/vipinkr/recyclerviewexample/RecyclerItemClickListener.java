package com.vipinkr.recyclerviewexample;

import android.content.Context;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Vipin K R on 24-01-2017.
 */

public class RecyclerItemClickListener extends RecyclerView.SimpleOnItemTouchListener {
    private static final String TAG = "RecyclerItemClickListen";
    private final OnRecyclerClickListener recyclerClickListener;
    private final GestureDetectorCompat gestureDetectorCompat;

    interface OnRecyclerClickListener{

        public void onClick(View view, int position);
        public void onLongClick(View view, int position);
    }


    public RecyclerItemClickListener(Context context, final RecyclerView rv, final OnRecyclerClickListener recyclerClickListener) {
        this.recyclerClickListener = recyclerClickListener;

       gestureDetectorCompat=new GestureDetectorCompat(context,new GestureDetector.SimpleOnGestureListener(){


           @Override
           public boolean onSingleTapUp(MotionEvent e) {
               Log.d(TAG, "onSingleTapUp: starts");
               View childView=rv.findChildViewUnder(e.getX(),e.getY());
               //returns relativelayout of card_view layout
               Log.d(TAG, "onSingleTapUp: childview:"+childView.getId());
               Log.d(TAG, "onSingleTapUp: main card:"+R.id.mainCard);
               if(childView!=null&&recyclerClickListener!=null){
                   recyclerClickListener.onClick(childView,rv.getChildAdapterPosition(childView));
               }
               return true;
           }

        //not declared as boolean bcoz if it returns true then other events will be blocked
           @Override
           public void onLongPress(MotionEvent e) {
               Log.d(TAG, "onLongPress: starts");
               View childView=rv.findChildViewUnder(e.getX(),e.getY());
               Log.d(TAG, "onLongPress: childview:"+childView.getId());
               if(childView!=null&&recyclerClickListener!=null){
                   recyclerClickListener.onLongClick(childView,rv.getChildAdapterPosition(childView));
               }
           }
       });
    }


   /*
   returns true if event is handled by the programmer
   else returns false so that system can handle it.
    */
    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        Log.d(TAG, "onInterceptTouchEvent: starts");
        if(gestureDetectorCompat!=null){
            boolean result=gestureDetectorCompat.onTouchEvent(e);
            Log.d(TAG, "onInterceptTouchEvent: returns :"+result);
            return result;
        }
        else{
            Log.d(TAG, "onInterceptTouchEvent: returns :"+false);
            return false;
        }

    }
}
