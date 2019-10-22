package com.example.greenwall.about;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import cn.jzvd.Jzvd;

import android.os.Bundle;

import com.example.greenwall.R;
import com.example.greenwall.find.FindFragment;
import com.example.greenwall.lazy.LazyFragmentA;
import com.example.greenwall.lazy.LazyFragmentB;
import com.example.greenwall.lazy.LazyFragmentC;
import com.example.greenwall.lazy.LazyFragmentD;
import com.example.greenwall.lazy.LazyFragmentE;
import com.example.greenwall.shop.ShopFragment;

public class MainActivity extends FragmentActivity {

    private CustomBottomBarView customBottomBarView;
    private FragmentTransaction fragmentTransaction;
    private LazyFragmentA aFragment;
    private LazyFragmentB bFragment;
    private FindFragment findFragment;
    private LazyFragmentD dFragment;
    private ShopFragment shopFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView(savedInstanceState);
        initListener();

    }

    private void initView(Bundle savedInstanceState) {
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        customBottomBarView = (CustomBottomBarView) findViewById(R.id.main_bottom_layout);

        if (savedInstanceState == null) {
            createAllTabFragment();
        } else {
            aFragment = (LazyFragmentA) getSupportFragmentManager().findFragmentByTag(CustomTabEnum.SHOW.toString());
            bFragment = (LazyFragmentB) getSupportFragmentManager().findFragmentByTag(CustomTabEnum.SERVE.toString());
            findFragment = (FindFragment) getSupportFragmentManager().findFragmentByTag(CustomTabEnum.FIND.toString());
            dFragment = (LazyFragmentD) getSupportFragmentManager().findFragmentByTag(CustomTabEnum.MINE.toString());
            shopFragment = (ShopFragment) getSupportFragmentManager().findFragmentByTag(CustomTabEnum.SHOP.toString());
        }
        showFragmentByTag(CustomTabEnum.FIND);

    }
    private void showFragmentByTag(CustomTabEnum tag) {
        showFragmentByTag(tag, -1);
    }

    private void showFragmentByTag(CustomTabEnum tag, int weyType) {
        hideAllFragment(fragmentTransaction);
//        onUmengFragment(tag);
        switch (tag) {
            case SHOW:
                if (aFragment == null) {
                    createTabFragmentByTag(CustomTabEnum.SHOW);
                }
                fragmentTransaction.show(aFragment).commit();
                break;
            case FIND:
                if (findFragment == null) {
                    createTabFragmentByTag(CustomTabEnum.FIND);
                }
                fragmentTransaction.show(findFragment).commit();
                break;
            case MINE:
                if (dFragment == null) {
                    createTabFragmentByTag(CustomTabEnum.MINE);
                }
                fragmentTransaction.show(dFragment).commit();
                break;
            case SERVE:
                if (bFragment == null) {
                    createTabFragmentByTag(CustomTabEnum.SERVE);
                }
                fragmentTransaction.show(bFragment).commit();
                break;
            case SHOP:
                if (shopFragment == null) {
                    createTabFragmentByTag(CustomTabEnum.SHOP);
                }
                fragmentTransaction.show(shopFragment).commit();
                break;
            default:
                break;
        }
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if (aFragment != null) {
            fragmentTransaction.hide(aFragment);
        }
        if (bFragment != null) {
            fragmentTransaction.hide(bFragment);
        }
        if (findFragment != null) {
            fragmentTransaction.hide(findFragment);
        }

        if (dFragment != null) {
            fragmentTransaction.hide(dFragment);
        }
        if (shopFragment != null) {
            fragmentTransaction.hide(shopFragment);
        }
    }

    private void createAllTabFragment() {
        createTabFragmentByTag(CustomTabEnum.SHOW);
    }

    private void createTabFragmentByTag(CustomTabEnum tag) {
        switch (tag) {
            case SHOW:
                aFragment = new LazyFragmentA();
                fragmentTransaction.add(R.id.content_layout, aFragment, CustomTabEnum.SHOW.toString());
                break;
            case FIND:
                findFragment = new FindFragment();
                fragmentTransaction.add(R.id.content_layout, findFragment, CustomTabEnum.FIND.toString());
                break;
            case MINE:
                dFragment = new LazyFragmentD();
                fragmentTransaction.add(R.id.content_layout, dFragment, CustomTabEnum.MINE.toString());
                break;
            case SERVE:
                bFragment = new LazyFragmentB();
                fragmentTransaction.add(R.id.content_layout, bFragment, CustomTabEnum.SERVE.toString());
                break;
            case SHOP:
                shopFragment = new ShopFragment();
                fragmentTransaction.add(R.id.content_layout, shopFragment, CustomTabEnum.SHOP.toString());
                break;
            default:
                break;
        }
    }
    private void initListener() {
        customBottomBarView.setOnBottomSwitchListener(new OnBottomSwitchListener() {
            @Override
            public void onBottomSwitch(CustomTabEnum tabEnum) {
                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                switch (tabEnum) {
                    case SHOW:
                        showFragmentByTag(CustomTabEnum.SHOW);
                        break;
                    case FIND:
                        showFragmentByTag(CustomTabEnum.FIND);
                        break;
                    case MINE:
                        showFragmentByTag(CustomTabEnum.MINE);
                        break;
                    case SERVE:
                        showFragmentByTag(CustomTabEnum.SERVE);
                        break;
                    case SHOP:
                        showFragmentByTag(CustomTabEnum.SHOP);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Jzvd.resetAllVideos();
    }

    @Override
    public void onBackPressed() {
        if (Jzvd.backPress()) {
            return;
        }
        super.onBackPressed();
    }

}
