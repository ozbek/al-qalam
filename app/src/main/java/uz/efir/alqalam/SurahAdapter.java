/*
 * Copyright 2012 (c) Al-Qalam Project
 *
 * This file is part of Al-Qalam (uz.efir.alqalam) package.
 *
 * Al-Qalam is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * Al-Qalam is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package uz.efir.alqalam;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SurahAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<AyatIconifiedText> mItems = new ArrayList<AyatIconifiedText>();
    public SurahAdapter(Context context) {
        mContext = context;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mItems.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return mItems.get(arg0).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vHolder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.surah_row, null);

            vHolder = new ViewHolder();
            vHolder.AyatRoot = (LinearLayout) convertView.findViewById(R.id.ayatRoot);
            vHolder.AyatGroup = (LinearLayout) convertView.findViewById(R.id.ayatGroup);
            vHolder.AyatOrder = (TextView) convertView.findViewById(R.id.ayatOrder);
            vHolder.AyatBismillah = (ImageView)convertView.findViewById(R.id.ayatBismillah);
            vHolder.AyatUzbek = (TextView) convertView.findViewById(R.id.ayatTranslationText);
            vHolder.AyatArabic = (TextView) convertView.findViewById(R.id.ayatArabicText);
            // TODO: Enable users to select preferred font.
            Typeface tf = Typeface.createFromAsset(mContext.getAssets(), "me_quran_volt_newmet.ttf");
            vHolder.AyatArabic.setTypeface(tf);
            vHolder.AyatBookmarkImage = (ImageView) convertView.findViewById(R.id.ayatBookmarkImage);
            vHolder.AyatSpecialImage = (ImageView) convertView.findViewById(R.id.ayatSpecialImage);

            convertView.setTag(vHolder);
        } else {
            vHolder = (ViewHolder) convertView.getTag();
        }

        vHolder.AyatGroup.setBackgroundColor(mItems.get(position).getAyatBackground());
        vHolder.AyatOrder.setText(mItems.get(position).getAyatOrder() + "");
        vHolder.AyatUzbek.setText(mItems.get(position).getAyatUzbekText());
        vHolder.AyatArabic.setText(mItems.get(position).getAyatArabicText());
        vHolder.AyatRoot.setBackgroundColor((position % 2 == 0)
                ? Color.WHITE
                : mContext.getResources().getColor(R.color.light_blue));
        vHolder.AyatSpecialImage.setImageDrawable(mItems.get(position).getAyatSpecialImage());
        vHolder.AyatBismillah.setImageDrawable(mItems.get(position).getBismillahImage());
        vHolder.AyatBookmarkImage.setImageDrawable(mItems.get(position).getAyatBookmarkImage());

        return convertView;
    }

    private static class ViewHolder {
        TextView AyatOrder;
        ImageView AyatBismillah;
        TextView AyatArabic;
        TextView AyatUzbek;
        ImageView AyatSpecialImage;
        ImageView AyatBookmarkImage;
        LinearLayout AyatGroup;
        LinearLayout AyatRoot;
    }

    public void addItem(AyatIconifiedText it) {
        mItems.add(it);
    }

    public void clear() {
        mItems.clear();
    }
}