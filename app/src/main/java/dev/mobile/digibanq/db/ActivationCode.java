package dev.mobile.digibanq.db;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by finxl-isaac on 12/5/16.
 */

public class ActivationCode extends RealmObject {
    @PrimaryKey
            int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String code;

    public ActivationCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public ActivationCode() {
    }
}
