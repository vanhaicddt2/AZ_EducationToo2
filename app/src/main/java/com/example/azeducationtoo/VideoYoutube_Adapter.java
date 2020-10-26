package com.example.azeducationtoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class VideoYoutube_Adapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<VideoYoutube> videoYoutubeList;

    public VideoYoutube_Adapter(Context context, int layout, List<VideoYoutube> videoYoutubeList) {
        this.context = context;
        this.layout = layout;
        this.videoYoutubeList = videoYoutubeList;
    }

    @Override
    public int getCount() {
        return videoYoutubeList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder{
        ImageView imgThumbnail;
        TextView txtTitle;
        TextView txtId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder.txtTitle = (TextView) convertView.findViewById(R.id.textView_YoutubeList_Title);
            holder.imgThumbnail = (ImageView) convertView.findViewById(R.id.imgv_YoutubeList_Thumbnail);
            holder.txtId = (TextView) convertView.findViewById(R.id.textView_YoutubeLID);
            convertView.setTag(holder);
        }else{
                holder = (ViewHolder) convertView.getTag();
            }

         VideoYoutube video = videoYoutubeList.get(position);
         holder.txtTitle.setText(video.getTitle());
         Picasso.with(context).load(video.getThumbnail()).into(holder.imgThumbnail);
         holder.txtId.setText(video.getPicture());

        return convertView;
    }
}
