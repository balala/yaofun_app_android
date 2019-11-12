package com.balala.yaofun.activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.balala.yaofun.R;
import com.balala.yaofun.bean.UploadPickBean;
import com.balala.yaofun.util.CustomEditText;
import com.balala.yaofun.util.MyServer;
import com.balala.yaofun.util.ToastUtils;
import com.bigkoo.pickerview.TimePickerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;
import com.wildma.pictureselector.PictureSelector;

import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@GlideModule
public class PromotionalActivitiesActivity extends AppCompatActivity {

    @BindView(R.id.openfunback)
    LinearLayout mOpenfunback;
    @BindView(R.id.openfunimg)
    ImageView mOpenfunimg;
    @BindView(R.id.openfunphoto)
    ImageView openfunphoto;
    @BindView(R.id.openfunaddimg)
    RelativeLayout mOpenfunaddimg;
    @BindView(R.id.openfunimgs)
    ImageView openfunimgs;
    @BindView(R.id.openfun_name)
    CustomEditText mOpenfunName;
    @BindView(R.id.openfun_resume)
    CustomEditText mOpenfunResume;
    @BindView(R.id.openfun_dotext)
    TextView mOpenfunDotext;
    @BindView(R.id.openfun_activitytext)
    CustomEditText mOpenfunActivitytext;
    @BindView(R.id.openfun_jointext)
    TextView mOpenfunJointext;
    @BindView(R.id.openfun_interesttext)
    TextView mOpenfunInteresttext;
    @BindView(R.id.openfun_applypeoplecontent)
    EditText mOpenfunApplypeoplecontent;
    @BindView(R.id.openfuninterestback)
    ImageView mOpenfuninterestback;
    @BindView(R.id.openfun_interestback)
    ImageView mOpenfunInterestback;
    @BindView(R.id.openfun_applytext)
    TextView mOpenfunApplytext;
    @BindView(R.id.openfun_activitydetailsback)
    ImageView mOpenfunActivitydetailsback;
    @BindView(R.id.openfun_interestadd)
    ImageView mOpenfunInterestadd;
    @BindView(R.id.open_immediately)
    Button mOpenImmediately;
    @BindView(R.id.where)
    RelativeLayout where;
    @BindView(R.id.funrt)
    RelativeLayout funrt;
    @BindView(R.id.begintime)
    RelativeLayout begintime;
    @BindView(R.id.overtime)
    RelativeLayout overtime;
    @BindView(R.id.openfun_applyedit)
    EditText openfun_applyedit;

