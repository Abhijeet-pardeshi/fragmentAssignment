package com.example.aryan.filehandlingdemo;

import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by aryan on 12/9/17.
 */

public class CopyDirectoryOrFile {

    public static void copyDirectory(File source,File destination) throws Exception {

        if (source.isDirectory()) {
            if (!destination.exists()) {
                destination.mkdir();
            }
            String[] children = source.list();
            for (int i = 0; i < source.listFiles().length; i++) {

                copyDirectory(new File(source, children[i]),
                        new File(destination, children[i]));
            }
        } else {
            BufferedInputStream bufferedInputStream = null;
            bufferedInputStream = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bufferedOutputStream = null;
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destination));

            byte[] bytes = new byte[2048];
            int readedbyte;
            while ((readedbyte = bufferedInputStream.read()) > 0) {
                bufferedOutputStream.write(bytes, 0, readedbyte);
            }
        }
    }
}
