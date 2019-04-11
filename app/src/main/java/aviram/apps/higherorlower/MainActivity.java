package aviram.apps.higherorlower;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    static int i = 0;

    public void SearchMethod (View view) throws IOException {

        Log.i( "Info", "Button Pressed");

        EditText editTextPillToBeFound = (EditText) findViewById(R.id.SearchTextInput);

        Log.i("Info", editTextPillToBeFound.getText().toString());

        final String pillStringToBeFound = editTextPillToBeFound.getText().toString().toLowerCase();

        final Handler handler = new Handler();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    final MyPillInformation  response = request(pillStringToBeFound);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i( "new intant", "dhklfhlsdfhldsfkhdsfkhsdk: ");
                            PillDetails pillDetails = new PillDetails(response);
                            Intent changeToPillDetails = new Intent(getApplicationContext(),pillDetails.getClass());
                            startActivity(changeToPillDetails);

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();






    }
    public MyPillInformation request(String params) throws IOException, JSONException {
        URL url = new URL("https://undefined-behavior.herokuapp.com/" + params);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        // optional default is GET
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        String responseStr = response.toString();
        JSONObject jsonObj = new JSONObject(responseStr);
        JSONObject detailsObj = jsonObj.getJSONObject("details");
        MyPillInformation pillInfo = new MyPillInformation();
        pillInfo.setPillIformation(detailsObj);
        return pillInfo;
    }

    public void CameraSearchMethod(View view) throws IOException {

        Log.i( "Info", "Camera Button  Pressed");

        //opens the user camera to take photo
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Log.i( "Info", "Photo Is Returned");
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            //ImageView takenPhoto = findViewById(R.id.imageView2);
           // takenPhoto.setImageBitmap(imageBitmap);
           // takenPhoto.setVisibility(View.VISIBLE);
        }

        if(i > 1)
        {
            i=0;
        }

        final String[] pillString = {"advil", "optalgin"};
        final String pillStringToBeFound = pillString[i];
        final Handler handler = new Handler();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    final MyPillInformation  response = request(pillStringToBeFound);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Log.i( "new intant", "dhklfhlsdfhldsfkhdsfkhsdk: ");
                            PillDetails pillDetails = new PillDetails(response);
                            Intent changeToPillDetails = new Intent(getApplicationContext(),pillDetails.getClass());
                            startActivity(changeToPillDetails);

                        }
                    });

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }).start();
        i++;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}


