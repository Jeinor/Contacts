package com.example.contacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
public class ListViewAdapter extends ArrayAdapter<ContactData>
{
    private final LayoutInflater inflater;
    private final int layout;
    private final List<ContactData> contactData;

    public ListViewAdapter(Context context, int resource, List<ContactData> contactData)
    {
        super(context, resource, contactData);
        this.contactData = contactData;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
        {
            ContactData contactData = this.contactData.get(position);
            convertView = inflater.inflate(this.layout, parent, false);

            TextView firstNameView = convertView.findViewById(R.id.first_name_list);
            firstNameView.setText(contactData.getFirstName());

            TextView secondNameView = convertView.findViewById(R.id.second_name_list);
            secondNameView.setText(contactData.getSecondName());

            TextView surnameView = convertView.findViewById(R.id.surname_list);
            surnameView.setText(contactData.getSurname());

            TextView phoneView = convertView.findViewById(R.id.phone_list);
            phoneView.setText(contactData.getPhone());

            TextView emailView = convertView.findViewById(R.id.email_list);
            emailView.setText(contactData.getEmail());

            Button removeView = convertView.findViewById(R.id.remove_list);
            removeView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    MainActivity.removeItem(position);
                }
            });
        }

        return convertView;
    }

}
