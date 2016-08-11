package org.vackapi.mvplearn.mvp2;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import org.vackapi.mvplearn.R;
import org.vackapi.mvplearn.mvp2.moudle.CanKingItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/8/3.
 */
public class CanKingItemAdapter extends RecyclerView.Adapter<CanKingItemAdapter.CanKingViewHolder>{
    private ArrayList<CanKingItem> data;
    private static final int TYPE_HEADER=-1;
    private static final int TYPE_NORMAL=0;
    private View header;
    private Context context;
    private int screenWidth;
    private OnItemClickListener onItemClickListener;
    private View.OnClickListener onHeaderClick;

    public CanKingItemAdapter(Context context,ArrayList<CanKingItem> data) {
        this.data = data;
        this.context=context;
        screenWidth=context.getResources().getDisplayMetrics().widthPixels;
    }

    @Override
    public CanKingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==TYPE_HEADER){
            return new CanKingViewHolder(header);
        }else {
            return new CanKingViewHolder(LayoutInflater.from(context).inflate(R.layout.item_canking,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(final CanKingViewHolder holder, int position) {
        if(getItemViewType(position)==TYPE_HEADER){
            return;
        }
        position=getRealPosition(holder);
        holder.textView_canKingItem_title.setText(data.get(position).getPost_title());
        Glide.with(holder.imageView_canKingItem_main.getContext()).load(data.get(position).getImg_src()).asBitmap().listener(new RequestListener<String, Bitmap>() {
            @Override
            public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                int picWidth=resource.getWidth();
                int picHeight=resource.getHeight();
                ViewGroup.LayoutParams layoutParams=holder.imageView_canKingItem_main.getLayoutParams();
                layoutParams.height= (int) (picHeight*(float)screenWidth/(float) picWidth);
                layoutParams.width=screenWidth;
                holder.imageView_canKingItem_main.setLayoutParams(layoutParams);
                return false;
            }
        }).error(R.mipmap.ic_launcher).into(holder.imageView_canKingItem_main);
        holder.textView_canKingItem_date.setText(data.get(position).getPost_date());
    }

    @Override
    public int getItemCount() {
        return header==null?data.size():data.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0&&header!=null){
            return TYPE_HEADER;
        }else {
            return TYPE_NORMAL;
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        RecyclerView.LayoutManager layoutManager=recyclerView.getLayoutManager();
        if(layoutManager instanceof GridLayoutManager){
            GridLayoutManager gridLayoutManager=(GridLayoutManager)layoutManager;
            gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
                @Override
                public int getSpanSize(int position) {
                    return getItemViewType(position)==TYPE_HEADER?1:gridLayoutManager.getSpanCount();
                }
            });
        }
    }

    public int getRealPosition(CanKingViewHolder holder){
        return header==null?holder.getLayoutPosition():holder.getLayoutPosition()-1;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener=onItemClickListener;
    }

    public void setOnHeaderClick(View.OnClickListener onHeaderClick){
        this.onHeaderClick=onHeaderClick;
    }


    public class CanKingViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView_canKingItem_main;
        private TextView textView_canKingItem_title;
        private TextView textView_canKingItem_date;
        public CanKingViewHolder(View itemView) {
            super(itemView);
            if (itemView==header){
                header.setOnClickListener(onHeaderClick);
                return;
            }else {
                imageView_canKingItem_main= (ImageView) itemView.findViewById(R.id.imageView_canKingItem_main);
                textView_canKingItem_title= (TextView) itemView.findViewById(R.id.textView_canKingItem_title);
                textView_canKingItem_date= (TextView) itemView.findViewById(R.id.textView_canKingItem_date);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(onItemClickListener!=null){
                            onItemClickListener.onItemClick(getRealPosition(CanKingViewHolder.this));
                        }
                    }
                });
            }
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}
