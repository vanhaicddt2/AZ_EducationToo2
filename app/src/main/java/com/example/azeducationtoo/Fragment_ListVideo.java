package com.example.azeducationtoo;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Fragment_ListVideo extends Fragment {

    private Handler mHandler = new Handler();
  //  DatabaseReference reference;

    public static String getvideocode;
    DatabaseReference mData;     // tạo database
    String urlGetJson;

    public String ID_PLAYLIST;
    // String ID_PLAYLIST = "cIogWoWfD3w";
    String  Idvideolist,Textstage;
    String[] takelistsentlinkvideo;

    //-- tạo list video youtube --
    ListView lvvideo;
    ArrayList<VideoYoutube> arrayvideo;
    VideoYoutube_Adapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_listvideo,container,false);

        Bundle bundle = getArguments();

        if (bundle != null) {
            Toast.makeText(getActivity(), ""+ bundle.getString("code1"), Toast.LENGTH_SHORT).show();
        }

        lvvideo = (ListView) view.findViewById(R.id.listview_fragment);

        arrayvideo = new ArrayList<>();
        adapter = new VideoYoutube_Adapter(getActivity(),R.layout.row_video_youtube,arrayvideo);
        lvvideo.setAdapter(adapter);

        // database Firebase
        mData = FirebaseDatabase.getInstance().getReference();

        view.findViewById(R.id.progressBar_Listvideo).setVisibility(View.GONE);   // set progresBar khi load video

        //MainActivity.reference = FirebaseDatabase.getInstance().getReference().child("Hoctap").child("Azuman").child("Basic").child(""+bundle.getString("code1"));  // link để vào
        MainActivity.reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                arrayvideo.clear();
                for (DataSnapshot snapshot1 : snapshot.getChildren()){   // đọc tuần tự các mục trong fire base
                    //arrayvideo.add(snapshot1.getValue().toString());
                    ID_PLAYLIST = snapshot1.getValue().toString();

                    urlGetJson = "https://www.googleapis.com/youtube/v3/videos?id="+ ID_PLAYLIST + "&key="+MainActivity.API_KEY+"&part=snippet,statistics&fields=items(id,snippet,statistics)";
                    Idvideolist = ID_PLAYLIST;

                    GetJSonYoutube(urlGetJson,Idvideolist);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        lvvideo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getvideocode = arrayvideo.get(position).getIdvideo();

                Intent intent = new Intent(getActivity(),Phay_video.class);
                intent.putExtra("codevideo2",(Serializable) getvideocode); // gửi dữ liệu về bên Play video
                startActivity(intent);
            }
        });

        return view;
    }


    // lấy JSON từ ID Youtube
    private void GetJSonYoutube(String url, final String ID_list){
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray jsonItems = response.getJSONArray("items");

                            String title = ""; String url = ""; String mota ="";

                            // lấy tiêu đề
                            JSONObject jsonItem = jsonItems.getJSONObject(0);
                            JSONObject jsonSnippet = jsonItem.getJSONObject("snippet") ;
                            title = jsonSnippet.getString("title");
                            mota = jsonSnippet.getString("description");


                            // lấy hình ảnh
                            JSONObject jsonThumbnail = jsonSnippet.getJSONObject("thumbnails");
                            JSONObject jsonmedium = jsonThumbnail.getJSONObject("medium");
                            url = jsonmedium.getString("url");

                            //arrayvideo.add(new VideoYoutube(title,url,ID_list));
                            arrayvideo.add(new VideoYoutube(title,url,mota,ID_list));
                            adapter.notifyDataSetChanged();

                        }

                        catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        requestQueue.add(jsonObjectRequest);

    }
}
