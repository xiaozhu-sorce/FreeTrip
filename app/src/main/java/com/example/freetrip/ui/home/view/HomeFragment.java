package com.example.freetrip.ui.home.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.freetrip.databinding.FragmentHomeBinding;
import com.example.freetrip.ui.home.viewmodel.HomeViewModel;
import com.example.freetrip.ui.home.model.BannerBean;
import com.youth.banner.Banner;

public class HomeFragment extends Fragment implements View.OnTouchListener {

    private FragmentHomeBinding binding;
    private Banner banner;
    private Button travel,web;
    private TextView blog1, blog2, blog3;
    private SpannableString msp1, msp2, msp3;
    private StyleSpan styleSpanBold;
    private RelativeSizeSpan sizeSpan;

    @SuppressLint("ClickableViewAccessibility")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        banner = binding.homeBanner;
        banner.setAdapter(new BannerAdapter(BannerBean.getDefaultBanners()));

        blog1 = binding.blog1;
        blog2 = binding.blog2;
        blog3 = binding.blog3;
        blog1.setMovementMethod(ScrollingMovementMethod.getInstance());
        blog2.setMovementMethod(ScrollingMovementMethod.getInstance());
        blog3.setMovementMethod(ScrollingMovementMethod.getInstance());

        blog1.setOnTouchListener(this);
        blog2.setOnTouchListener(this);
        blog3.setOnTouchListener(this);

        styleSpanBold = new StyleSpan(Typeface.BOLD);
        sizeSpan = new RelativeSizeSpan(1.5f);

        setMsp1();
        setMsp2();
        setMsp3();

