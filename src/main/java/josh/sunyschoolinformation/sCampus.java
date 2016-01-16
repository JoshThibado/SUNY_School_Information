package josh.sunyschoolinformation;

/**
 * Created by Josh on 11/4/2015.
 */
public class sCampus{

    public final static String CID="cid";
    public final static String CNAME="cname";
    public final static String MASCOT="mascot";
    public final static String COST="cost";
    public final static String STUDENTS="students";
    public final static String YEAR="year";
    public final static String IMG_NAME="imgname";
    public final static String TABLENAME="campus";

    public String cid;
    public String cname;
    public String mascot;
    public String students;
    public String cost;
    public String year;
    public String motto;
    public String address;
    public String city;
    public String img_name; //url will need more work, we will try that about that later.


    //constructor
    public sCampus(String p_cid, String p_cname, String p_mascot, String p_students, String p_cost, String p_year, String p_motto,String p_address,String p_city, String p_img_name) {
        cid = p_cid;
        cname=p_cname;
        mascot=p_mascot;
        students=p_students;
        cost=p_cost;
        year=p_year;
        motto=p_motto;
        address=p_address;
        city=p_city;
        img_name = p_img_name;
    }


}
