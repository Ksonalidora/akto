package com.akto.action.user;

import com.akto.action.UserAction;
import com.akto.dao.UsersDao;
import com.akto.dto.User;
import com.akto.util.Constants;
import com.mongodb.BasicDBObject;
import com.mongodb.client.model.Filters;
import com.opensymphony.xwork2.Action;

public class UserInfoAction extends UserAction {

    private String aktoUIMode;

    @Override
    public String execute() throws Exception {
        return Action.SUCCESS;
    }

    private Integer lastLoginTs;
    public String fetchUserLastLoginTs() {
        lastLoginTs = UsersDao.instance.fetchUserLasLoginTs(getSUser().getId());
        if (lastLoginTs == null) return ERROR.toUpperCase();
        return Action.SUCCESS.toUpperCase();
    }

    public String updateAktoUIMode() {
        if (aktoUIMode == null) {
            return ERROR.toUpperCase();
        }
        try {
            User.AktoUIMode mode = User.AktoUIMode.valueOf(aktoUIMode);
            User user = getSUser();
            UsersDao.instance.updateOne(Filters.eq(User.LOGIN, user.getLogin()),
                    new BasicDBObject(UsersDao.SET, new BasicDBObject(User.AKTO_UI_MODE, mode)));
        } catch (Exception e) {

        }
        return Action.SUCCESS.toUpperCase();
    }

    public Integer getLastLoginTs() {
        return lastLoginTs;
    }

    public String getAktoUIMode() {
        return aktoUIMode;
    }

    public void setAktoUIMode(String aktoUIMode) {
        this.aktoUIMode = aktoUIMode;
    }
}
