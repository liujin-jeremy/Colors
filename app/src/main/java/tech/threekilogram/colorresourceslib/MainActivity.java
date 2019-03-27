package tech.threekilogram.colorresourceslib;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import tech.threekilogram.colors.Colors;

public class MainActivity extends AppCompatActivity {

      private RecyclerView mRecycler;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_main );
            initView();
      }

      private void initView ( ) {

            mRecycler = findViewById( R.id.recycler );
            mRecycler.setLayoutManager( new GridLayoutManager( this, 2 ) );
            mRecycler.setAdapter( new Adapter() );
      }

      private class Holder extends RecyclerView.ViewHolder {

            public Holder ( @NonNull View itemView ) {

                  super( itemView );
            }

            private void bind ( int position ) {

                  itemView.setBackgroundColor( Colors.ALL[ position ] );
            }
      }

      private class Adapter extends RecyclerView.Adapter<Holder> {

            @NonNull
            @Override
            public Holder onCreateViewHolder ( @NonNull ViewGroup viewGroup, int i ) {

                  View view = new View( MainActivity.this );
                  view.setLayoutParams( new LayoutParams( LayoutParams.MATCH_PARENT, 200 ) );
                  return new Holder( view );
            }

            @Override
            public void onBindViewHolder ( @NonNull Holder holder, int i ) {

                  holder.bind( i );
            }

            @Override
            public int getItemCount ( ) {

                  return Colors.ALL.length;
            }
      }
}
