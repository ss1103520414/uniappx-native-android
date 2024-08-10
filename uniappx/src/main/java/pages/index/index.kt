@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME")
package uni.UNI64B44D4;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import uts.sdk.modules.kuxAudioPlayer.Loop;
import uts.sdk.modules.kuxAudioPlayer.createAudioPlayer;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesIndexIndex : BasePage {
    constructor(instance: ComponentInternalInstance) : super(instance) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexIndex) -> Any? = fun(
        @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        __props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesIndexIndex;
            val _cache = __ins.renderCache;
            val msg = fun(msg: String){
                uni_showToast(ShowToastOptions(title = msg, icon = "none"));
            }
            ;
            val audioPlayer = createAudioPlayer();
            val disabled = ref(false);
            val srcList = ref(utsArrayOf(
                "/static/1777051637.mp3",
                "https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3"
            ));
            val setPlaysrc = fun(){
                audioPlayer.src = srcList.value[0];
                audioPlayer.src = srcList.value[1];
            }
            ;
            val currentIndex = ref(0);
            val volume = ref(0);
            val setAutoplay = fun(autoplay: Boolean){
                audioPlayer.autoplay = autoplay;
            }
            ;
            setAutoplay(false);
            setPlaysrc();
            val setCurrentIndex = fun(){
                audioPlayer.currentIndex = currentIndex.value;
            }
            ;
            val playPrevious = fun(){
                currentIndex.value = audioPlayer.currentIndex - 1;
                if (currentIndex.value < 0) {
                    currentIndex.value = 0;
                }
                setCurrentIndex();
            }
            ;
            val setAutonext = fun(autonext: Boolean){
                audioPlayer.autonext = autonext;
            }
            ;
            console.log(audioPlayer.src, " at pages/index/index.uvue:115");
            val setLoop = fun(loop: Loop){
                audioPlayer.loop = loop;
            }
            ;
            setLoop("all");
            setAutonext(true);
            val setVolume = fun(volume: Number){
                audioPlayer.volume = volume;
            }
            ;
            val changeVolume = fun(event: UniSliderChangeEvent){
                volume.value = event.detail.value;
                setVolume(volume.value / 100);
                msg("\u5F53\u524D\u97F3\u91CF\uFF1A" + volume.value / 100);
            }
            ;
            val isPlay = ref(false);
            val duration = ref(0);
            val currentTime = ref(0);
            audioPlayer.onError(fun(error){
                console.log(error, " at pages/index/index.uvue:157");
            }
            );
            audioPlayer.onCanplay(fun(){
                console.log("可以播放了，当前音频长度：", audioPlayer.duration, " at pages/index/index.uvue:161");
                isPlay.value = true;
                duration.value = audioPlayer.duration;
                volume.value = audioPlayer.volume * 100;
            }
            );
            val playAudio = fun(){
                audioPlayer.play();
            }
            ;
            val pauseAudio = fun(){
                audioPlayer.pause();
            }
            ;
            val stopAudio = fun(){
                audioPlayer.stop();
            }
            ;
            val seekTo = fun(status: Number){
                if (status == 1) {
                    audioPlayer.seek(audioPlayer.currentTime + 10);
                } else {
                    audioPlayer.seek(audioPlayer.currentTime - 10);
                }
            }
            ;
            val setPlaybackSpeed = fun(value: Number){
                audioPlayer.playbackRate = value;
            }
            ;
            val playNext = fun(){
                currentIndex.value = audioPlayer.currentIndex + 1;
                if (currentIndex.value > srcList.value.length) {
                    currentIndex.value = srcList.value.length;
                }
                setCurrentIndex();
            }
            ;
            audioPlayer.onTimeUpdate(fun(){
                currentTime.value = audioPlayer.currentTime;
            }
            );
            audioPlayer.onPlay(fun(){
                currentIndex.value = audioPlayer.currentIndex;
                msg("\u5F00\u59CB\u64AD\u653E\uFF0C\u5F53\u524D\u7D22\u5F15\uFF1A" + currentIndex.value);
            }
            );
            audioPlayer.onPause(fun(){
                msg("播放暂停");
            }
            );
            audioPlayer.onStop(fun(){
                msg("停止播放");
            }
            );
            audioPlayer.onEnded(fun(){
                msg("播放结束");
            }
            );
            audioPlayer.onNext(fun(){
                duration.value = audioPlayer.duration;
                console.log("\u5373\u5C06\u64AD\u653E\u4E0B\u4E00\u66F2\uFF0C\u6B4C\u66F2\u7D22\u5F15\uFF1A" + audioPlayer.currentIndex, " at pages/index/index.uvue:227");
                msg("即将播放下一曲");
            }
            );
            audioPlayer.onSeeking(fun(){
                msg("正在快进或者快退");
            }
            );
            audioPlayer.onWaiting(fun(){
                msg("\u6B63\u5728\u7F13\u51B2\u4E2D...\uFF0C\u5F53\u524D\u7F13\u51B2\u65F6\u95F4\u70B9\uFF1A" + audioPlayer.buffered);
            }
            );
            return fun(): Any? {
                val _component_slider = resolveComponent("slider");
                val _component_kux_page = resolveEasyComponent("kux-page", GenComponentsKuxPageKuxPageClass);
                return createVNode(_component_kux_page, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "p-3"), utsArrayOf(
                            createElementVNode("view", null, utsArrayOf(
                                createElementVNode("view", utsMapOf("class" to "flex flex-row"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "mr-3"), "是否可以播放："),
                                    createElementVNode("text", null, toDisplayString(unref(isPlay)), 1)
                                )),
                                createElementVNode("view", utsMapOf("class" to "flex flex-row mt-2"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "mr-3"), "当前曲目长度："),
                                    if (unref(duration) > 0) {
                                        createElementVNode("text", utsMapOf("key" to 0), toDisplayString(unref(duration) + "秒"), 1);
                                    } else {
                                        createCommentVNode("v-if", true);
                                    }
                                )),
                                createElementVNode("view", utsMapOf("class" to "flex flex-row mt-2"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "mr-3"), "当前曲目播放进度："),
                                    createElementVNode("text", null, toDisplayString(unref(currentTime)) + "秒", 1)
                                )),
                                createElementVNode("view", utsMapOf("class" to "flex flex-row mt-2"), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "mr-3"), "调节播放音量："),
                                    createVNode(_component_slider, utsMapOf("min" to 0, "max" to 100, "value" to unref(volume), "step" to 1, "block-size" to 12, "onChange" to changeVolume, "style" to normalizeStyle(utsMapOf("width" to "200px"))), null, 8, utsArrayOf(
                                        "value",
                                        "style"
                                    ))
                                ))
                            )),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to playAudio), "开始播放"),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to pauseAudio), "暂停播放"),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to stopAudio), "停止播放"),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to fun(){
                                seekTo(1);
                            }
                            ), "快进10秒", 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to fun(){
                                seekTo(-1);
                            }
                            ), "快退10秒", 8, utsArrayOf(
                                "onClick"
                            )),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to playPrevious), "上一曲"),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "onClick" to playNext), "下一曲"),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "disabled" to unref(disabled), "onClick" to fun(){
                                setPlaybackSpeed(2);
                            }
                            ), "播放速度 x 2.0", 8, utsArrayOf(
                                "disabled",
                                "onClick"
                            )),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "disabled" to unref(disabled), "onClick" to fun(){
                                setPlaybackSpeed(0.5);
                            }
                            ), "播放速度 x 0.5", 8, utsArrayOf(
                                "disabled",
                                "onClick"
                            )),
                            createElementVNode("button", utsMapOf("type" to "primary", "class" to "mt-2", "disabled" to unref(disabled), "onClick" to fun(){
                                setPlaybackSpeed(1);
                            }
                            ), "播放速度 x 1.0", 8, utsArrayOf(
                                "disabled",
                                "onClick"
                            ))
                        ))
                    );
                }
                ), "_" to 1));
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
