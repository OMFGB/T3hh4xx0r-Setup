LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := eng

LOCAL_SRC_FILES := $(call all-subdir-java-files)

LOCAL_PACKAGE_NAME := T3hh4xx0r-Setup
LOCAL_CERTIFICATE := platform

include $(BUILD_PACKAGE)

