package kr.sy.android.fastfood.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.model.Company;
import kr.sy.android.fastfood.view.action.CustomDialogClickListener;

public class CompanyDetailDialog extends Dialog {

    private Context context;
    private CustomDialogClickListener customDialogClickListener;
    private Company company;

    public CompanyDetailDialog(@NonNull Context context, Company company, CustomDialogClickListener customDialogClickListener) {
        super(context);
        this.context = context;
        this.company = company;
        this.customDialogClickListener = customDialogClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customized_dialog);
        setCompanyName(this.company);
        setCompanyImage(this.company);
        setEventTitle(this.company);
        setDetailImage(this.company);
        ImageButton backButton = findViewById(R.id.backButton);
        ImageButton searchButton = findViewById(R.id.searchButton);

        setBackButtonOnClickListener(backButton);
        setSearchButtonOnClickListener(searchButton);

    }

    private void setBackButtonOnClickListener(ImageButton backButton){
        backButton.setOnClickListener(v -> {
            this.customDialogClickListener.onNegativeClick();
            dismiss();
        });
    }

    private void setSearchButtonOnClickListener(ImageButton searchButton){
        searchButton.setOnClickListener(v -> {
            this.customDialogClickListener.onPositiveClick();
            dismiss();
        });
    }

    private void setCompanyName(Company company){
        TextView companyName = findViewById(R.id.companyName);
        companyName.setText(company.getCompany_name());
    }
    private void setCompanyImage(Company company){
        ImageView companyImage = findViewById(R.id.companyImage);
        Glide.with(context).load(company.getImage()).into(companyImage);
    }
    private void setEventTitle(Company company){
        TextView eventTitle = findViewById(R.id.eventTitle);
        eventTitle.setText(company.getEvent_title());
    }
    private void setDetailImage(Company company){
        ImageView detailImage = findViewById(R.id.detailImage);
        Glide.with(context).load(company.getDetail_image()).into(detailImage);
    }

}
