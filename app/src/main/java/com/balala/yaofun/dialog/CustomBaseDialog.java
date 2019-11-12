package com.balala.yaofun.dialog;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.balala.yaofun.R;
import com.balala.yaofun.util.ForLog;
import com.flyco.animation.Attention.Swing;
import com.flyco.dialog.utils.CornerUtils;
import com.flyco.dialog.widget.base.BaseDialog;

import static com.balala.yaofun.httpUtils.SystemUtil.dp2px;


public class CustomBaseDialog extends BaseDialog<CustomBaseDialog> {
    private Button tv_cancel;
    private Button tv_ok;
    private Context context;
    private View.OnClickListener ok;
    private View.OnClickListener cancel;

    public CustomBaseDialog(Context context, View.OnClickListener ok, View.OnClickListener cancel) {
        super(context);
        this.context=context;
        this.ok=ok;
        this.cancel=cancel;
    }

    @Override
    public View onCreateView() {
        widthScale(0.85f);
        showAnim(new Swing());
        ForLog.e("弹窗"+context);

        // dismissAnim(this, new ZoomOutExit());
        View inflate = View.inflate(context, R.layout.dialog_custom_base, null);
        tv_cancel = inflate.findViewById(R.id.tv_cancel);
        tv_ok = inflate.findViewById(R.id.tv_ok);
        inflate.setBackgroundDrawable(
                CornerUtils.cornerDrawable(Color.parseColor("#ffffff"), dp2px(5)));

        return inflate;
    }

    @Override
    public void setUiBeforShow() {
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                cancel.onClick(tv_cancel);

            }
        });

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                ok.onClick(tv_cancel);

            }
        });
    }
}
