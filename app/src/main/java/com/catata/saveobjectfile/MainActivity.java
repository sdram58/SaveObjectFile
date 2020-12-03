package com.catata.saveobjectfile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String filename ="productos.dat";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void guardar(View view) {
        //File f = new File(getFilesDir(),filename);
        //f.delete();

        List<Producto> lp;

        FileOutputStream fos;
        Random random = new Random();
        int i = random.nextInt();
        Producto p = new Producto(i, "Producto "+i,10,25.45);
        try{


            lp = cargar(null);

            lp.add(p);

            fos = openFileOutput(filename,MODE_PRIVATE);
            ObjectOutput output = new ObjectOutputStream(fos);
            output.writeObject(lp);
            output.flush();
            output.close();
            fos.close();
        }
        catch (Exception e){
            Toast.makeText(this,"Fallo al Guardar",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public List<Producto> cargar(View view) {

            List<Producto> al = new ArrayList<Producto>();

            FileInputStream fis;
            try {

                fis = openFileInput(filename);
                ObjectInputStream ois = new ObjectInputStream(fis);


                try {
                    al = (List<Producto>) ois.readObject();
                    ois.close();
                    fis.close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

            return al;
        }



}