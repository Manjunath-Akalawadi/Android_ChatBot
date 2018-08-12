package com.manju7.demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.github.library.bubbleview.BubbleTextView;
import java.util.List;

public class Adapter extends BaseAdapter {

    private List<Chat> chatList;
    private Context context;
    private LayoutInflater layoutInflater;

    public Adapter(List<Chat> chatList, Context context) {
        this.chatList = chatList;
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return chatList.size();
    }

    @Override
    public Object getItem(int position) {
        return chatList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;
         if (view == null){

             if (chatList.get(position).isSend)
                 view = layoutInflater.inflate(R.layout.list_of_messages,null);
             else
                 view = layoutInflater.inflate(R.layout.recive_messages,null);

             BubbleTextView text_message = (BubbleTextView)view.findViewById(R.id.text_message);
             text_message.setText(chatList.get(position).message);


         }
        return view;
    }
}
