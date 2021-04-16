package kr.sy.android.fastfood.ui;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import kr.sy.android.fastfood.R;
import kr.sy.android.fastfood.ui.home.Company;

public class CompanyDetailDialog extends Dialog {

    private Context context;
    private CustomDialogClickListener customDialogClickListener;
    private ImageView companyImage , detailImage;
    private TextView companyName;
    private ImageButton backButton, searchButton;
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
        backButton = findViewById(R.id.backButton);
        searchButton = findViewById(R.id.searchButton);

        backButton.setOnClickListener(v -> {
            this.customDialogClickListener.onNegativeClick();
            dismiss();
        });
        searchButton.setOnClickListener(v -> {
            this.customDialogClickListener.onPositiveClick();
            dismiss();
        });

    }

    private void setCompanyName(Company company){
        companyName = findViewById(R.id.companyName);
        companyName.setText(company.getCompany_name());
    }

    private void setDetailImage(Company company){
        detailImage = findViewById(R.id.detailImage);
        //detailImage.setImage
    }
}
