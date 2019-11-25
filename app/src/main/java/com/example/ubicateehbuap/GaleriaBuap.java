package com.example.ubicateehbuap;

import android.net.Uri;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GaleriaBuap extends AppCompatActivity implements FragmentAdmin.OnFragmentInteractionListener,FragmentCompu.OnFragmentInteractionListener,
FragmentMate.OnFragmentInteractionListener{
    FragmentMate fragmentMate;
    FragmentAdmin fragmentAdmin;
    FragmentCompu fragmentCompu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_galeria_buap);

        fragmentAdmin = new FragmentAdmin ();
        fragmentCompu = new FragmentCompu ();
        fragmentMate = new FragmentMate ();
        getSupportFragmentManager ().beginTransaction ().add(R.id.contenedorFragments1,fragmentCompu).commit ();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void onClick(View view) {
        FragmentTransaction Transaction = getSupportFragmentManager ().beginTransaction ();
        switch (view.getId ()){
            case R.id.btncompu1:
                Transaction.replace(R.id.contenedorFragments1,fragmentCompu);
                break;
            case R.id.btnAdmin1:
                Transaction.replace(R.id.contenedorFragments1,fragmentAdmin);
                break;
            case R.id.btnMate1:
                Transaction.replace(R.id.contenedorFragments1,fragmentMate);
                break;
        }
        Transaction .commit ();
    }
}
