package jervincruz.homework2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class rulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText("RULES of the GAME:\n" +
                "\n" +
                "1. The user is shown 20 tiles. Hidden below these tiles are 10 random images (use your own) each repeated twice. \n" +
                "\n" +
                "2. The user can touch on any two tiles. Touching on a tile will show the image.\n" +
                "\n" +
                "3. If the two tiles have matching images, they disappear (Use a check or something to indicate it's already matched). The user gets a point. \n" +
                "\n" +
                "4. If the two tiles do NOT have matching images, they flip over to being tiles again (flip animation not required).\n" +
                "\n" +
                "5. Hitting the back soft key while playing will take the user back to the first screen (happens automatically). Trying to play should restore the playing activity to the previous state (may need some state handling). That is, if I hit back after matching say 10 tiles, and return to playing, it should show me the remaining 10 cards to match. ");
    }


}
