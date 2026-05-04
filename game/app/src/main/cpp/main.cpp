#include <game-activity/native_app_glue/android_native_app_glue.h>
#include <android/log.h>

#define LOG_TAG "NativeGame"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)

int tapCount = 0;

extern "C" {

void android_main(struct android_app* app) {

    app->onInputEvent = [](android_app* app, AInputEvent* event) -> int {
        if (AInputEvent_getType(event) == AINPUT_EVENT_TYPE_MOTION) {
            tapCount++;
            LOGI("Tap Count: %d", tapCount);
            return 1;
        }
        return 0;
    };

    while (true) {
        int events;
        android_poll_source* source;

        while (ALooper_pollAll(0, nullptr, &events,
                               (void**)&source) >= 0) {

            if (source)
                source->process(app, source);
        }
    }
}

}
