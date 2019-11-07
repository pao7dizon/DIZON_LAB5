package com.example.dizon_lab5;


import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] name, version, api, releaseDate;
    ListView listView;
    int[] aLogo = {R.drawable.cupcake, R.drawable.donut, R.drawable.e, R.drawable.froyo, R.drawable.g, R.drawable.honey, R.drawable.ice, R.drawable.jelly, R.drawable.kitkat, R.drawable.lolli, R.drawable.marsh, R.drawable.nougat, R.drawable.oreo, R.drawable.pie, R.drawable.q10};
    ArrayList<Versions> AndroidList = new ArrayList<>();
    String[] versionInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("ANDROID VERSIONS");
        name = getResources().getStringArray(R.array.Name);
        version = getResources().getStringArray(R.array.Version);
        api = getResources().getStringArray(R.array.API);
        releaseDate = getResources().getStringArray(R.array.ReleaseDate);
        versionInfo = getResources().getStringArray(R.array.Trivia);
        for(int i=0; i < name.length; i++){
            AndroidList.add(new Versions(aLogo[i], name[i], "Ver. " + version[i], "API Level " + api[i], "Released " + releaseDate[i]));
        }

        listView = findViewById(R.id.listView);
        ArrayAdapter myArrayAdapter = new Adapter(this, R.layout.item, AndroidList);
        listView.setAdapter(myArrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        try{
            final AlertDialog.Builder myDialog = new AlertDialog.Builder(this);
            final File folder = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
            final File file = new File(folder, "androidversion.txt");
            FileOutputStream fos = new FileOutputStream(file);
            String choice = "Version Name: " + AndroidList.get(i).getName() + ", " + AndroidList.get(i).getReleaseDate();
            fos.write(choice.getBytes());
            fos.close();
            myDialog.setTitle(AndroidList.get(i).getName());
            myDialog.setIcon(AndroidList.get(i).getLogo());
            myDialog.setMessage(versionInfo[i]);
            myDialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    Toast();
                }
            });
            myDialog.create().show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void Toast(){
        try {
            FileInputStream fin = new FileInputStream(new File(getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS) + "/androidversion.txt"));
            int c;
            String StoredString = "";
            while( (c = fin.read()) != -1) {
                StoredString += Character.toString((char)c);
            }
            fin.close();
            Toast.makeText( this, StoredString, Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
}
