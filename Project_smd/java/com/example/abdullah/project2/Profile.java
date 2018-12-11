package com.example.abdullah.project2;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import static android.app.Activity.RESULT_OK;

public class Profile extends Fragment {

    TextView name;
    TextView email;

    TextView profile_name,profile_email;


    static ImageView imageView;
    private static DatabaseReference mDatabase;
    private static StorageReference mStorageRef;



   int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE=1000;

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        imageView = v.findViewById(R.id.imageView);
        mStorageRef = FirebaseStorage.getInstance().getReference();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= 23) {
                    // Here, thisActivity is the current activity
                    if (ContextCompat.checkSelfPermission(getContext(),
                            Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {

                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
                    } else {
                        Intent i = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        startActivityForResult(i, 1000);
                        startGallery();
                    }
                }
            }
        });

        name = v.findViewById(R.id.txt_name);
        email = v.findViewById(R.id.txt_email);

        profile_name=v.findViewById(R.id.textView7);
        profile_email=v.findViewById(R.id.textView8);

        profile_email.setText(getString(R.string.email));
        profile_name.setText(getString(R.string.name));
        //profile pic

       mDatabase = FirebaseDatabase.getInstance().getReference("users");

        //setting name and email
        // Read from the database
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                FirebaseUser userId = FirebaseAuth.getInstance().getCurrentUser();

                String uid = userId.getUid();

                Users userd=new Users();

                userd.setName(dataSnapshot.child(uid).getValue(Users.class).getName());
                userd.setEmail(dataSnapshot.child(uid).getValue(Users.class).getEmail());

                Toast.makeText(getContext(),userd.getEmail()+userd.getName(),Toast.LENGTH_LONG).show();

                name.setText(userd.getName());
                email.setText(userd.getEmail());

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                //Log.w(TAG, "Failed to read value.", error.toException());

            }
        });



       FirebaseUser userId = FirebaseAuth.getInstance().getCurrentUser();
       String uid = userId.getUid();
       mStorageRef = FirebaseStorage.getInstance().getReference();

       StorageReference riversRef = mStorageRef.child("Users").child(uid);

       riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
           @Override
           public void onSuccess(Uri uri) {
               Picasso.get().load(uri).into(imageView);
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception exception) {
               Toast.makeText(getActivity(),"Profile pic error",Toast.LENGTH_LONG).show();
           }
       });




       return v;
    }


    private void startGallery() {

       Intent cameraIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

       cameraIntent.setType("image/*");

        if (cameraIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(cameraIntent, 1000);
        }

   }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //super method removed
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                Uri returnUri = data.getData();
                Bitmap bitmapImage = null;

                try {
                    bitmapImage = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), returnUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                imageView.setImageBitmap(bitmapImage);

                FirebaseUser userId = FirebaseAuth.getInstance().getCurrentUser();
                String uid = userId.getUid();
                StorageReference riversRef = mStorageRef.child("Users").child(uid);


                riversRef.putFile(returnUri)
                        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                                // Get a URL to the uploaded content
                                Uri downloadUrl = taskSnapshot.getDownloadUrl();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception exception) {
                                // Handle unsuccessful uploads
                                // ...
                            }
                        });


            }
        }
    }









}
