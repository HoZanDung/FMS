package com.cms.Presenter;

import com.cms.entity.SysContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HOZANDUNG on 17/5/27.
 */
@Component
public class FilePresenter extends BasePresenter<SysContent> {

    private String[] toCreate = {"category", "title", "content","author"};

    private String[] toUpdate = {"category","title","content","author"};
    @Override
    public SysContent toCreate(HttpServletRequest request) {
        SysContent sysContent = mapToObject(new SysContent(),toCreate,request);
        return sysContent;
    }

    @Override
    public SysContent toUpdate(HttpServletRequest request, SysContent sysContent) {
        sysContent = mapToObject(sysContent,toUpdate,request);
        return sysContent;
    }
}
