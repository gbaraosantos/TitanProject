package com.baronhub.titan.project.common.enums;

/**
 * Permission types
 */
public enum Permission {
        USER("User"),
        ADMIN("Admin");

        String permissionType;

        Permission(String permission){
            this.permissionType = permission;
        }

        public String getUserPermission(){
            return permissionType;
        }

    /**
     * Turns String into enum
     * @param perm String
     * @return Permission
     */
    public static Permission getProfileType(String perm) {
            if (perm.equals("Admin")) return Permission.ADMIN;

            return Permission.USER;

        }
}
