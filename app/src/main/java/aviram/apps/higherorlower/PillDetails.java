package aviram.apps.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class PillDetails extends AppCompatActivity {

    static MyPillInformation response;
    public PillDetails() {
        Log.i("Info ", "dedault: " );
    }
    public PillDetails(MyPillInformation i_response) {

        this.response = i_response;
    }

    public void SearchMethod ()  {
        //fill the TextViews
        Log.i("Info", "Showing Details");
       TextView idTextView = (TextView) findViewById(R.id.idTextView);
       idTextView.setText(response.getId());
       TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
       nameTextView.setText(response.getName());
       TextView desTextView = (TextView) findViewById(R.id.desTextView);
       desTextView.setText(response.getDescription());
       TextView dosTextView = (TextView) findViewById(R.id.dosTextView);
       dosTextView.setText(response.getDosAge());
       TextView ingTextView = (TextView) findViewById(R.id.ingTextView);
       ingTextView.setText(response.getElegranIngredients());
       TextView pregTextView = (TextView) findViewById(R.id.pregTextView);
        pregTextView.setText(response.getPregnancySafe());
       TextView urlTextView = (TextView) findViewById(R.id.urlTextView);
       urlTextView.setText(response.getUrl());
       TextView instructionsTextView = (TextView) findViewById(R.id.instructionsTextView);
       instructionsTextView.setText(response.getInstructions());


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pill_details);
        SearchMethod();

    }
}
