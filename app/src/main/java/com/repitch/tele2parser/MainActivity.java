package com.repitch.tele2parser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.repitch.tele2parser.api.ApiManager;
import com.repitch.tele2parser.api.entity.Line;
import com.repitch.tele2parser.api.entity.NumberItem;
import com.repitch.tele2parser.api.entity.request.NumbersRequestFactory;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private NumberAdapter adapter;
    private TextView txtPage;
    private View btnNextPage;
    private TextView txtTotalInfo;
    private EditText editSearch;

    private NumbersRequestFactory factory;
    private int curPage = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTotalInfo = findViewById(R.id.txtTotalInfo);
        editSearch = findViewById(R.id.editSearch);
        txtPage = findViewById(R.id.txtPage);
        btnNextPage = findViewById(R.id.btnNextPage);
        txtPage.setText(getString(R.string.page_count, curPage));
        btnNextPage.setOnClickListener(v -> {
            curPage++;
            loadPage(curPage);
            btnNextPage.setVisibility(View.INVISIBLE);
        });

        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // nothing
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // nothing
            }

            @Override
            public void afterTextChanged(Editable editable) {
                adapter.setSearchQuery(editable.toString());
            }
        });

        factory = new NumbersRequestFactory();

        RecyclerView recycler = findViewById(R.id.recycler);
        adapter = new NumberAdapter();
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        loadPage(curPage);
    }

    private void loadPage(int page) {
        ApiManager.getInstance().getApiService().getMoreNumbers(factory.getRequest(page, "9779517390"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(numbersResponse -> {
                    List<NumberItem> items = new ArrayList<>();
                    for (Line line : numbersResponse.getLines()) {
                        items.addAll(line.getLeft().getNumberItems());
                        items.addAll(line.getRight().getNumberItems());
                    }
                    adapter.setNumbers(items);
                    txtTotalInfo.setText(String.format("Всего номеров: %d", items.size()));
                    txtPage.setText(getString(R.string.page_count, page));
                    btnNextPage.setVisibility(View.VISIBLE);
                }, error -> {
                    Timber.e(error);
                    Toast.makeText(this, "ERROR!", Toast.LENGTH_SHORT).show();
                });
    }
}
