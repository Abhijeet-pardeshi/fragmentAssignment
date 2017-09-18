package com.example.aryan.filehandlingdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private CopyDirectoryOrFile mCopyDirectoryOrFile = new CopyDirectoryOrFile();
    private EditText mEdtView;
    private File source = new File("/root/data/data/com.example.aryan.filehandlingdemo");
    private File destination = new File("/root/data/data/com.example.aryan.filehandlingdemo/Myapp");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtView = (EditText) findViewById(R.id.edtInfo);
        try {
            mCopyDirectoryOrFile.copyDirectory(source,destination);
        } catch (Exception e) {
            Toast.makeText(this,e.toString(),Toast.LENGTH_SHORT).show();
            String path = source.getAbsolutePath();
            mEdtView.setText(path);
        }
    }
}
