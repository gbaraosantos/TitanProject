package com.baronhub.titan.project.common.enums;

/**
 * Permission types
 */
public enum Permission {
        USER("User"),
        ADMIN("Admin");

        String permission;

        Permission(String permission){
            this.permission = permission;
        }

        public String getUserPermission(){
            return permission;
        }

        public static Permission getProfileType(String perm) {
            switch (perm) {
                case "Admin":           return Permission.ADMIN;
                default:                return Permission.USER;
            }
        }
}
