package com.example.desapego.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.desapego.R;
import com.example.desapego.model.Anuncio;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class DetalhesProdutosActivity extends AppCompatActivity {

    private CarouselView carouselView;
    private TextView titulo;
    private TextView descricao;
    private TextView estado;
    private Anuncio anuncioSelecionado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_produtos);

        inicializarComponente();

        anuncioSelecionado = ( Anuncio) getIntent().getSerializableExtra("anuncioSelecionado");

        if (anuncioSelecionado != null){
            titulo.setText(anuncioSelecionado.getTitulo());
            descricao.setText(anuncioSelecionado.getDescricao());
            estado.setText(anuncioSelecionado.getEstado());

            ImageListener imageListener = new ImageListener() {
                @Override
                public void setImageForPosition(int position, ImageView imageView) {
                    String urlString = anuncioSelecionado.getFotos().get(position);
                    Picasso.get().load(urlString).into(imageView);


                }
            };

            carouselView.setPageCount(anuncioSelecionado.getFotos().size());
            carouselView.setImageListener(imageListener);

        }
    }

    private void inicializarComponente() {
        carouselView = findViewById(R.id.carouselView);
        titulo = findViewById(R.id.textTituloDetalhe);
        descricao = findViewById(R.id.textDescricaoDetalhe);
        estado = findViewById(R.id.textEstadoDetalhe);
    }
}
