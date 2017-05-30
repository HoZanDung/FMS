package com.cms.Presenter;

import com.cms.entity.SysContent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by HOZANDUNG on 17/5/27.
 */
@Component
public class FilePresenter extends BasePresenter<SysContent> {

    private String[] toCreate = {"author", "category", "title", "content"};

    @Override
    public SysContent toCreate(HttpServletRequest request) {
        SysContent content = mapToObject(new SysContent(),toCreate,request);
        return content;
    }

    @Override
    public SysContent toUpdate(HttpServletRequest request, SysContent sysContent) {
        return null;
    }
}
