package jervincruz.homework2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class play extends AppCompatActivity{
    @BindView (R.id.textView3) TextView points;
    @BindView (R.id.button3) Button restart;
    @BindView (R.id.button4) Button shuffle;

    @BindView (R.id.imageButton) ImageButton eevee1;
    @BindView (R.id.imageButton20) ImageButton eevee2;
    @BindView (R.id.imageButton2) ImageButton ditto1;
    @BindView (R.id.imageButton19) ImageButton ditto2;
    @BindView (R.id.imageButton3) ImageButton jigglypuff1;
    @BindView (R.id.imageButton18) ImageButton jigglypuff2;
    @BindView (R.id.imageButton4) ImageButton mew1;
    @BindView (R.id.imageButton17) ImageButton mew2;
    @BindView (R.id.imageButton5) ImageButton mewtwo1;
    @BindView (R.id.imageButton16) ImageButton mewtwo2;
    @BindView (R.id.imageButton6) ImageButton ninetales1;
    @BindView (R.id.imageButton15) ImageButton ninetales2;
    @BindView (R.id.imageButton7) ImageButton pikachu1;
    @BindView (R.id.imageButton14) ImageButton pikachu2;
    @BindView (R.id.imageButton8) ImageButton psyduck1;
    @BindView (R.id.imageButton13) ImageButton psyduck2;
    @BindView (R.id.imageButton9) ImageButton slowpoke1;
    @BindView (R.id.imageButton12) ImageButton slowpoke2;
    @BindView (R.id.imageButton10) ImageButton togepi1;
    @BindView (R.id.imageButton11) ImageButton togepi2;

    Button b1;
    String firstPokemon, secondPokemon;
    ArrayList<String> matchedPokemon = new ArrayList<>();
    ArrayList<String> unmatchedPokemon = new ArrayList<>();
    // ImageButton shuffle array
    // When in play, add matched ones first. Then add non-matched ones to arraylist.
    // Create a view method that displays the buttons in a for loop

    ImageButton [] buttons = new ImageButton[20];


    int pointCounter = 0;
    int clickCounter = 0;

    SharedPreferences sharedPreferences;
    Animation shake;

    RelativeLayout relativeLayout;

    private void savePreferences(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Set<String> matched = sharedPreferences.getStringSet("set", new HashSet<String>());

        for(int i = 0; i < matchedPokemon.size(); i++){
            matched.add(matchedPokemon.get(i));
        }

        editor.putStringSet("set", matched);

        editor.commit();
    }

    private void loadPreferences(){
        sharedPreferences = getPreferences(MODE_PRIVATE);
        Set<String> getSet = new HashSet<String>();

        for(int i = 0; i < matchedPokemon.size(); i++){
            getSet = sharedPreferences.getStringSet("set", null);
        }

        for(String a : getSet){
            flipOver(a);
        }
    }

    @Override
    public void onBackPressed(){
        savePreferences();
        super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // loadPreferences();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play2);


        buttons[0] = (eevee1);
        buttons[1] = (eevee2);
        buttons[2] = (ditto1);
        buttons[3] = (ditto2);
        buttons[4] = (jigglypuff1);
        buttons[5] = (jigglypuff2);
        buttons[6] = (mew1);
        buttons[7] = (mew2);
        buttons[8] = (mewtwo1);
        buttons[9] = (mewtwo2);
        buttons[10] = (ninetales1);
        buttons[11] = (ninetales2);
        buttons[12] = (pikachu1);
        buttons[13] = (pikachu2);
        buttons[14] = (psyduck1);
        buttons[15] = (psyduck2);
        buttons[16] = (slowpoke1);
        buttons[17] = (slowpoke2);
        buttons[18] = (togepi1);
        buttons[19] = (togepi2);

        shake = AnimationUtils.loadAnimation(this,R.anim.shake);
        ButterKnife.bind(this);
       // loadPreferences();

        for(int j = 0; j < 20; j++){
            unmatchedPokemon.add("eevee1");
            unmatchedPokemon.add("eevee2");
            unmatchedPokemon.add("ditto1");
            unmatchedPokemon.add("ditto2");
            unmatchedPokemon.add("jigglypuff1");
            unmatchedPokemon.add("jigglypuff2");
            unmatchedPokemon.add("mew1");
            unmatchedPokemon.add("mew2");
            unmatchedPokemon.add("mewtwo1");
            unmatchedPokemon.add("mewtwo2");
            unmatchedPokemon.add("ninetales1");
            unmatchedPokemon.add("nientales2");
            unmatchedPokemon.add("pikachu1");
            unmatchedPokemon.add("pikachu2");
            unmatchedPokemon.add("psyduck1");
            unmatchedPokemon.add("psyduck2");
            unmatchedPokemon.add("slowpoke1");
            unmatchedPokemon.add("slowpoke2");
            unmatchedPokemon.add("togepi1");
            unmatchedPokemon.add("togepi2");
        }


     }

    @OnClick(R.id.imageButton)
    void clicked(){
        clickCounter++;
        if (clickCounter == 1) {
            eevee1.startAnimation(shake);
            firstPokemon = "eevee1";
            eevee1.setImageResource(R.drawable.eevee);
        } else if(clickCounter == 2) {
            secondPokemon = "eevee1";
            eevee1.setImageResource(R.drawable.eevee);
            isMatch(firstPokemon, secondPokemon);
        }
    }
    @OnClick(R.id.imageButton20)
    void clicked20(){
            clickCounter++;
            if(clickCounter == 1){
                eevee2.startAnimation(shake);
                firstPokemon = "eevee2";
                eevee2.setImageResource(R.drawable.eevee);
            }
            else if(clickCounter == 2){
                secondPokemon = "eevee2";
                eevee2.setImageResource(R.drawable.eevee);
                isMatch(firstPokemon, secondPokemon);
                clickCounter = 0;
            }
    }
    @OnClick(R.id.imageButton2)
    void clicked2(){
        clickCounter++;
        if (clickCounter == 1) {
            ditto1.startAnimation(shake);
            firstPokemon = "ditto1";
            ditto1.setImageResource(R.drawable.ditto);
        } else if (clickCounter == 2) {
            secondPokemon = "ditto1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton19)
    void clicked19(){
        clickCounter++;
        if (clickCounter == 1) {
            ditto2.startAnimation(shake);
            firstPokemon = "ditto2";
            ditto2.setImageResource(R.drawable.ditto);
        }
        else if(clickCounter == 2) {
            secondPokemon = "ditto2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton3)
    void clicked3(){
        clickCounter++;
        if (clickCounter == 1) {
            jigglypuff1.startAnimation(shake);
            firstPokemon = "jigglypuff1";
            jigglypuff1.setImageResource(R.drawable.jigglypuff);
        }
        else if(clickCounter == 2) {
            secondPokemon = "jigglypuff1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton18)
    void clicked18(){
        clickCounter++;
        if (clickCounter == 1) {
            jigglypuff2.startAnimation(shake);
            firstPokemon = "jigglypuff2";
            jigglypuff2.setImageResource(R.drawable.jigglypuff);
        }
        else if(clickCounter == 2) {
            secondPokemon = "jigglypuff2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton4)
    void clicked4(){
        clickCounter++;
        if (clickCounter == 1) {
            mew1.startAnimation(shake);
            firstPokemon = "mew1";
            mew1.setImageResource(R.drawable.mew);
        }
        else if(clickCounter == 2) {
            secondPokemon = "mew1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton17)
    void clicked17(){
        clickCounter++;
        if (clickCounter == 1) {
            mew2.startAnimation(shake);
            firstPokemon = "mew2";
            mew2.setImageResource(R.drawable.mew);
        }
        else if(clickCounter == 2) {
            secondPokemon = "mew2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton5)
    void clicked5(){
        clickCounter++;
        if (clickCounter == 1) {
            mewtwo1.startAnimation(shake);
            firstPokemon = "mewtwo1";
            mewtwo1.setImageResource(R.drawable.mewtwo);
        }
        else if(clickCounter == 2) {
            secondPokemon = "mewtwo1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton16)
    void clicked16(){
        clickCounter++;
        if (clickCounter == 1) {
            mewtwo2.startAnimation(shake);
            firstPokemon = "mewtwo2";
            mewtwo2.setImageResource(R.drawable.mewtwo);
        }
        else if(clickCounter == 2) {
            secondPokemon = "mewtwo2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton6)
    void clicked6(){
        clickCounter++;
        if (clickCounter == 1) {
            ninetales1.startAnimation(shake);
            firstPokemon = "ninetales1";
            ninetales1.setImageResource(R.drawable.ninetales);
        }
        else if(clickCounter == 2) {
            ninetales1.startAnimation(shake);
            secondPokemon = "ninetales1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton15)
    void clicked15(){
        clickCounter++;
        if (clickCounter == 1) {
            ninetales2.startAnimation(shake);
            firstPokemon = "ninetales2";
            ninetales2.setImageResource(R.drawable.ninetales);
        }
        else if(clickCounter == 2) {
            secondPokemon = "ninetales2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton7)
    void clicked7(){
        clickCounter++;
        if (clickCounter == 1) {
            pikachu1.startAnimation(shake);
            firstPokemon = "pikachu1";
            pikachu1.setImageResource(R.drawable.pikachu);
        }
        else if(clickCounter == 2) {
            secondPokemon = "pikachu1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton14)
    void clicked14(){
        clickCounter++;
        if (clickCounter == 1) {
            pikachu2.startAnimation(shake);
            firstPokemon = "pikachu2";
            pikachu2.setImageResource(R.drawable.pikachu);
        }
        else if(clickCounter == 2) {
            secondPokemon = "pikachu2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton8)
    void clicked8(){
        clickCounter++;
        if (clickCounter == 1) {
            psyduck1.startAnimation(shake);
            firstPokemon = "psyduck1";
            psyduck1.setImageResource(R.drawable.psyduck);
        }
        else if(clickCounter == 2) {
            secondPokemon = "psyduck1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton13)
    void clicked13(){
        clickCounter++;
        if (clickCounter == 1) {
            psyduck2.startAnimation(shake);
            firstPokemon = "psyduck2";
            psyduck2.setImageResource(R.drawable.psyduck);
        }
        else if(clickCounter == 2) {
            secondPokemon = "psyduck2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton9)
    void clicked9(){
        clickCounter++;
        if (clickCounter == 1) {
            slowpoke1.startAnimation(shake);
            firstPokemon = "slowpoke1";
            slowpoke1.setImageResource(R.drawable.slowpoke);
        }
        else if(clickCounter == 2) {
            secondPokemon = "slowpoke1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton12)
    void clicked12(){
        clickCounter++;
        if (clickCounter == 1) {
            slowpoke2.startAnimation(shake);
            firstPokemon = "slowpoke2";
            slowpoke2.setImageResource(R.drawable.slowpoke);
        }
        else if(clickCounter == 2) {
            secondPokemon = "slowpoke2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton10)
    void clicked10(){
        clickCounter++;
        if (clickCounter == 1) {
            togepi1.startAnimation(shake);
            firstPokemon = "togepi1";
            togepi1.setImageResource(R.drawable.togepi);
        }
        else if(clickCounter == 2) {
            secondPokemon = "togepi1";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.imageButton11)
    void clicked11(){
        clickCounter++;
        if (clickCounter == 1) {
            togepi2.startAnimation(shake);
            firstPokemon = "togepi2";
            togepi2.setImageResource(R.drawable.togepi);
        }
        else if(clickCounter == 2) {
            secondPokemon = "togepi2";
            isMatch(firstPokemon, secondPokemon);
            clickCounter = 0;
        }
    }
    @OnClick(R.id.button3)
    void clickedRestart(){
         /* Make imageButtons visible again then make it transparent (turn it over) */
        eevee1.setVisibility(View.VISIBLE);
        eevee2.setVisibility(View.VISIBLE);
        ditto1.setVisibility(View.VISIBLE);
        ditto2.setVisibility(View.VISIBLE);
        jigglypuff1.setVisibility(View.VISIBLE);
        jigglypuff2.setVisibility(View.VISIBLE);
        mew1.setVisibility(View.VISIBLE);
        mew2.setVisibility(View.VISIBLE);
        mewtwo1.setVisibility(View.VISIBLE);
        mewtwo2.setVisibility(View.VISIBLE);
        ninetales1.setVisibility(View.VISIBLE);
        ninetales2.setVisibility(View.VISIBLE);
        pikachu1.setVisibility(View.VISIBLE);
        pikachu2.setVisibility(View.VISIBLE);
        psyduck1.setVisibility(View.VISIBLE);
        psyduck2.setVisibility(View.VISIBLE);
        slowpoke1.setVisibility(View.VISIBLE);
        slowpoke2.setVisibility(View.VISIBLE);
        togepi1.setVisibility(View.VISIBLE);
        togepi2.setVisibility(View.VISIBLE);

        eevee1.setImageResource(android.R.color.transparent);
        eevee2.setImageResource(android.R.color.transparent);
        ditto1.setImageResource(android.R.color.transparent);
        ditto2.setImageResource(android.R.color.transparent);
        jigglypuff1.setImageResource(android.R.color.transparent);
        jigglypuff2.setImageResource(android.R.color.transparent);
        mew1.setImageResource(android.R.color.transparent);
        mew2.setImageResource(android.R.color.transparent);
        mewtwo1.setImageResource(android.R.color.transparent);
        mewtwo2.setImageResource(android.R.color.transparent);
        ninetales1.setImageResource(android.R.color.transparent);
        ninetales2.setImageResource(android.R.color.transparent);
        pikachu1.setImageResource(android.R.color.transparent);
        pikachu2.setImageResource(android.R.color.transparent);
        psyduck1.setImageResource(android.R.color.transparent);
        psyduck2.setImageResource(android.R.color.transparent);
        slowpoke1.setImageResource(android.R.color.transparent);
        slowpoke2.setImageResource(android.R.color.transparent);
        togepi1.setImageResource(android.R.color.transparent);
        togepi2.setImageResource(android.R.color.transparent);

        pointCounter = 0;
        points.setText("0");
    }
    @OnClick(R.id.button4)
    void onClickedShuffle(){
        relativeLayout = (RelativeLayout) findViewById(R.id.layout);
        relativeLayout.removeAllViews();
        int row2 = 0; int row3 = 0; int row4 = 0; int row5 = 0;

        // get the unmatched and put those in new layout
        for(int i = 0; i < matchedPokemon.size(); i++){
            for(int j = 0; j < unmatchedPokemon.size(); j++){
                if(unmatchedPokemon.get(j) == matchedPokemon.get(i))
                    unmatchedPokemon.remove(j);
            }
        }

        for(int i = 0; i < 4; i++){
            buttons[i] = new ImageButton(this);
            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[unmatchedPokemon.size()];
            params[i] = new RelativeLayout.LayoutParams(310, 310);
            params[i].setMargins(315*i, 0, 0, 0);
            relativeLayout.addView(buttons[i], params[i]);
        }



        //Collections.shuffle(Arrays.asList(buttons));

        /*

        for(int i = 0; i < 4; i++) {
            buttons[i] = new ImageButton(this);
            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[20];
            params[i] = new RelativeLayout.LayoutParams(310, 310);
            params[i].setMargins(315*i, 0, 0, 0);
            relativeLayout.addView(buttons[i], params[i]);
        }
        matchedPokemon.add("eevee1");

        for(int i = 0; i < matchedPokemon.size(); i++){
            // all the if statements start here
            buttons[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    for(int i = 0; i < matchedPokemon.size(); i++){
                    if(matchedPokemon.get(i) == "eevee1"){
                        clickCounter++;
                        if (clickCounter == 1) {
                            buttons[i].startAnimation(shake);
                            firstPokemon = "eevee1";
                            buttons[i].setImageResource(R.drawable.eevee);
                        } else if (clickCounter == 2) {
                            secondPokemon = "eevee1";
                            buttons[i].setImageResource(R.drawable.eevee);
                            isMatch(firstPokemon, secondPokemon);
                        }
                    }
                    }
                }
            });

        }

        for(int i = 4; i < 8; i++) {
            buttons[i] = new ImageButton(this);
            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[20];
            params[i] = new RelativeLayout.LayoutParams(310, 310);
            params[i].setMargins(315*row2, 300, 0, 0);
            relativeLayout.addView(buttons[i], params[i]);
            row2++;
        }

        for(int i = 8; i < 12; i++) {
            int spacing = 0;
            buttons[i] = new ImageButton(this);
            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[20];
            params[i] = new RelativeLayout.LayoutParams(310, 310);
            params[i].setMargins(315*row3, 600, 0, 0);
            relativeLayout.addView(buttons[i], params[i]);
            row3++;
        }
        for(int i = 12; i < 16; i++) {
            int spacing = 0;
            buttons[i] = new ImageButton(this);
            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[20];
            params[i] = new RelativeLayout.LayoutParams(310, 310);
            params[i].setMargins(315*row4, 900, 0, 0);
            relativeLayout.addView(buttons[i], params[i]);
            row4++;
        }
        for(int i = 16; i < 20; i++) {
            int spacing = 0;
            buttons[i] = new ImageButton(this);
            RelativeLayout.LayoutParams[] params = new RelativeLayout.LayoutParams[20];
            params[i] = new RelativeLayout.LayoutParams(310, 310);
            params[i].setMargins(315*row5, 1200, 0, 0);
            relativeLayout.addView(buttons[i], params[i]);
            row5++;
        }

*/


        //b1.setLayoutParams(param);
    }

    public void isMatch(String firstPokemon, String secondPokemon){
                // SECOND CLICKS ONLY

                // Eevee
                if((firstPokemon == "eevee1" && secondPokemon == "eevee2") || (firstPokemon == "eevee2" && secondPokemon == "eevee1")){
                    eevee1.clearAnimation();
                    eevee2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    eevee1.setVisibility(View.INVISIBLE);
                    eevee2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;
                    matchedPokemon.add(firstPokemon);
                    matchedPokemon.add(secondPokemon);
                }
                // Ditto
                else if((firstPokemon == "ditto1" && secondPokemon == "ditto2") || (firstPokemon == "ditto2" && secondPokemon == "ditto1")){
                    ditto1.clearAnimation();
                    ditto2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    ditto1.setVisibility(View.INVISIBLE);
                    ditto2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Jigglypuff
                else if((firstPokemon == "jigglypuff1" && secondPokemon == "jigglypuff2") || (firstPokemon == "jigglypuff2" && secondPokemon == "jigglypuff1")){
                    jigglypuff1.clearAnimation();
                    jigglypuff2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    jigglypuff1.setVisibility(View.INVISIBLE);
                    jigglypuff2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Mew
                else if((firstPokemon == "mew1" && secondPokemon == "mew2") || (firstPokemon == "mew2" && secondPokemon == "mew1")){
                    mew1.clearAnimation();
                    mew2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    mew1.setVisibility(View.INVISIBLE);
                    mew2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Mewtwo
                else if((firstPokemon == "mewtwo1" && secondPokemon == "mewtwo2") || (firstPokemon == "mewtwo2" && secondPokemon == "mewtwo1")){
                    mewtwo1.clearAnimation();
                    mewtwo2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    mewtwo1.setVisibility(View.INVISIBLE);
                    mewtwo2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Ninetales
                else if((firstPokemon == "ninetales1" && secondPokemon == "ninetales2") || (firstPokemon == "ninetales2" && secondPokemon == "ninetales1")){
                    ninetales1.clearAnimation();
                    ninetales2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    ninetales1.setVisibility(View.INVISIBLE);
                    ninetales2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Pikachu
                else if((firstPokemon == "pikachu1" && secondPokemon == "pikachu2") || (firstPokemon == "pikachu2" && secondPokemon == "pikachu1")){
                    pikachu1.clearAnimation();
                    pikachu2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    pikachu1.setVisibility(View.INVISIBLE);
                    pikachu2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Psyduck
                else if((firstPokemon == "psyduck1" && secondPokemon == "psyduck2") || (firstPokemon == "psyduck2" && secondPokemon == "psyduck1")){
                    psyduck1.clearAnimation();
                    psyduck2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    psyduck1.setVisibility(View.INVISIBLE);
                    psyduck2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Slowpoke
                else if((firstPokemon == "slowpoke1" && secondPokemon == "slowpoke2") || (firstPokemon == "slowpoke2" && secondPokemon == "slowpoke1")){
                    slowpoke1.clearAnimation();
                    slowpoke2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    slowpoke1.setVisibility(View.INVISIBLE);
                    slowpoke2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                // Togepi
                else if((firstPokemon == "togepi1" && secondPokemon == "togepi2") || (firstPokemon == "togepi2" && secondPokemon == "togepi1")){
                    togepi1.clearAnimation();
                    togepi2.clearAnimation();
                    pointCounter++;
                    points.setText(String.valueOf(pointCounter));
                    togepi1.setVisibility(View.INVISIBLE);
                    togepi2.setVisibility(View.INVISIBLE);
                    clickCounter = 0;

                }
                else{ // hide unmatched pokemon
                    hidePokemon(firstPokemon, secondPokemon);
                }

            }

        // Flip both pokemon if they're not a match
    public void hidePokemon(String firstPokemon, String secondPokemon){
            if(firstPokemon == "eevee1" || secondPokemon == "eevee1"){
                eevee1.setImageResource(android.R.color.transparent);
                eevee1.clearAnimation();
            }
            if(firstPokemon == "eevee2" || secondPokemon == "eevee2"){
                eevee2.setImageResource(android.R.color.transparent);
                eevee2.clearAnimation();
            }
            if(firstPokemon == "ditto1" || secondPokemon == "ditto1"){
                ditto1.setImageResource(android.R.color.transparent);
                ditto1.clearAnimation();
            }
            if(firstPokemon == "ditto2" || secondPokemon == "ditto2"){
                ditto2.setImageResource(android.R.color.transparent);
                ditto2.clearAnimation();
            }
            if(firstPokemon == "jigglypuff1" || secondPokemon == "jigglypuff2"){
                jigglypuff1.setImageResource(android.R.color.transparent);
                jigglypuff1.clearAnimation();
            }
            if(firstPokemon == "jigglypuff2" || secondPokemon == "jigglypuff2"){
                jigglypuff2.setImageResource(android.R.color.transparent);
                jigglypuff2.clearAnimation();
            }
            if(firstPokemon == "mew1" || secondPokemon == "mew1"){
                mew1.setImageResource(android.R.color.transparent);
                mew1.clearAnimation();
            }
            if(firstPokemon == "mew2" || secondPokemon == "mew2"){
                mew2.setImageResource(android.R.color.transparent);
                mew2.clearAnimation();
            }
            if(firstPokemon == "mewtwo1" || secondPokemon == "mewtwo1"){
                mewtwo1.setImageResource(android.R.color.transparent);
                mewtwo1.clearAnimation();
            }
            if(firstPokemon == "mewtwo2" || secondPokemon == "mewtwo2"){
                mewtwo2.setImageResource(android.R.color.transparent);
                mewtwo2.clearAnimation();
            }
            if(firstPokemon == "ninetales1" || secondPokemon == "ninetales1"){
                ninetales1.setImageResource(android.R.color.transparent);
                ninetales1.clearAnimation();
            }
            if(firstPokemon == "ninetales2" || secondPokemon == "ninetales2"){
                ninetales2.setImageResource(android.R.color.transparent);
                ninetales2.clearAnimation();
            }
            if(firstPokemon == "pikachu1" || secondPokemon == "pikachu1"){
                pikachu1.setImageResource(android.R.color.transparent);
                pikachu1.clearAnimation();
            }
            if(firstPokemon == "pikachu2" || secondPokemon == "pikachu2"){
                pikachu2.setImageResource(android.R.color.transparent);
                pikachu2.clearAnimation();
            }
            if(firstPokemon == "psyduck1" || secondPokemon == "psyduck1"){
                psyduck1.setImageResource(android.R.color.transparent);
                psyduck1.clearAnimation();
            }
            if(firstPokemon == "psyduck2" || secondPokemon == "psyduck2"){
                psyduck2.setImageResource(android.R.color.transparent);
                psyduck2.clearAnimation();
            }
            if(firstPokemon == "slowpoke1" || secondPokemon == "slowpoke1"){
                slowpoke1.setImageResource(android.R.color.transparent);
                slowpoke1.clearAnimation();
            }
            if(firstPokemon == "slowpoke2" || secondPokemon == "slowpoke2"){
                slowpoke2.setImageResource(android.R.color.transparent);
                slowpoke2.clearAnimation();
            }
            if(firstPokemon == "togepi1" || secondPokemon == "togepi1"){
                togepi1.setImageResource(android.R.color.transparent);
                togepi1.clearAnimation();
            }
            if(firstPokemon == "togepi2" || secondPokemon == "togepi2"){
                togepi2.setImageResource(android.R.color.transparent);
                togepi2.clearAnimation();
            }
        }



    // Save pokemon
    public void flipOver(String firstPokemon){
        if(firstPokemon == "eevee1" || secondPokemon == "eevee1"){
            eevee1.setVisibility(View.INVISIBLE);
        }
        if(firstPokemon == "eevee2" || secondPokemon == "eevee2"){
            eevee2.setVisibility(View.INVISIBLE);
        }
        if(firstPokemon == "ditto1" || secondPokemon == "ditto1"){
            ditto1.setVisibility(View.INVISIBLE);
        }
        if(firstPokemon == "ditto2" || secondPokemon == "ditto2"){
            ditto2.setVisibility(View.INVISIBLE);
        }
    }

    }


