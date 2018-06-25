package com.fortests.meet7practicefactory;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private final List<ViewHolderBinder> mBinders;
    private SparseArray<ViewHolderFactory> mFactoryMap;

    ArrayList<ItemTypes> mDate;

    public MyAdapter(ArrayList<ItemTypes> date) {
        mDate = date;
        mBinders = new ArrayList<>();
        for (ItemTypes type: date) {
            mBinders.add(generateBinder(type));
        }
        initFactory();
    }

    private void initFactory() {
        mFactoryMap = new SparseArray<>();
        mFactoryMap.put(ItemTypes.ITEM1.type, new Item1ViewHolderFactory());
        mFactoryMap.put(ItemTypes.ITEM2.type, new Item2ViewHolderFactory());
        mFactoryMap.put(ItemTypes.ITEM3.type, new Item3ViewHolderFactory());
    }

    @Override
    public int getItemViewType(int position) {
        if (mDate.get(position).getType() == ItemTypes.ITEM1.type){
            return ItemTypes.ITEM1.type;
        } else if (mDate.get(position).getType() == ItemTypes.ITEM2.type){
            return ItemTypes.ITEM2.type;
        } else if (mDate.get(position).getType() == ItemTypes.ITEM3.type){
            return ItemTypes.ITEM3.type;
        }
        return mDate.get(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolderFactory factory = mFactoryMap.get(viewType);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return factory.createViewHolder(parent,inflater);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ViewHolderBinder binder = mBinders.get(position);
        if (binder != null){
            binder.bindViewHoder(holder);
        }
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }

    //____________

    private class Item1ViewHolderFactory implements ViewHolderFactory {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
            View itemView = inflater.inflate(R.layout.cell_1,parent,false);
            RecyclerView.ViewHolder holder = new MyAdapter.MyView1Holder(itemView);
            return holder;
        }
    }
    private class Item2ViewHolderFactory implements ViewHolderFactory {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
            View itemView = inflater.inflate(R.layout.cell_2,parent,false);
            RecyclerView.ViewHolder holder = new MyAdapter.MyView2Holder(itemView);
            return holder;
        }
    }
    private class Item3ViewHolderFactory implements ViewHolderFactory {
        @Override
        public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, LayoutInflater inflater) {
            View itemView = inflater.inflate(R.layout.cell_3,parent,false);
            RecyclerView.ViewHolder holder = new MyAdapter.MyView3Holder(itemView);
            return holder;
        }
    }

    //_________________

    private static class MyView1Holder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyView1Holder(View itemView) {
            super(itemView);
            // textview here
        }
    }


    private static class MyView2Holder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyView2Holder(View itemView) {
            super(itemView);
            // textview here
        }
    }

    private static class MyView3Holder extends RecyclerView.ViewHolder {
        TextView mTextView;

        public MyView3Holder(View itemView) {
            super(itemView);
            // textview here
        }
    }

    //_________________

    private ViewHolderBinder generateBinder(BaseItem item){
        if (item.getType() == ItemTypes.ITEM1.type){
            return new MyView1HolderBinder(item,ItemTypes.ITEM1.type);
        } else if (item.getType() == ItemTypes.ITEM2.type){
            return new MyView2HolderBinder(item,ItemTypes.ITEM2.type);
        } else if (item.getType() == ItemTypes.ITEM3.type){
            return new MyView3HolderBinder(item,ItemTypes.ITEM3.type);
        }
        return null;
    }

    public void setData(List<BaseItem> items){
        mBinders.clear();
        for (BaseItem item: items){
            mBinders.add(generateBinder(item));
        }
        notifyDataSetChanged();
    }

    public abstract class ViewHolderBinder {
        protected final int viewType;

        public ViewHolderBinder(int viewType){
            this.viewType = viewType;
        }

        public abstract void bindViewHoder(RecyclerView.ViewHolder holder);

        public abstract BaseItem getItem();



    }


    public class MyView1HolderBinder extends ViewHolderBinder{

        private final ItemTypes mItem;

        public MyView1HolderBinder(BaseItem item, int viewType) {
            super(viewType);
            mItem = (ItemTypes) item;
        }

        @Override
        public void bindViewHoder(RecyclerView.ViewHolder holder) {
            MyAdapter.MyView1Holder myView1Holder = (MyAdapter.MyView1Holder) holder;
            //here set id name etc
        }

        @Override
        public BaseItem getItem() {
            return mItem;
        }
    }
    public class MyView2HolderBinder extends ViewHolderBinder{

        private final ItemTypes mItem;

        public MyView2HolderBinder(BaseItem item, int viewType) {
            super(viewType);
            mItem = (ItemTypes) item;
        }

        @Override
        public void bindViewHoder(RecyclerView.ViewHolder holder) {
            MyAdapter.MyView2Holder myView2Holder = (MyAdapter.MyView2Holder) holder;
            //here set id name etc
        }

        @Override
        public BaseItem getItem() {
            return mItem;
        }
    }    public class MyView3HolderBinder extends ViewHolderBinder{

        private final ItemTypes mItem;

        public MyView3HolderBinder(BaseItem item, int viewType) {
            super(viewType);
            mItem = (ItemTypes) item;
        }

        @Override
        public void bindViewHoder(RecyclerView.ViewHolder holder) {
            MyAdapter.MyView3Holder myView1Holder = (MyAdapter.MyView3Holder) holder;
            //here set id name etc
        }

        @Override
        public BaseItem getItem() {
            return mItem;
        }
    }

}
