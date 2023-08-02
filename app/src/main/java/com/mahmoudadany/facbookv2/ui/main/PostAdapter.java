package com.mahmoudadany.facbookv2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mahmoudadany.facbookv2.R;
import com.mahmoudadany.facbookv2.pojo.PostModel;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    List<PostModel> list=null;
public PostAdapter(List<PostModel> list){
    this.list=list;
}
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item,null,false);
    PostViewHolder holder=new PostViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.postid.setText(list.get(position).getId()+"");
        holder.userid.setText(list.get(position).getUserId()+"");
        holder.posttitle.setText(list.get(position).getTitle());
        holder.postbody.setText(list.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        if(list==null)return 0;
        return list.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        public TextView postid,userid,posttitle,postbody;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            postid=itemView.findViewById(R.id.tv_postid);
            posttitle=itemView.findViewById(R.id.tv_posttitle);
            postbody=itemView.findViewById(R.id.tv_postbody);
            userid=itemView.findViewById(R.id.tv_userid);
        }
    }
}
