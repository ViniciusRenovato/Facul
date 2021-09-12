package br.unigran.aula;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.CameraMetadata;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import br.unigran.crud.Dados;
import br.unigran.domain.Contato;

public class Segunda extends AppCompatActivity {

    private EditText nomeCont;
    private EditText numTel;
    private EditText emailCont;
    private EditText enderecoCont;
    private ImageView foto;
    Contato contato;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
        nomeCont=findViewById(R.id.nomeContato);
        numTel=findViewById(R.id.numTelefone);
        emailCont=findViewById(R.id.emailContato);
        enderecoCont=findViewById(R.id.enderecoContato);
        foto=findViewById(R.id.imagem);
        Intent it = getIntent();

    // falta mexer aqui o \/

        if(it.getSerializableExtra("Contato")!=null){
            contato = (Contato) it.getSerializableExtra("Contato");
            nomeCont.setText(contato.getNome());
            numTel.setText(contato.getNumTelefone());
            emailCont.setText(contato.getEmailContato());
            enderecoCont.setText(contato.getEnderecoContato());
            if(contato.getImagem()!=null)
                foto.setImageBitmap(BitmapFactory.
                        decodeByteArray(contato.getImagem(),0, contato.getImagem().length));
        }else{
            contato = new Contato();
        }
    }
    public void cancelar(View view){
        setResult(RESULT_CANCELED);
        //finish();
        onBackPressed();
    }
    public void salvar(View view){

        contato.setNome(nomeCont.getText().toString());
        contato.setNumTelefone(numTel.getText().toString());
        contato.setEmailContato(emailCont.getText().toString());
        contato.setEnderecoContato(enderecoCont.getText().toString());
        Dados.salvar(contato);
        setResult(RESULT_OK);
        finish();
        //onBackPressed();
    }

    public void capturaImg(View view){
        Intent it = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(it.resolveActivity(getPackageManager())!=null)
            startActivityForResult(it, CameraMetadata.REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CameraMetadata.REQUEST_AVAILABLE_CAPABILITIES_BACKWARD_COMPATIBLE){
            if(resultCode==RESULT_OK){
                Bitmap img= (Bitmap) data.getExtras().get("data");

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                img.compress(Bitmap.CompressFormat.PNG,100,stream);
                contato.setImagem(stream.toByteArray());
                foto.setImageBitmap(img);


            }

        }
    }
}