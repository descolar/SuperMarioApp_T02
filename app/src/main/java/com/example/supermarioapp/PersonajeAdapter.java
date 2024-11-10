package com.example.supermarioapp;

// Importamos las clases necesarias
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.content.Intent;


// Esta clase es el adaptador para el RecyclerView que mostrará los personajes
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    // Lista de personajes a mostrar en el RecyclerView
    private List<Personaje> personajes;
    // Contexto de la aplicación, necesario para inflar el diseño de los elementos
    private Context context;

    // Constructor de la clase que recibe la lista de personajes y el contexto
    public PersonajeAdapter(List<Personaje> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    // Método llamado cuando necesitamos crear una nueva vista para un elemento de la lista
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el diseño de cada item de la lista (item_personaje.xml)
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        // Creamos un ViewHolder para manejar la vista de este elemento y lo retornamos
        return new PersonajeViewHolder(view);
    }

    // Método que enlaza los datos de un personaje con su vista (CardView)
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        Personaje personaje = personajes.get(position);
        holder.textViewNombre.setText(personaje.getNombre());
        holder.imageViewPersonaje.setImageResource(personaje.getImagenResId());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PersonajeDetalleActivity.class);
            intent.putExtra("nombre", personaje.getNombre());
            intent.putExtra("imagen", personaje.getImagenResId());
            intent.putExtra("descripcion", personaje.getDescripcion());
            intent.putExtra("habilidades", personaje.getHabilidades());
            context.startActivity(intent);
        });
    }



    // Método que devuelve el número total de elementos en la lista de personajes
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    // ViewHolder interno que define y maneja las vistas de cada elemento (nombre e imagen)
    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        // ImageView para la imagen del personaje
        ImageView imageViewPersonaje;
        // TextView para el nombre del personaje
        TextView textViewNombre;

        // Constructor del ViewHolder, donde conectamos los elementos del diseño
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            // Encontramos la vista de la imagen en el diseño y la asignamos a imageViewPersonaje
            imageViewPersonaje = itemView.findViewById(R.id.imageViewPersonaje);
            // Encontramos la vista del texto en el diseño y la asignamos a textViewNombre
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
        }
    }
}