        travel = binding.btnTour;
        travel.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), TravelActivity.class));
        });

        web = binding.webBt;
        web.setOnClickListener( v -> {
            startActivity(new Intent(getActivity(),WebActivity.class));
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void setMsp1() {
        msp1 = new SpannableString("国内超小众浪漫海岛温岭石塘此生必去这一生总要去一趟温岭石塘吧，这里可以满足你对海岛游的所有幻想？人少景美还便宜！\n\n\n" +
                "熟悉我的朋友都知道我是狂热的海岛游爱好者者因为 yq 的原因实在憋的够呛前前后后做了一个月的攻略，终于下定决心出发啦。趁时光正好，趁我还年轻，为何要辜负这良辰美景\n" +
                "从青岛出发历时14个小时，行程1083公里，我终于来到了位于浙江台州温岭的石塘镇\n" +
                "这个曾上榜“中国最美渔村”的小城，这里三面环海一面靠山台将江南的温婉和海岛的澎湃结合的恰到好处，在这里你一定能感受到生活的惬意\n" +
                "打卡了林更新同款海景民宿（ ps ：谁让我是九亿少女呢）也是综艺《三个院子》的拍摄地民宿的位置在半山腰上，视野开阔0半岛美景尽收眼底，随便怎么拍都好看\n" +
                "尧珈．星罗海野曙光民宿上地址：浙江省台州市温岭市石塘镇海利村五岙里99-102号\n" +
                "清晨在海岛民宿伸着懒腰起床（如果能起来的话一定要早起去干年曙光园看日出 ）远离城市的喧嚣和紧张的生活节奏，真正可以放空自己，吹着海风欣赏潮起潮落还慢慢邂逅山与海的浪漫");

        msp1.setSpan(
                styleSpanBold,
                0, 56,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp1.setSpan(sizeSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        blog1.setText(msp1);
    }

    public void setMsp2() {
        msp2 = new SpannableString("我宣布！这里是中国最夏天的小城提到夏天你最想去的城市，你一定不会想到它心它没有青岛那么文艺，也没有厦门那么浪漫但它拥有中国最夏天的样子\n\n"
                + "√它就是位于山东半岛东端的威海，是中国日出最早的海岸城市\n"
                + "√被《中国国家地理》杂志评价为 中国最美八大海岸之一 \n"
                + "【威海必去】\n " + "1.成山头\n"
                + "这里是中国海上日出最早的地方有着“东方好望角”之称\n"
                + "看完日出，沿着海边的栈道静静地走着，每一步都有蔚蓝色的海洋风景作陪。\n"
                + "2.刘公岛\n"
                + "有人说，一座刘公岛，半部近代史。\n"
                + "因为在刘公岛上，每条路、每堵墙、每幢建筑都有故事。\n"
                + "这里诞生了中国近代第一支海军北洋水师，也是 中日甲午战争的古战场，至今还留有清朝北洋海 军提督署、水师学堂、古炮台等甲午战争遗址。 岛上还有很多英租时期遗留下来的欧式建筑。 \n"
                + "3.海驴岛\n"
                + "海鸟们的王国，每年4 - 6月，成干上万的海鸥会来此栖息产卵 这段时间可以选择海驴岛，坐船上就可以看到海鸥，下船上岛后，这些小家伙们也丝毫不怕人，还会围着游客讨鱼吃。\n 4.烟墩角\n 依山傍海的小渔村，村东一座小山遮挡住黄海，形成了一个小小的港湾。 每到寒风飘雪时节，总有数千只野生大天鹅从遥远的西伯利亚飞到这里越冬。 村民们都很爱护天鹅，会自发组成大天鹅巡护队，在天鹅湖周边进行野外巡护、救助和投食喂养大天鹅。\n"
                + "4.金石湾艺术园区海草屋\n 海草屋是胶东古民居的典型代表。仿佛像动漫里的海草屋，来到这里就像住到了宫崎骏的童话世界。海屋前面是蔚蓝色的大海，后面是鲜艳的野花，很梦幻。"

        );

        msp2.setSpan(
                styleSpanBold,
                0, 67,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp2.setSpan(sizeSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        blog2.setText(msp2);
    }

    public void setMsp3() {
        msp3 = new SpannableString("最喜欢的城市：苏州永远排第一，如果说，要选择一个可以让人放下步的城市。那么择一城而居，我的心愿是苏州\n\n\n"
                + "1️⃣苏州的古街里炊烟、书香一并混杂在记忆中，讲述若苏州当年的风华。\n" +
                "▽同德里\n" +
                "苏家老宅位于苏州的同德里，这里是一处民国时期的建筑群，旧旧的弄堂，高大的梧相树，黑色的木门斑驳，它不知道见证了多少人代人的故事。\n" +
                "▽平江路\n" +
                "说起街道，很多人都会想起苏州的平江路。\n" +
                "平江路是苏州的一条历史老街，是一条沿河的小路，其河名为平江河。\n" +
                "▽山塘街\n" +
                "这里两岸种植花木绿树，这里到处充满市井的味道，在这里你可以感受最惬意的苏州生活。\n" +
                "2️⃣在苏州古镇里，你只会怨恨阳光升起或落下太快，不忍着夜色来的太过匆忙只愿沉醉不归。\n" +
                "▽碧玉周庄\n" +
                "上有天堂，下有苏杭，中间有个周庄。苏州昆山市的周庄因水成街，因水成路，水溢润若周庄，水丰富若店庄，水是周圧的灵魂。\n" +
                "▽富土同里\n" +
                "苏州城和同里镇，坐车只有半个小时的路程。虽然只有半个小时，但是给人的感受却完全不同。同里还被뽑为“东方威尼斯＂，很多人向往威尼斯的水路，其实你不用跑那么远，来同里也可以感受到水城的魅力。\n" +
                "▽风情甪直\n" +
                "甪直古镇是苏州古镇中最有烟火气的一个。如果说去同里和周庄是去寻安逸的话，那么去用直就是找寻生活本质的\n" +
                "▽秀美木渎\n" +
                "木渎古镇有“秀绝冠江南”之普。而且它还被天平、灵岩、狮山、七子等吴中名山环抱之中，故有“聚宝盆”之称。这里的溪水波澜不惊，这里的木船悠然地穿过古老的桥洞，每一处精致都像是在诉说着一个有情的故事。\n" +
                "3️⃣来苏州，住了古镇，逛了古街后还是要去那几个“地标＂建筑看一看啊。\n" +
                "▽寒山寺\n" +
                "提起寒山寺，大家一定都会先想起那句“姑苏城外寒山寺，夜半钟声到客船”。\n" +
                "▽虎丘\n" +
                "虎丘山有2500多年的悠久历史，有“昊中第一名胜＂的美普\n" +
                "▽苏州园林\n" +
                "都说苏州园林甲天下，咫尺之内有乾坤，这句话一点也不假。中国的四大园林，苏州就占了两个，一个是最大的古典山水园林拙政园，一个是以假山为奇的留。\n" +
                "▽苏州大学\n" +
                "说起最美的大学，你脑子里可能是武汉大学的櫻花，又或者是厦门大学的中西合壁，但是苏州大学也美得让人心动\n" +
                "来苏州，除了赏园林，转老街，乘游船，不要忘了品一下地道的苏帮菜。苏州的面啊，糕点啊，本帮菜都很赞的\n" +
                "什么才是生活啊？\n" +
                "是花不完的钱还是喝不完的酒，忽然想去苏州了…");

        msp3.setSpan(
                styleSpanBold,
                0, 50,
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        msp3.setSpan(sizeSpan, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        blog3.setText(msp3);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            //通知父控件不要干扰,即屏蔽父控件的该事件以及该事件之后的一切action
            v.getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            //通知父控件不要干扰,即屏蔽父控件的该事件以及该事件之后的一切action
            v.getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            v.getParent().requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }
}