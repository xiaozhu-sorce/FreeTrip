package com.example.freetrip.ui.mine.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.freetrip.ui.login.model.databean.UserWrapper;
import com.example.freetrip.ui.mine.model.MineDataSource;
import com.example.freetrip.ui.mine.model.MineRemoteRepository;
import com.example.freetrip.ui.mine.model.MyBlog;

import java.util.ArrayList;

public class MineViewModel extends ViewModel {
    private MineRemoteRepository repository;
    private final MutableLiveData<ArrayList<MyBlog>> blogLiveData;
    private final MutableLiveData<String> myPra;

    private ArrayList<MyBlog> blogArrayList;

    public MineViewModel() {
        blogLiveData = new MutableLiveData<>();
        init();
        myPra = new MutableLiveData<>();
        repository = MineRemoteRepository.getINSTANCE();
    }

    public MutableLiveData<String> getMyPra() {
        return myPra;
    }

    public MutableLiveData<ArrayList<MyBlog>> getBlogLiveData() {
        return blogLiveData;
    }

    private void init() {
        populateList();
        blogLiveData.setValue(blogArrayList);
    }

    private void populateList() {
        MyBlog myBlog = new MyBlog();
        myBlog.setContent("旅游真快乐");
        MyBlog myBlog1 = new MyBlog();
        myBlog1.setContent(" 姐妹，我们还是不联系了吧，谢谢你一直以来的照顾，我想了很久终于鼓起勇气要放下你了，放过你也放过我自己，至少可以坦坦荡荡的为自己做一次决定我以为你懂，你对我来说有多重要，懂我对你的信任，你不懂在没有你陪伴的时候，我又多想念你的陪伴，可是谁知道虽然我现在每天都说话但我内心的孤单和不安全感从来没有消失，我想被人宠，想成为你最重要的人，\n" +
                "我不想在夜里哭，夜里崩溃，不想因为你一点点事情影响我的情绪你可能不知道这段友情一开始我就输了，我需要你的时候，和你说话你没有回复我的时候，真的很烦，祝你幸福。如果你不想结束这段感情，能不能给我发22块钱我想喝一杯多芒杨枝甘露。很感谢能够遇见你，我真的很爱很爱很爱你，我所有的脾气，爱哭，爱闹，爱笑，你都见过，我不后悔遇见你，我只是有点遗憾没能陪你一直到最后，最后谢谢你让我成长让我知道什么是友情。");


        blogArrayList = new ArrayList<>();
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog1);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
        blogArrayList.add(myBlog);
    }

    public void getPra(){
        repository.getPraStatus(UserWrapper.getInstance().getUser(), new MineDataSource.LoadLoginCallBack() {
            @Override
            public void onLoginLoded(String data) {
                myPra.setValue(data);
            }

            @Override
            public void onDataNotAvailable() {

            }

            @Override
            public void onFailure() {

            }
        });
    }
}