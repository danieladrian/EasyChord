package net.danieladrian.chordrepository.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.danieladrian.chordrepository.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PageHeader extends LinearLayout {

    @BindView(R.id.btnDefault) ImageView btnDefault;
    @BindView(R.id.btnAction1) ImageView btnAction1;
    @BindView(R.id.btnAction2) ImageView btnAction2;
    @BindView(R.id.pageTitle) TextView pageTitle;

    public PageHeader(Context context) {
        super(context);
        init();
    }

    public PageHeader(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        int reqAttrs[] = {android.R.attr.title};
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.PageHeader, 0, 0);
        TypedArray stdAttr = context.obtainStyledAttributes(attrs, reqAttrs);

        int defaultButtonVisibility = attributes.getInt(R.styleable.PageHeader_DefaultButtonVisibility, 0);
        int firstActionButtonVisibility = attributes.getInt(R.styleable.PageHeader_FirstActionButtonVisibility, 0);
        int secondActionButtonVisibility = attributes.getInt(R.styleable.PageHeader_SecondActionButtonVisibility, 0);

        setDefaultButtonVisibility(defaultButtonVisibility);
        setFirstActionButtonVisibility(firstActionButtonVisibility);
        setSecondActionButtonVisibility(secondActionButtonVisibility);

        Drawable iconDefault = attributes.getDrawable(R.styleable.PageHeader_DefaultButtonImage);
        Drawable iconFirst = attributes.getDrawable(R.styleable.PageHeader_FirstActionButtonImage);
        Drawable iconSecond = attributes.getDrawable(R.styleable.PageHeader_SecondActionButtonImage);

        setDefaultButtonImage(iconDefault);
        setFirstActionButtonImage(iconFirst);
        setSecondActionButtonImage(iconSecond);

        String textTitle = attributes.getString(R.styleable.PageHeader_Pagetitle);
        setPageTitle(textTitle);

        attributes.recycle();
        stdAttr.recycle();

    }

    public void setDefaultButtonVisibility(int state){
        if(state==0){
            btnDefault.setVisibility(GONE);
        }else{
            btnDefault.setVisibility(VISIBLE);
        }
    }

    public void setFirstActionButtonVisibility(int state){
        if(state==0){
            btnAction1.setVisibility(GONE);
        }else{
            btnAction1.setVisibility(VISIBLE);
        }
    }

    public void setSecondActionButtonVisibility(int state){
        if(state==0){
            btnAction2.setVisibility(GONE);
        }else{
            btnAction2.setVisibility(VISIBLE);
        }
    }

    public void setDefaultButtonVisibility(Boolean state){
        if(!state){
            btnDefault.setVisibility(GONE);
        }else{
            btnDefault.setVisibility(VISIBLE);
        }
    }

    public void setFirstActionButtonVisibility(Boolean state){
        if(!state){
            btnAction1.setVisibility(GONE);
        }else{
            btnAction1.setVisibility(VISIBLE);
        }
    }

    public void setSecondActionButtonVisibility(Boolean state){
        if(!state){
            btnAction2.setVisibility(GONE);
        }else{
            btnAction2.setVisibility(VISIBLE);
        }
    }

    public void setDefaultButtonImage(Drawable drawable){
        if(drawable!=null) {
            btnDefault.setImageDrawable(drawable);
        }
    }


    public void setFirstActionButtonImage(Drawable drawable){
        if(drawable!=null) {
            btnAction1.setImageDrawable(drawable);
        }
    }

    public void setSecondActionButtonImage(Drawable drawable){
        if(drawable!=null) {
            btnAction2.setImageDrawable(drawable);
        }
    }

    public void setPageTitle(String text){
        pageTitle.setText(text);
    }

    private void init(){
        inflate(getContext(), R.layout.page_header, this);
        ButterKnife.bind(this);
    }

}
