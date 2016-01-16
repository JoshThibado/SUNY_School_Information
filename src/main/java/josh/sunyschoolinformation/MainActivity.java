package josh.sunyschoolinformation;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<sCampus> campuses;
    ListView lvcampuses;
    ListView lvcolheader;

    void preparedatacvs() {

        //for now I hardcode a couple campus information,
        //we want to read them from a sqlite table
        campuses = new ArrayList();

        try {
            InputStreamReader is = new InputStreamReader(getAssets().open("campuslist.csv"));

            BufferedReader reader = new BufferedReader(is);
            int count = 1;
            String line;
            String [] fields;

            while((line = reader.readLine()) != null)
            {
                fields=line.split(",");
                campuses.add(new sCampus(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7],fields[8], ("suny" + Integer.toString(count))));

                //while(count <=4){
                    count++;
                //}

            }
            is.close();
        }
        catch (Exception e)
        {

        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);  // you can comment this out to see the difference.

        setContentView(R.layout.activity_main);

        preparedatacvs();

        lvcampuses = (ListView) findViewById( R.id.list_campuses);

        lvcampuses.setAdapter(new sunyCampusAdapter(this, campuses));

        lvcampuses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                Intent intent = new Intent(MainActivity.this, showCampusDetails.class);

                intent.putExtra("cname", campuses.get(position).cname);
                intent.putExtra("mascot", campuses.get(position).mascot);
                intent.putExtra("students", campuses.get(position).students);
                intent.putExtra("cost", campuses.get(position).cost);
                intent.putExtra("year", campuses.get(position).year);
                intent.putExtra("imgname", campuses.get(position).img_name);
                intent.putExtra("motto", campuses.get(position).motto);
                intent.putExtra("address", campuses.get(position).address);
                intent.putExtra("city", campuses.get(position).city);


                startActivity(intent);
            }
        });

        lvcolheader = (ListView) findViewById( R.id.header);
        HashMap<String, String> headermap=new HashMap<String, String>();
        headermap.put("f1", "Logo");
        headermap.put("f2", "CName");
        headermap.put("f3", "Mascot");
        headermap.put("f4", "Students");
        headermap.put("f5", "Cost");
        headermap.put("f6", "Year");

        ArrayList<HashMap<String, String>> headerlist=new ArrayList<HashMap<String, String>>();
        headerlist.add(headermap);

        SimpleAdapter headeradapter =null;

        headeradapter=new SimpleAdapter(this, headerlist,R.layout.header, new String[]{"f1", "f2"},new int[]{R.id.cname});

        lvcolheader.setAdapter(headeradapter);

    }


}