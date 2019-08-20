package br.ici.treinamento.aprendaingles.Fragments;


import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import br.ici.treinamento.aprendaingles.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BichosFragment extends Fragment implements View.OnClickListener {

    private ImageButton buttonCao;
    private ImageButton buttonGato;
    private ImageButton buttonLeao;
    private ImageButton buttonMacaco;
    private ImageButton buttonOvelha;
    private ImageButton buttonVaca;

    private MediaPlayer mediaPlayer;


    public BichosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bichos, container, false);

        buttonCao = view.findViewById(R.id.ibCao);
        buttonGato = view.findViewById(R.id.ibGato);
        buttonLeao = view.findViewById(R.id.ibLeao);
        buttonMacaco = view.findViewById(R.id.ibMacaco);
        buttonOvelha = view.findViewById(R.id.ibOvelha);
        buttonVaca = view.findViewById(R.id.ibVaca);

        buttonCao.setOnClickListener(this );
        buttonGato.setOnClickListener(this );
        buttonLeao.setOnClickListener(this );
        buttonMacaco.setOnClickListener(this );
        buttonOvelha.setOnClickListener(this );
        buttonVaca.setOnClickListener(this );

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){

            case R.id.ibCao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.dog);
                tocarSom();
                break;
            case R.id.ibGato:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cat);
                tocarSom();
                break;
            case R.id.ibLeao:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.lion);
                tocarSom();
                break;
            case R.id.ibMacaco:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.monkey);
                tocarSom();
                break;
            case R.id.ibOvelha:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.sheep);
                tocarSom();
                break;
            case R.id.ibVaca:
                mediaPlayer = MediaPlayer.create(getActivity(),R.raw.cow);
                tocarSom();
                break;

        }

    }

    public void tocarSom(){
        if(mediaPlayer!=null){
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    mediaPlayer.release();
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer!=null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
