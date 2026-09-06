#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_helloworld_GameView_getGameTitle(JNIEnv* env, jobject /* this */) {
    return env->NewStringUTF("Target Tap!");
}
