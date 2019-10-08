package com.example.activity1;

import android.provider.BaseColumns;

public class DataBases {
    public static final class CreateDB implements BaseColumns {
        public static final String USERID = "userid";
        public static final String NAME = "name";
        public static final String QUANTITY = "quantity";
        public static final String DUEDATE = "dutedate";
        public static final String _TABLENAME0 = "ingredients";
        public static final String _CREATE0 = "create table if not exists "+_TABLENAME0+"("
                +_ID+" integer primary key autoincrement, "
                +NAME+" text not null , "
                +QUANTITY+" integer not null , "
                +DUEDATE+" text not null );";
    }
}