    private static final int PHOTO_REQUEST_GALLERY = 2;// 从相册中选择
    /**
     * 选择图片的返回码
     */
    public final static int SELECT_IMAGE_RESULT_CODE = 200;
    //    @BindView(R.id.openfunimg)
    //    ImageView openfunlayout;
    private String picturePath;
    // 当前日期
    private int currYear;
    private int currMonth;
    private int currDay;
    // 开始时间
    private int startHour = -1;
    private int startMinute = -1;
    // 结束时间
    private int endHour = -1;
    private int endMinute = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotional_activities);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {


    }

    @OnClick({R.id.openfunback, R.id.openfunimg, R.id.openfunaddimg, R.id.openfun_name, R.id.openfun_resume, R.id.openfun_dotext, R.id.openfun_activitytext, R.id.openfun_jointext, R.id.openfuninterestback, R.id.openfun_interesttext, R.id.openfun_interestback, R.id.openfun_applytext, R.id.openfun_applypeoplecontent, R.id.openfun_activitydetailsback, R.id.openfun_interestadd, R.id.open_immediately, R.id.where, R.id.funrt, R.id.begintime, R.id.overtime})
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.openfunback:
                finish();
                break;

            case R.id.openfunimg:
                openAlbum();

                break;
            case R.id.openfunaddimg:
                break;
            case R.id.openfun_name:
                break;
            case R.id.openfun_resume:

                break;
            case R.id.openfun_dotext:
                break;

            case R.id.openfun_activitytext:
                break;
            case R.id.openfun_jointext:
                break;
            case R.id.openfuninterestback:

                break;
            case R.id.openfun_interesttext:
                break;
            case R.id.openfun_interestback:

                break;
            case R.id.openfun_applytext:
                mOpenfunApplytext.setVisibility(View.GONE);
                openfun_applyedit.setVisibility(View.VISIBLE);
                break;

            case R.id.openfun_applypeoplecontent:
                break;
            case R.id.openfun_activitydetailsback:
                break;
            case R.id.openfun_interestadd:
                break;
            case R.id.open_immediately:
                break;
            case R.id.where:
                startActivity(new Intent(PromotionalActivitiesActivity.this, PromotionalMapActivity.class));
                break;
            case R.id.begintime:
                openTimeTicker1();
                break;
            case R.id.overtime:
                openTimeTicker2();
                break;
            case R.id.funrt:
                startActivity(new Intent(PromotionalActivitiesActivity.this, CreateFunActivity.class));
                break;

        }
    }

    private void openTimeTicker1() {
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                mOpenfunJointext.setText(getTime(date));
            }
        }).build();
        pvTime.setDate(Calendar.getInstance());
        //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    private void openTimeTicker2() {
        //时间选择器
        TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                mOpenfunInteresttext.setText(getTime(date));
            }

        }).build();
        pvTime.setDate(Calendar.getInstance());
        //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        @SuppressLint("SimpleDateFormat") SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }


    private void takePick() {//相册Sd卡权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openAlbum();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 200);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, 100);
        }
    }


    //开启相册
    private void openAlbum() {
       /* Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, 1);*/
        PictureSelector
                .create(PromotionalActivitiesActivity.this, PictureSelector.SELECT_REQUEST_CODE)
                .selectPicture(200, 200, 1, 1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (990 == requestCode || 991 == requestCode) {
            int permissionSDCard = ContextCompat.checkSelfPermission(PromotionalActivitiesActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
            int permissionCamera = ContextCompat.checkSelfPermission(PromotionalActivitiesActivity.this, Manifest.permission.CAMERA);
            if (permissionSDCard == PackageManager.PERMISSION_GRANTED) {
                if (permissionCamera == PackageManager.PERMISSION_GRANTED) {
                    openAlbum(); // 通过了全部权限
                } else {
                    Toast.makeText(PromotionalActivitiesActivity.this, "须要拍照权限才可以继续，请前往设置界面操作", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(PromotionalActivitiesActivity.this, "须要读取SD卡权限才可以继续，请前往设置界面操作", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PictureSelector.SELECT_REQUEST_CODE) {
            if (PictureSelector.PICTURE_PATH != null && data != null) {
                picturePath = data.getStringExtra(PictureSelector.PICTURE_PATH);
                if (picturePath != null) {
                    File file = new File(picturePath);
                    if (file.exists()) {
                        uploadPick(file);
                    } else {
                        Toast.makeText(this, "上传失败", Toast.LENGTH_SHORT).show();
                    }
                    uploadPick(file);
                }
            }

        }

    }

    private void uploadPick(File file) {
        //上传图片接口

        RequestBody body = RequestBody.create(MediaType.parse("multipart/form-data"), "file");

        RequestBody requestBody = MultipartBody.create(MediaType.parse("image/jpg"), file);

        MultipartBody.Part part = MultipartBody.Part
                .createFormData("file", file.getName(), requestBody);
       /* Map<String, Object> map = new HashMap<>();
        map.put("user_id", "-1");
        map.put("version", "-1");
        map.put("current_device", "安卓");
        map.put("unique_identifier", "");
        map.put("download_channel", "");
        map.put("user_defined_name", "");
        map.put("phone_version", "");
        map.put("wx_unionid", "");
        map.put("phone_model", "");
        map.put("images", file);
*/

        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(MyServer.url)
                .build();
        MyServer myServer = retrofit.create(MyServer.class);
        Observable<UploadPickBean> activitDataimg = myServer.getActivitDataimg(body, part);
        activitDataimg.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UploadPickBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UploadPickBean uploadPickBean) {
                        if (uploadPickBean != null) {
                            openfunimgs.setVisibility(View.GONE);
                            openfunphoto.setVisibility(View.GONE);
                            Picasso.with(PromotionalActivitiesActivity.this).load(uploadPickBean.getData())
//                                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(10)))
                                    .into(mOpenfunimg);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


    }

    //判断点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            //当isShouldHideInput(v, ev)为true时，表示的是点击输入框区域，则需要显示键盘，同时显示光标，反之，需要隐藏键盘、光标
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    //处理Editext的光标隐藏、显示逻辑
                    mOpenfunName.clearFocus();
                    mOpenfunResume.clearFocus();
                    mOpenfunDotext.clearFocus();
                    mOpenfunActivitytext.clearFocus();
                    mOpenfunJointext.clearFocus();
                    mOpenfunInteresttext.clearFocus();
                    mOpenfunApplypeoplecontent.clearFocus();
                    openfun_applyedit.clearFocus();
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    // 获取文本框点击事件
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }


}



