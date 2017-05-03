package com.example.alexsus.asyncwithfragments;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PlusThreeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class PlusThreeFragment extends Fragment implements View.OnClickListener {
    Button mExecuteAsync;
    EditText mEditMessage;
    AsyncTask simpleTask;

    private OnFragmentInteractionListener mListener;

    public PlusThreeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plus_three, container, false);
        mEditMessage = (EditText) view.findViewById(R.id.edit_message);
        mExecuteAsync = (Button) view.findViewById(R.id.execute_async);
        mExecuteAsync.setOnClickListener(this);

        return view;

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
        if (simpleTask != null)
            simpleTask.cancel(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.execute_async:
                simpleTask = new SimpleAsync(getActivity(), mEditMessage.getText().toString()).execute();
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onPlusThreeFragmentInteraction(String string);
    }
}
