package org.a20190206_eraldhaka_nycschools.util;

import android.os.Bundle;
import org.a20190206_eraldhaka_nycschools.ui.sat_scores.SATScoresActivity;

public class Utils {

    //String method which returns the data which is stored in Bundle

    public static String getValue(SATScoresActivity activity, Bundle savedInstanceState, String dbnParameter){
        String value;
        if (savedInstanceState == null) {
            Bundle extras = activity.getIntent().getExtras();
            if(extras == null) {
                value= null;
            } else {
                value= extras.getString(dbnParameter);
            }
        } else {
            value= (String) savedInstanceState.getSerializable(dbnParameter);
        }
        return value;
    }

    // comparing two strings

    public static boolean compare(String str1, String str2) {
        return (str1 == null ? str2 == null : str1.equals(str2));
    }

}
