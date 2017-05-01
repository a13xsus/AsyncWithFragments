package com.example.alexsus.asyncwithfragments;


import android.support.v4.app.Fragment;

public class PlaceholderFragment extends Fragment {

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static Fragment newInstance(int sectionNumber) {

        switch (sectionNumber) {
            case 1:
                return new PlusOneFragment();
            case 2:
                return new PlusTwoFragment();
            case 3:
                return new PlusThreeFragment();
            default:
                return null;
        }
    }
}