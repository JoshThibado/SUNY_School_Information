package josh.sunyschoolinformation;

/**
 * Created by Josh on 11/4/2015.
 */


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Field;

public class showCampusDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        //String message = intent.getStringExtra("EXTRA_MESSAGE");

        String cname = intent.getStringExtra("cname");
        String mascot = intent.getStringExtra("mascot");
        String students = intent.getStringExtra("students");
        String cost = intent.getStringExtra("cost");
        String year = intent.getStringExtra("year");
        String imgname = intent.getStringExtra("imgname");
        String motto = intent.getStringExtra("motto");
        String address = intent.getStringExtra("address");
        String city = intent.getStringExtra("city");

        // School name title
        TextView schoolname = new TextView(this);
        schoolname.setTextSize(30);
        schoolname.setTextColor(Color.parseColor("#4f4f4f"));
        schoolname.setBackgroundColor(Color.parseColor("#FFFFFF"));
        schoolname.setTypeface(null, Typeface.BOLD);
        schoolname.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        schoolname.setText("SUNY " + cname);

        //Info on specific school
        TextView info = new TextView(this);
        info.setTextSize(20);
        info.setTextColor(Color.parseColor("#6c6c6c"));
        info.setBackgroundColor(Color.parseColor("#FFFFFF"));
        info.setText("Mascot: " + mascot + "\n\nEnrolled: " + students + " Students" + "\n\nCost: $" + cost + " Per year\n\n" + "Year founded: " + year + "\n");

        //Extra info
        TextView extra = new TextView(this);
        extra.setTextSize(20);
        extra.setTextColor(Color.parseColor("#6c6c6c"));
        extra.setBackgroundColor(Color.parseColor("#FFFFFF"));
        extra.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        extra.setText("Motto\n" + motto + "\n\nAddress:\n" + address + "\n" + city + "\n");


        //Link to suny website
        TextView link = new TextView(this);
        link.setTextSize(20);
        link.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        link.setBackgroundColor(Color.parseColor("#FFFFFF"));

        String linkText = "<a href='http://suny.edu'>Official Website</a>";

        link.setText(Html.fromHtml(linkText));
        link.setMovementMethod(LinkMovementMethod.getInstance());


        //Image of logo
        int myImgId = getResources().getIdentifier(imgname, "drawable", getPackageName());
        ImageView img = new ImageView(this);
        img.setImageResource(myImgId);//R.drawable.myImgId);


        //HardCoded linear layout to combine School title, info, and httpLink
        LinearLayout linear = new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);
        linear.addView(schoolname);
        linear.addView(img);
        linear.addView(info);
        linear.addView(extra);
        linear.addView(link);

        linear.setBackgroundColor(Color.parseColor("#FFFFFF"));

        //Scrollview includes linear layouy of stuff above
        ScrollView sv = new ScrollView(this);
        sv.addView(linear);

        // Set the text view as the activity layout
        setContentView(sv);

        //certainly you can retrieve more variables similarly.
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle app bar item clicks here. The app bar
        // automatically handles clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}