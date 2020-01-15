package pe.com.patadeperro.presentation.utils;

public class Constants {


    public class PREFERENCES {
        public static final String PREFERENCE_CURRENT_USER = "PREFERENCE_CURRENT_USER";
    }

    public class PREFERENCES_KEYS {
        public static final String CURRENT_USER_ID = "CURRENT_USER_LOGGED";
        public static final String CURRENT_USER_IDCLOUD = "CURRENT_USER_LOGGED";
        public static final String CURRENT_USER_NAME = "CURRENT_USER_LOGGED";
        public static final String CURRENT_USER_PHONE= "CURRENT_USER_LOGGED";
        public static final String CURRENT_USER_LOGGED = "CURRENT_USER_LOGGED";
    }


    public class FRAGMENTS_TABS {
        public static final int HOME = 0;
        public static final int LOST = 1;
        public static final int ABUSE = 2;
        public static final int ACCOUNT = 3;
    }


    public class FIREBASE_TABLES {
        public static final String USER = "users";
        public static final String LOST = "lost";
    }

    public class FIREBASE_TABLES_FIELDS {
        public static final String USER_id = "id";
        public static final String USER_idCloud = "idCloud";
        public static final String USER_uid = "uid";
        public static final String USER_name = "name";
        public static final String USER_phoneNumber = "phoneNumber";
        public static final String USER_email = "email";
        public static final String USER_location = "location";
        public static final String USER_logged = "logged";
        public static final String USER_active = "active";
        public static final String USER_created_at = "created_at";
        public static final String USER_notifications = "notifications";
    }


}



