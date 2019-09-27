package com.yu.common.log;

public interface Logging {

    String DEFAULT_PATH = "";

    String DEFAULT_FILE_NAME = "access.log";

    void setFileName(String fileName);

    void setPath(String path);

    void setLogLevel(Byte level);

    void log(String info);

}
