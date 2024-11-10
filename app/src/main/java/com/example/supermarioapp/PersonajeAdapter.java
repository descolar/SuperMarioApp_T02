package com.example.supermarioapp;

// Importamos las clases necesarias
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/**
 * Adaptador para el RecyclerView que se encarga de mostrar una lista de personajes
 * en formato de tarjetas (CardView).
 */
public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder> {

    // Lista de personajes a mostrar en el RecyclerView
    private List<Personaje> personajes;
    // Contexto de la aplicación, necesario para inflar los elementos de la lista
    private Context context;

    /**
     * Constructor del adaptador que recibe la lista de personajes y el contexto.
     *
     * @param personajes Lista de objetos Personaje que vamos a mostrar en el RecyclerView.
     * @param context    Contexto de la actividad o fragmento donde se mostrará la lista.
     */
    public PersonajeAdapter(List<Personaje> personajes, Context context) {
        this.personajes = personajes;
        this.context = context;
    }

    /**
     * Crea una nueva vista para un elemento de la lista (llamada cada vez que
     * necesitemos una nueva tarjeta de personaje).
     *
     * @param parent   El ViewGroup al que esta vista nueva será añadida.
     * @param viewType Tipo de vista (en este caso solo tenemos un tipo).
     * @return Un nuevo PersonajeViewHolder con la vista inflada del diseño item_personaje.
     */
    @NonNull
    @Override
    public PersonajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el diseño de cada elemento de la lista
        View view = LayoutInflater.from(context).inflate(R.layout.item_personaje, parent, false);
        return new PersonajeViewHolder(view);
    }

    /**
     * Enlaza los datos de un personaje con su tarjeta de vista (CardView).
     * Se llama cada vez que un elemento de la lista es visible.
     *
     * @param holder   El ViewHolder que contiene las vistas para el personaje.
     * @param position Posición del personaje en la lista de personajes.
     */
    @Override
    public void onBindViewHolder(@NonNull PersonajeViewHolder holder, int position) {
        // Obtenemos el personaje en la posición actual
        Personaje personaje = personajes.get(position);
        // Configuramos el nombre y la imagen del personaje en su tarjeta
        holder.textViewNombre.setText(personaje.getNombre());
        holder.imageViewPersonaje.setImageResource(personaje.getImagenResId());

        // Configuramos un listener para abrir la actividad de detalles al hacer clic
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, PersonajeDetalleActivity.class);
            intent.putExtra("nombre", personaje.getNombre());
            intent.putExtra("imagen", personaje.getImagenResId());
            intent.putExtra("descripcion", personaje.getDescripcion());
            intent.putExtra("habilidades", personaje.getHabilidades());
            context.startActivity(intent);
        });
    }

    /**
     * Devuelve el número total de elementos en la lista de personajes.
     *
     * @return Cantidad de personajes en la lista.
     */
    @Override
    public int getItemCount() {
        return personajes.size();
    }

    /**
     * ViewHolder interno que representa y administra las vistas de cada personaje en la lista.
     */
    public class PersonajeViewHolder extends RecyclerView.ViewHolder {
        // ImageView para mostrar la imagen del personaje
        ImageView imageViewPersonaje;
        // TextView para mostrar el nombre del personaje
        TextView textViewNombre;

        /**
         * Constructor del ViewHolder. Conecta las vistas de imagen y texto
         * del diseño con las variables del ViewHolder.
         *
         * @param itemView Vista del elemento (tarjeta de personaje) inflado.
         */
        public PersonajeViewHolder(@NonNull View itemView) {
            super(itemView);
            // Asignamos la vista de la imagen del personaje
            imageViewPersonaje = itemView.findViewById(R.id.imageViewPersonaje);
            // Asignamos la vista del nombre del personaje
            textViewNombre = itemView.findViewById(R.id.textViewNombre);
        }
    }
}
