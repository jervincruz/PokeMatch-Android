package jervincruz.homework2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends FragmentActivity implements rulesFragment.OnFragmentInteractionListener {
    Button play;
    Button rules;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        play = (Button)findViewById(R.id.button);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent i = new Intent(getApplicationContext(), play.class);
                startActivity(i);
            }
        });


        rules = (Button)findViewById(R.id.button2);
        rules.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Fragment fragment = new rulesFragment();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.replace(R.id.fragmentRules, fragment);
                transaction.commit();
        }
    });
    }

    public void onFragmentInteraction(Uri uri){
        Toast toast = Toast.makeText(this, "Wheee!", Toast.LENGTH_SHORT);
        toast.show();
    }

}