package dev.mobile.digibanq.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

import info.androidhive.digibanq.R;

/**
 * Created by banktech on 7/28/2016.
 */
public class RegDocuments extends AppCompatActivity{

    ImageView upload_profile;
    Button back, next, dirChooserButton1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.reg_documents);
        //Button1
        dirChooserButton1 = (Button) findViewById(R.id.upload_bs_one);
        dirChooserButton1.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {
                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileOpenDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.docOne);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                //You can change the default filename using the public variable "Default_File_Name"
                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });

        //Button2
        Button dirChooserButton2 = (Button) findViewById(R.id.upload_bs_two);
        dirChooserButton2.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {
                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileSaveDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.docTwo);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                //You can change the default filename using the public variable "Default_File_Name"
                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });

        //Button3
        Button dirChooserButton3 = (Button) findViewById(R.id.upload_ps_one);
        dirChooserButton3.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {

                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileOpenDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.paySlipOne);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });

        //Button4
        Button dirChooserButton4 = (Button) findViewById(R.id.upload_ps_two);
        dirChooserButton4.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {

                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileOpenDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.paySlipTwo);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                        //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });

        //Button5
        Button dirChooserButton5 = (Button) findViewById(R.id.upload_ps_three);
        dirChooserButton5.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {

                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileOpenDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.paySlipThree);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });

        //Button4
        Button dirChooserButton6 = (Button) findViewById(R.id.upload_idCard);
        dirChooserButton6.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {

                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileOpenDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.idCard);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });

        //Button4
        Button dirChooserButton7 = (Button) findViewById(R.id.upload_empCard);
        dirChooserButton7.setOnClickListener(new View.OnClickListener()
        {
            String m_chosen;
            @Override
            public void onClick(View v) {

                /////////////////////////////////////////////////////////////////////////////////////////////////
                //Create FileOpenDialog and register a callback
                /////////////////////////////////////////////////////////////////////////////////////////////////
                SimpleFileDialog FileOpenDialog =  new SimpleFileDialog(RegDocuments.this, "FileOpen",
                        new SimpleFileDialog.SimpleFileDialogListener()
                        {
                            @Override
                            public void onChosenDir(String chosenDir)
                            {
                                // The code in this function will be executed when the dialog OK button is pushed
                                m_chosen = chosenDir;
                                EditText fileName = (EditText)findViewById(R.id.empCard);
                                fileName.setText(m_chosen);
                                //Toast.makeText(RegDocuments.this, "Chosen FileOpenDialog File: " +
                                //m_chosen, Toast.LENGTH_LONG).show();
                            }
                        });

                FileOpenDialog.Default_File_Name = "my_default.txt";
                FileOpenDialog.chooseFile_or_Dir();

                /////////////////////////////////////////////////////////////////////////////////////////////////

            }
        });




        upload_profile = (ImageView)findViewById(R.id.upload_profile);
        back = (Button)findViewById(R.id.btn_back);
        next = (Button)findViewById(R.id.btn_cont);

        upload_profile.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent upload = new Intent();
                upload.setType("image/*");
                upload.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(upload,"Choose Picture"),1);
            }


        });

        back.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent back = new Intent(RegDocuments.this, RegDetailsEmployment.class);
                RegDocuments.this.startActivity(back);
            }


        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                // Perform action on click
                Intent next = new Intent(RegDocuments.this, DigiPlanner.class);
                RegDocuments.this.startActivity(next);
            }


        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (resultCode==RESULT_CANCELED){
            //action cancelled
        }
        if (requestCode==RESULT_OK){
            Uri selectedimg = data.getData();
            try {
                upload_profile.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedimg));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
