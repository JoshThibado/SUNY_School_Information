package josh.sunyschoolinformation;

/**
 * Created by Josh on 11/4/2015.
 */
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import java.util.List;


public class sunyCampusAdapter extends ArrayAdapter<sCampus>{

    List<sCampus> mylist;
    Context c;

    public sunyCampusAdapter(Context _context, List<sCampus> _mylist) {
        super(_context, R.layout.list_item_campus, _mylist);
        c=_context;

        this.mylist = _mylist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = new LinearLayout(getContext());
        String inflater = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater vi = (LayoutInflater)getContext().getSystemService(inflater);
        convertView = vi.inflate(R.layout.list_item_campus, parent, false);

        sCampus sc = getItem(position);
        TextView txtcname = (TextView) convertView.findViewById(R.id.cname);
        txtcname.setBackgroundColor(0x00000000);
        txtcname.setText(sc.cname);

        // show image
        ImageView img = (ImageView)convertView.findViewById(R.id.logoimage);
        img.setImageResource(c.getResources().getIdentifier(sc.img_name,"drawable","josh.sunyschoolinformation"));

        return convertView;
    }


}