#include <jni.h>
#include <string>

// The function name MUST match your Java package and class name exactly
extern "C" JNIEXPORT jstring JNICALL
Java_com_example_helloworld_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++ (NDK) via GitHub Actions!";
    return env->NewStringUTF(hello.c_str());
}
