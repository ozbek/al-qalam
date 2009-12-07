package com.uzislam.alqalam;

import android.graphics.drawable.Drawable;

public class AyatIconifiedText {
	private long		id = -1 ;
	private int			ayatOrder = 0;
	private String	ayatArabicText = null;
	private String		ayatUzbekText = null;
	private Drawable	ayatBismillah = null;
	private Drawable	ayatSpecialImage = null;
	private Boolean		ayatBookmarked = false;
		
	public AyatIconifiedText(long _id, int _order, String _arabic, String _uzbek, Drawable _spimage, Drawable _bismillah, boolean _isBookmarked) {
		this.id = _id;
		this.ayatOrder = _order;
		this.ayatArabicText = _arabic;
		this.ayatUzbekText = _uzbek;
		this.ayatBismillah  = _bismillah;
		this.ayatBookmarked = _isBookmarked;
		this.ayatSpecialImage = _spimage;
	}
	
	public long getId () {
		return this.id;
	}
	
	public int getAyatOrder() {
		return this.ayatOrder;
	}
	
	public String getAyatUzbekText() {
		return this.ayatUzbekText ;
	}
	
	public String getAyatArabicText() {
		return this.ayatArabicText ;
	}
	
	public Drawable getAyatBismillah() {
		return this.ayatBismillah ;
	}

	public Drawable getAyatSpecialImage() {
		return this.ayatSpecialImage;
	}
	
	public Boolean getAyatBookmarked() {
		return this.ayatBookmarked;
	}
	
}
