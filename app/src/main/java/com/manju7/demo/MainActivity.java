package com.manju7.chatbot;

import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText editText;
    List<Chat> list = new ArrayList<>();
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.message_list);
        editText =(EditText) findViewById(R.id.my_message);
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = editText.getText().toString();
                Chat chat = new Chat(string,true);
                list.add(chat);
                 new API().execute(list);

                 editText.setText(" ");
            }
        });
    }

    private class API extends AsyncTask<List<Chat>,Void,String>{

        String string = null;
        List<Chat> chatList;

        String text = editText.getText().toString();

        @Override
        protected String doInBackground(List<Chat>... lists) {

            String url = String.format("http://sandbox.api.simsimi.com/request.p?key=%s&lc=en&ft=1.0&text=%s"
            ,getString(R.string.api),text);

            chatList = lists[0];

            HttpDataHandles httpDataHandles =new HttpDataHandles();
            string = httpDataHandles.GetHttpData(url);

            return string;

        }

        @Override
        protected void onPostExecute(String s) {

            Gson gson  = new Gson();

            Model response = gson.fromJson(s,Model.class);

            Chat chat  = new Chat(response.getResponse(),false);
            chatList.add(chat);
            Adapter adapter = new Adapter(chatList,MainActivity.this);
            listView.setAdapter(adapter);

        }
    }
}
