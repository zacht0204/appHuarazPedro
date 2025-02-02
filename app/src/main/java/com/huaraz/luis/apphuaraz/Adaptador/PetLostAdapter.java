package com.huaraz.luis.apphuaraz.Adaptador;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.huaraz.luis.apphuaraz.Model.PetLost;
import com.huaraz.luis.apphuaraz.R;

import java.util.List;

/**
 * Created by java on 07/12/2016.
 */

public class PetLostAdapter extends ArrayAdapter<PetLost> {

    public List<PetLost> list;

    public PetLostAdapter(Context context, List<PetLost> objects) {
        super(context, 0, objects);
        list = objects;
    }

    @Override
    public PetLost getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtener inflater.
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder holder;

        // ¿Existe el view actual?
        if (null == convertView) {
            convertView = inflater.inflate(
                    R.layout.lista_lost_pets,
                    parent,
                    false);


        holder = new ViewHolder();
        holder.photo = (ImageView) convertView.findViewById(R.id.petPhoto);
        holder.name_pet = (TextView) convertView.findViewById(R.id.petName);
        holder.info_pet = (TextView) convertView.findViewById(R.id.petInfo);

        convertView.setTag(holder);
        }else{
            holder= (ViewHolder)convertView.getTag();
        }

        // Lead actual.
        PetLost petlost = getItem(position);

        // Configuracion
        String foto=petlost.getPet().getPicture();
        if(foto!=null){
            // Receiving side
            byte[] data1 = Base64.decode(foto, Base64.DEFAULT);
            String text1 = null;
            try {
                Bitmap bitmap = BitmapFactory.decodeByteArray(data1, 0, data1.length);
                holder.photo.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        /*
        Picasso.with(getContext())
                .load("http://findmewebapp-eberttoribioupc.c9.io/system/pets/photos/000/000/0"+petlost.getPet().getId()+"/thumb/"+petlost.getPet().getPhotoFileName())
                .resize(120, 120)
                .into( holder.photo);*/

        holder.name_pet.setText(petlost.getPet().getName());
        holder.info_pet.setText(petlost.getInfo());
     /*
        holder.sal_disp.setText(cuenta.getSaldo());
        holder.fecha_aper.setText(cuenta.getFechaApertura());
        holder.fecha_ult.setText(cuenta.getFechaUltimoMovimiento());
        holder.est_cuenta.setText(cuenta.getEstado());*/


        return convertView;
    }

    static class ViewHolder {

        ImageView photo;
        TextView name_pet;
        TextView info_pet;

    }
}
