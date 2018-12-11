package com.example.abdullah.project2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

public class CreatePost extends AppCompatActivity {
    EditText bname;
    EditText baddress;
    ImageView imageView;
    WorkerTaskFromAsync workerTaskFromAsync;
    private static DatabaseReference mDatabase;
    private static StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);
        bname=findViewById(R.id.c_name);
        baddress=findViewById(R.id.b_address);
        imageView=findViewById(R.id.cimageView);
        mDatabase = FirebaseDatabase.getInstance().getReference("brands");

    }


    public void onStartButton(View v) {
        workerTaskFromAsync = new WorkerTaskFromAsync();
        workerTaskFromAsync.setListener(new WorkerTaskFromAsync.InnerWorkerInterface() {
            @Override
            public void onWorkStarted(boolean status) {



            }

            @Override
            public void onWorkFinished(boolean status) {
                // Log.i(TAG, "Work is Finished, and Logging Out.");
                // updateUI("Logging Out!");
                // logoutScenario();
                workerTaskFromAsync.removeListener();
            }
        });
        workerTaskFromAsync.execute();
    }

    private static class WorkerTaskFromAsync extends AsyncTask<Void, Void, Integer> {
        interface InnerWorkerInterface{
            void onWorkStarted(boolean status);
            void onWorkFinished(boolean status);
        }
        InnerWorkerInterface workerInterface;
        private void setListener(InnerWorkerInterface innerWorkerInterface){
            workerInterface = innerWorkerInterface;
        }

        void removeListener(){
            workerInterface = null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            workerInterface.onWorkStarted(true);
           // Log.i("MainActivity", " Thread from onPreExecute: "+Thread.currentThread().getId());
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            //Log.i("MainActivity", " Thread from doInBackground: "+Thread.currentThread().getId());
            for(int i=0; i < 10; i++){
                if(isCancelled()){
                    break;
                }
                try{
              //      Log.i("MainActivity", "Id: "+i);
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Integer value) {
            //Log.i("MainActivity", " Thread from onPostExecute: "+Thread.currentThread().getId());
            super.onPostExecute(value);
            if(workerInterface!=null){
                workerInterface.onWorkFinished(true);
            }else{
              //  Log.i("MainActivity","Worker Interface is null");
            }
        }
    }



}
