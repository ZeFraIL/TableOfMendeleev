package zeev.fraiman.tableofmendeleev;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import zeev.fraiman.tableofmendeleev.Element;

public class ElementAdapter extends RecyclerView.Adapter<ElementAdapter.ElementViewHolder> {
    private List<Element> elements = new ArrayList<>();

    public static class ElementViewHolder extends RecyclerView.ViewHolder {
        public TextView symbolText;
        public TextView nameText;
        public TextView numberText;
        public TextView massText;
        public TextView categoryText;
        public TextView phaseText;

        public ElementViewHolder(View itemView) {
            super(itemView);
            symbolText = itemView.findViewById(R.id.symbolText);
            nameText = itemView.findViewById(R.id.nameText);
            numberText = itemView.findViewById(R.id.numberText);
            massText = itemView.findViewById(R.id.massText);
            //categoryText = itemView.findViewById(R.id.categoryText);
            //phaseText = itemView.findViewById(R.id.phaseText);
        }
    }

    @NonNull
    @Override
    public ElementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.element_item, parent, false);
        return new ElementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ElementViewHolder holder, int position) {
        Element element = elements.get(position);
        holder.symbolText.setText(element.getSymbol());
        holder.nameText.setText(element.getName());
        holder.numberText.setText(""+element.getNumber());
        holder.massText.setText(""+element.getAtomic_mass());
        //holder.categoryText.setText(element.getCategory());
        //holder.phaseText.setText(element.getPhase());
    }

    @Override
    public int getItemCount() {
        return elements.size();
    }

    public void updateElements(List<Element> newElements) {
        this.elements = newElements;
        notifyDataSetChanged();
    }
}