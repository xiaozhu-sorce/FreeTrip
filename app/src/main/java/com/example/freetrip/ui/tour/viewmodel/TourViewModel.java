package com.example.freetrip.ui.tour.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.freetrip.ui.tour.bean.Blog;

import java.util.ArrayList;

public class TourViewModel extends ViewModel {

    private final MutableLiveData<ArrayList<Blog>> blogLiveData;

    private ArrayList<Blog> blogArrayList;

    public TourViewModel() {
        blogLiveData = new MutableLiveData<>();
        init();
    }

    public MutableLiveData<ArrayList<Blog>> getBlogLiveData() {
        return blogLiveData;
    }

    private void init() {
        populateList();
        blogLiveData.setValue(blogArrayList);
    }

    private void populateList() {
        Blog blog = new Blog();
        blog.setName("xiaozhu");
        blog.setTitle("My Blog");
        blog.setContent("浪漫至死不渝");

        Blog blog1 = new Blog();
        blog1.setName("xiaozhu");
        blog1.setTitle("My Blog");
        blog1.setContent("长沙之旅在群消息叮叮的声音中逐渐清晰\n" +
                "没有行李箱的隆隆声\n" +
                "背上背包    与朋友\n" +
                "当列车穿过黑暗的隧道\n" +
                "当窗外的绿色连成幻影\n" +
                "经过五个小时终于到达了长沙\n" +
                "出了火车站向前走  非常惊喜地就发现了“茶颜悦色”       \n" +
                " 满目新奇的奶茶，又幸福又不知所措，小心翼翼地经过一番询问，终于选中了芊芊马卡龙，又甜又可爱的名字，充分体现了当时粉色的心情。对拼海底捞的服务：贴心准备的温热水，震动提醒取单的圆盘，一切都是新奇的体验。\n" +
                "旅行就从一杯暖暖的奶油奶茶开始啦…\n" +
                "因为经过一天的路程，肚子靠着早餐支撑到了下午饭的时间，大家发誓到：晚饭一定要吃的饱饱的！搭乘地铁，来到五一广场，见到了热搜中的粉红色斑马线，在人山人海中步履维艰，艰难找到虾小龙龙虾馆，没想到，恰逢饭点，一个小时半起步的等待，让我们走进用餐区的心情更加激动。\n" +
                "来到长沙，怎么能少了麻辣口味虾？！武汉小分队长沙集合！北方孩子不能缺少的面条蘸满汤汁，还有炊烟小炒黄牛肉，真的是给孩子们都辣哭了\n" +
                "辣过之后，糖油粑粑get，第一天的夜晚，感受到了长沙的市井与烟火气息！\n" +
                "（小插曲：震惊！三人在酒店竟…津津有味地看相亲节目）\n" +
                "麻辣的快乐夜晚，代价就是痛苦地半夜胃疼醒…\n" +
                "第二天快乐早起打卡岳麓山与橘子洲。（得意炫耀微信步数第一hahaha）谁说的上山容易下山难，一步步爬到山顶，体力低电量预警！！想坐的索道队伍竟排到了下山路，麻了…体力告急，不用排队的串串香它不香嘛（嘻）吃饱喝足，瘫在座位上，果断放弃桃花岭，深思熟虑还是非诚勿扰更加吸引我们，打道回府，三人沉迷于相亲节目无法自拔！伴着绵绵细雨，罪恶的夜晚来到了太平老街，吃逛ed，老店湘菜get！嗦粉get！\n" +
                "第三天的早晨呼吸着湿润的空气，冒着风雨，为王乐乐也一定要打卡的湖南广播电视台，最爱的芒果TV yep！旅程的最后以小tip白嫖长沙之窗茶颜悦色店的抹茶葡提，依然不腻（超棒der）\n" +
                "以列入联合国的小炊烟小炒黄牛肉湘菜馆打卡为ending，长沙之旅就这么充实有趣地度过啦\n" +
                "长沙之旅打板！\n" +
                "踏过青山绿水，看过楼林矗立，从中感受生活的平静与美好：是老街飘香的炊烟，是雨滴打湿的街道，有我对未来会遇到的人与事的期待。人生永远有告别，也永远会有期待！ ");

        blogArrayList = new ArrayList<>();
        blogArrayList.add(blog);
        blogArrayList.add(blog1);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
        blogArrayList.add(blog);
    }

}