package com.arm.satornjanac.esspressotestsexamples;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class FormActivity extends Activity {

    private boolean mInShowRequests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fm = getFragmentManager();
        Fragment f = fm.findFragmentByTag(FormActivityFragment.TAG);
        if (f == null) {
            FormActivityFragment fragment = FormActivityFragment.newInstance();
            FragmentTransaction fragmentTransaction = fm.beginTransaction();
            fragmentTransaction.replace(android.R.id.content, fragment, FormActivityFragment.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_show_requests) {
            FragmentManager fm = getFragmentManager();
            Fragment f = fm.findFragmentByTag(RequestFragment.TAG);
            if (f == null) {
                RequestFragment fragment = RequestFragment.newInstance();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment, RequestFragment.TAG);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                mInShowRequests = true;
            }
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
