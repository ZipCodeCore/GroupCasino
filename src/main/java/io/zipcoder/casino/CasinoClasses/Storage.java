package io.zipcoder.casino.CasinoClasses;

import java.util.HashMap;

public class Storage {
    private HashMap<Integer,Membership> memberStorage;

    public Storage(Membership membership){
        this.memberStorage.put(membership.getIdNumber(), membership);
    }

    public HashMap<Integer, Membership> getMemberStorage() {
        return memberStorage;
    }

    public void setMemberStorage(HashMap<Integer, Membership> memberStorage) {
        this.memberStorage = memberStorage;
    }

}
