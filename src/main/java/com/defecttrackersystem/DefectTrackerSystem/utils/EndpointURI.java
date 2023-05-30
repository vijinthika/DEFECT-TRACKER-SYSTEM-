package com.defecttrackersystem.DefectTrackerSystem.utils;

public class EndpointURI {
    private static final String BASE_API_PATH = "/api/v1/";
    private static final String ID = "/{id}";

    public static final String PRIORITY = BASE_API_PATH + "priority";
    public static final String PRIORITY_BY_ID = PRIORITY + ID;
}
