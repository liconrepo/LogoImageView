package com.licon.logo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by FRAMGIA\khairul.alam.licon on 25/3/16.
 */
public class LogoView extends RelativeLayout {

    private final Typeface DEFAULT_TYPEFACE = FontCollectionUtil.
            get(FontCollectionUtil.FONT_ROBOTO_REGULAR, getContext());
    private final float DEFAULT_LOGO_X = 0;
    private final float DEFAULT_LOGO_Y = 0;
    private RelativeLayout.LayoutParams mParams;
    private float mDefaultTS = 14;
    private TextView mTextView;
    private RelativeLayout mRelativeLayout;

    int sdk = android.os.Build.VERSION.SDK_INT;

    public LogoView(Context context) {
        super(context);
        init(context, null);
    }

    public LogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public LogoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LogoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.layout_lib_main, this, true);
        mTextView = (TextView) view.findViewById(R.id.text_view);
        mRelativeLayout = (RelativeLayout) view.findViewById(R.id.layout_root_lib);
        mParams = (RelativeLayout.LayoutParams) mTextView.getLayoutParams();

        if (attrs != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.AttrLogoView);
            try {
                String logo_tf_name = typedArray.getString(R.styleable.AttrLogoView_logoTypeface);
                String logo_text = typedArray.getString(R.styleable.AttrLogoView_logoText);
                int background_res_id = typedArray.getResourceId(R.styleable.AttrLogoView_backgroundDrawable, 0);
                int logo_res_id = typedArray.getResourceId(R.styleable.AttrLogoView_logoDrawable, 0);
                int parent_gravity = typedArray.getInteger(R.styleable.AttrLogoView_parentGravity, 0);
                float logo_text_size = typedArray.getDimension(R.styleable.AttrLogoView_logoTextSize, 0);
                float logo_pos_x = typedArray.getDimension(R.styleable.AttrLogoView_logoPositionX, 0);
                float logo_pos_y = typedArray.getDimension(R.styleable.AttrLogoView_logoPositionY, 0);
                float logo_height = typedArray.getDimension(R.styleable.AttrLogoView_logoHeight, 0);
                float logo_width = typedArray.getDimension(R.styleable.AttrLogoView_logoWidth, 0);
                float logo_margin_left = typedArray.getDimension(R.styleable.AttrLogoView_logoMarginLeft, 0);
                float logo_margin_top = typedArray.getDimension(R.styleable.AttrLogoView_logoMarginTop, 0);
                float logo_margin_right = typedArray.getDimension(R.styleable.AttrLogoView_logoMarginRight, 0);
                float logo_margin_bottom = typedArray.getDimension(R.styleable.AttrLogoView_logoMarginBottom, 0);

                ColorStateList logo_text_color = typedArray.getColorStateList(R.styleable.AttrLogoView_logoTextColor);
                ColorStateList logo_background_color = typedArray.getColorStateList(R.styleable.AttrLogoView_logoBackgroundColor);

                if (TextUtils.isEmpty(logo_tf_name)) {
                    setLogoTypeface(DEFAULT_TYPEFACE);
                } else {
                    setLogoTypeface(FontCollectionUtil.get(logo_tf_name, getContext()));
                }
                setLogoText(logo_text);
                setBackgroundDrawable(background_res_id);
                setLogoDrawable(logo_res_id);
                setLogoTextSize(logo_text_size);
                setLogoPositionX(logo_pos_x);
                setLogoPositionY(logo_pos_y);
                setLogoHeight(logo_height);
                setLogoWidth(logo_width);
                setLogoTextColor(logo_text_color);
                setLogoBackgroundColor(logo_background_color);
                setLogoMarginLeft(logo_margin_left);
                setLogoMarginTop(logo_margin_top);
                setLogoMarginRight(logo_margin_right);
                setLogoMarginBottom(logo_margin_bottom);
                setParentGravity(parent_gravity);
            } finally {
                typedArray.recycle();
            }
        }
    }

    public void setLogoTypeface(Typeface typeface) {
        if(typeface != null) {
            mTextView.setTypeface(typeface);
        }
    }

    public void setLogoText(String text) {
        mTextView.setText(TextUtils.isEmpty(text) ? "" : text);
    }

    public void setLogoTextSize(float text_size) {
        if(text_size > 0) {
            text_size = text_size / getResources().getDisplayMetrics().scaledDensity;
            mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, text_size);
        } else {
            mDefaultTS = mDefaultTS / getResources().getDisplayMetrics().scaledDensity;
            mTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, mDefaultTS);
        }
    }

    public void setBackgroundDrawable(int res_id) {
        if (res_id > 0) {
            Drawable drawable = getResources().getDrawable(res_id);
            addDrawable(mRelativeLayout, drawable);
        }
    }

    public void setLogoDrawable(int res_id) {
        if (res_id > 0) {
            Drawable drawable = getResources().getDrawable(res_id);
            addDrawable(mTextView, drawable);
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void addDrawable(View view, Drawable drawable) {
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public void setParentGravity(int parent_gravity) {
        if (parent_gravity == 17) {
           mRelativeLayout.setGravity(Gravity.CENTER);
        } else if (parent_gravity == 80) {
            mRelativeLayout.setGravity(Gravity.BOTTOM);
        } else if (parent_gravity == 1) {
            mRelativeLayout.setGravity(Gravity.CENTER_HORIZONTAL);
        } else if (parent_gravity == 16) {
            mRelativeLayout.setGravity(Gravity.CENTER_VERTICAL);
        } else if (parent_gravity == 8) {
            mRelativeLayout.setGravity(Gravity.CLIP_HORIZONTAL);
        } else if (parent_gravity == 128) {
            mRelativeLayout.setGravity(Gravity.CLIP_VERTICAL);
        } else if (parent_gravity == 8388613) {
            mRelativeLayout.setGravity(Gravity.END);
        } else if (parent_gravity == 119) {
            mRelativeLayout.setGravity(Gravity.FILL);
        } else if (parent_gravity == 7) {
            mRelativeLayout.setGravity(Gravity.FILL_HORIZONTAL);
        } else if (parent_gravity == 112) {
            mRelativeLayout.setGravity(Gravity.FILL_VERTICAL);
        } else if (parent_gravity == 3) {
            mRelativeLayout.setGravity(Gravity.LEFT);
        } else if (parent_gravity == 5) {
            mRelativeLayout.setGravity(Gravity.RIGHT);
        } else if (parent_gravity == 8388611) {
            mRelativeLayout.setGravity(Gravity.START);
        } else if (parent_gravity == 48) {
            mRelativeLayout.setGravity(Gravity.TOP);
        }
    }

    public void setGravity(int parent_gravity) {
        if (parent_gravity > 0) {
            mRelativeLayout.setGravity(parent_gravity);
        }
    }

    public void setLogoPositionX(float x) {
        if (x > 0) {
            mTextView.setX(x);
        } else {
            mTextView.setX(DEFAULT_LOGO_X);
        }
    }

    public void setLogoPositionY(float y) {
        if (y > 0) {
            mTextView.setY(y);
        } else {
            mTextView.setY(DEFAULT_LOGO_Y);
        }
    }

    public void setLogoTextColor(ColorStateList color) {
        if(color != null) {
            mTextView.setTextColor(color);
        }
    }

    public void setLogoBackgroundColor(ColorStateList color) {
        if(color != null) {
            mTextView.setBackgroundColor(color.getDefaultColor());
        }
    }

    public void setLogoHeight(float height) {
        if(height > -1) {
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, height, getResources().getDisplayMetrics());
            mParams.height = (int) pixels;
            mTextView.setLayoutParams(mParams);
        }
    }

    public void setLogoWidth(float width) {
        if(width > -1) {
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, width, getResources().getDisplayMetrics());
            mParams.width = (int) pixels;
            mTextView.setLayoutParams(mParams);
        }
    }

    protected void setLogoMargins(float left, float top, float right, float bottom) {
        if((left > -1) || (top > -1) || (right > -1) || (bottom > -1)){
            setLogoMarginLeft(left);
            setLogoMarginTop(top);
            setLogoMarginRight(right);
            setLogoMarginBottom(bottom);
        }
    }

    protected void setLogoMargins(float margins) {
        setLogoMargins(margins, margins, margins, margins);
    }

    public void setLogoMarginLeft(float left) {
        if(left > -1){
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, left, getResources().getDisplayMetrics());
            mParams.leftMargin = (int) pixels;
            mTextView.setLayoutParams(mParams);
        }
    }

    public void setLogoMarginTop(float top) {
        if(top > -1){
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, top, getResources().getDisplayMetrics());
            mParams.topMargin = (int) pixels;
            mTextView.setLayoutParams(mParams);
        }
    }

    public void setLogoMarginRight(float right) {
        if(right > -1){
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, right, getResources().getDisplayMetrics());
            mParams.rightMargin = (int) pixels;
            mTextView.setLayoutParams(mParams);
        }
    }

    public void setLogoMarginBottom(float bottom) {
        if(bottom > -1){
            float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottom, getResources().getDisplayMetrics());
            mParams.bottomMargin = (int) pixels;
            mTextView.setLayoutParams(mParams);
        }
    }
}