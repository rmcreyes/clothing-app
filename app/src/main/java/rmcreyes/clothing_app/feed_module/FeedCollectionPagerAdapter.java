package rmcreyes.clothing_app.feed_module;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import rmcreyes.clothing_app.signin_module.ForgotPasswordFragment;
import rmcreyes.clothing_app.signin_module.TermsFragment;

/**
 * Created by robin on 2018-05-16.
 * taken from the android developers tutorial at
 * https://developer.android.com/training/implementing-navigation/lateral
 */

public class FeedCollectionPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> FragmentList;

    public FeedCollectionPagerAdapter(FragmentManager fm) {
        super(fm);
        FragmentList = new ArrayList<Fragment>();

        FragmentList.add(new TermsFragment());
        FragmentList.add(new ForgotPasswordFragment());
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new TermsFragment();
        }
        else
            return new ForgotPasswordFragment();
    }


    @Override
    public int getCount() {
        return FragmentList.size();
    }

}
