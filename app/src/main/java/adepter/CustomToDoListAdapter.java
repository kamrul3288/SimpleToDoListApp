package adepter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import data.ToDoList;
import falcon_007.kamrulhasan.simpletodolistapp.R;

public class CustomToDoListAdapter extends ArrayAdapter<ToDoList>{

    private Activity activity;
    private int layoutResources;
    private List<ToDoList> toDoList = new ArrayList<>();

    public CustomToDoListAdapter(@NonNull Activity act, @LayoutRes int resource, List<ToDoList>mToDoList) {
        super(act, resource,mToDoList);
        activity = act;
        layoutResources = resource;
        toDoList = mToDoList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return toDoList.size();
    }

    @Nullable
    @Override
    public ToDoList getItem(int position) {
        return toDoList.get(position);
    }

    @Override
    public int getPosition(@Nullable ToDoList item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        ViewHolder holder = null;

        if (view == null || (view.getTag()) == null){
            LayoutInflater inflater = LayoutInflater.from(activity);
            view = inflater.inflate(layoutResources,null);

            holder.taskNameText = (TextView) view.findViewById(R.id.taskName);
            holder.taskDateTime = (TextView) view.findViewById(R.id.taskDate);
            holder.taskHintText = (TextView) view.findViewById(R.id.todoHintText);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.list = getItem(position);
        holder.taskNameText.setText(holder.list.getTaskName());
        holder.taskDateTime.setText(holder.list.getTimeAndDateText());
        holder.taskHintText.setText(holder.list.getTaskHintText());
        return view;
    }

    class ViewHolder{
        private ToDoList list;
        private TextView taskNameText;
        private TextView taskDateTime;
        private TextView taskHintText;
    }
}
