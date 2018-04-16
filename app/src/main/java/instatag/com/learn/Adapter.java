package instatag.com.learn;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RahulReign on 16-04-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
   // private List<Contact>contacts;
    private List<Contact>contacts=new ArrayList<>();

    public Adapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//here we can bind value to the textviews

        holder.name.setText(contacts.get(position).getName());
        holder.email.setText(contacts.get(position).getEmail());
        holder.pw.setText(contacts.get(position).getPassword());
        holder.country.setText(contacts.get(position).getCountry());

        //step4: now go to main activity


    }

    @Override
    public int getItemCount() {
        //return contacts.size();

        return null!=contacts?contacts.size():0;
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,email,pw,country;
        public MyViewHolder(View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nameid);
            email=(TextView)itemView.findViewById(R.id.emailId);
            country=(TextView) itemView.findViewById(R.id.countyId);
            pw=(TextView)itemView.findViewById(R.id.pwId);
        }
    }
}
