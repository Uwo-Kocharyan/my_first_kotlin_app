
package com.example.mykotlinapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import okhttp3.Call
import okhttp3.Callback
import okhttp3.FormBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.Response
import java.io.IOException

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val client: OkHttpClient = OkHttpClient()
        val getUrl = "https://demo.codeseasy.com/apis/okhttp/get.php?key_name=value"
        val postUrl = "https://demo.codeseasy.com/apis/okhttp/post.php"
        val textView: TextView = findViewById(R.id.textData)
        var buttonGet: Button = findViewById(R.id.btnGet)
        var buttonPost: Button = findViewById(R.id.btnPost)




        fun get(){
            val request: Request = Request.Builder().url(getUrl).build()
            client.newCall(request).enqueue(object : Callback
            {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread(
                        fun(){
                            try {
                                textView.setText(response.body?.string())
                            }catch ( e:IOException){
                                e.printStackTrace()
                            }
                        }
                    )
                }
            }
            )
        }
        fun post(){
            val requestBody: FormBody = FormBody.Builder()
                .add(name = "key_name", value = "Demo Value")
                .build()
            val request:Request =Request.Builder().url(postUrl).post(requestBody).build()
            client.newCall(request).enqueue(object : Callback
            {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    runOnUiThread(
                        fun(){
                            try {
                                textView.text = response.body?.string()
                            }catch ( e:IOException){
                                e.printStackTrace()
                            }
                        }
                    )
                }
            }
            )
        }

        buttonGet.setOnClickListener {
            fun onClick(view: View) {
                get()
            }
        }

        buttonPost.setOnClickListener {
            fun onClick(view: View) {
                post()

            }
        }
    }

}










//
//class MainActivity1 : AppCompatActivity() {
//OkHttpClient client;
//    String getURL= "https://demo.codeseasy.com/apis/okhttp/get.php?key_name=value";
//    String postURL="https://demo.codeseasy.com/apis/okhttp/post.php";
//    TextView  textView;
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        client = new OkHttpClient ();
//        textView - findViewById(R.id.textData);
//        Button buttonGet = findViewById (R.id.btnGet);
//        Button buttonPost = findViewById (R.id.btnPost);
//
//        buttonGet.setOnClickListener(new View . OnClickListener (){
//            @Override
//            public void onClick(View view) {
//              get();
//            }
//        }
//        );
//        buttonPost.setOnClickListener(new View . OnClickListener (){
//            @Override
//            public void onClick(View view) {
//              post();
//            }
//        }
//        );
//    }
//    public  void post() {
//        RequestBody requestBody = new FormBody.Builder()
//            .add("key_name","Demo Value").build();
//        Request request = new Request.Builder().url(postURL).post(requestBody).build();
//        client.newCall(request).equeue(new Callback()){
//            @Override
//            public void onFailure(@NonNull Call call,@NonNull IOException e){
//                e.printStackTrace();
//            }
//            @Override
//            public void onResponse(@NonNull Call call,@NonNull Response response)throws IOException{
//                runOnUiThread(new Runnable(){
//                    @Override
//                    public void run(){
//                        try {
//                            textView.setText(response.body().string());
//                        }catch (IOException e){
//                            e.printStackTrace();
//                        }
//                    }
//                });
//            }
//        }
//
//
//    }
//    }