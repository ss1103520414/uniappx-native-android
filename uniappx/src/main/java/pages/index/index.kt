@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI509F621;
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
import uts.sdk.modules.androidKeeplive.KeepLive;
import io.dcloud.uniapp.extapi.getLocation as uni_getLocation;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesIndexIndex : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    companion object {
        @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
        var setup: (__props: GenPagesIndexIndex) -> Any? = fun(__props): Any? {
            val __ins = getCurrentInstance()!!;
            val _ctx = __ins.proxy as GenPagesIndexIndex;
            val _cache = __ins.renderCache;
            var keep = KeepLive();
            val formatTime = fun(date: Date): String {
                val addZero = fun(num: Number): String {
                    return if (num < 10) {
                        "0" + num;
                    } else {
                        "" + num;
                    }
                    ;
                }
                ;
                return "" + date.getFullYear() + "-" + addZero(date.getMonth() + 1) + "-" + addZero(date.getDate()) + " " + addZero(date.getHours()) + ":" + addZero(date.getMinutes()) + ":" + addZero(date.getSeconds());
            }
            ;
            val requestBackgroundLocationPermission = fun(){
                val premissionArr = utsArrayOf(
                    "android.permission.ACCESS_COARSE_LOCATION",
                    "android.permission.ACCESS_FINE_LOCATION",
                    "android.permission.ACCESS_LOCATION_EXTRA_COMMANDS",
                    "android.permission.ACCESS_BACKGROUND_LOCATION"
                );
                UTSAndroid.requestSystemPermission(UTSAndroid.getUniActivity()!!, premissionArr, fun(_: Boolean, p: UTSArray<String>){
                    console.log(p);
                }
                , fun(_: Boolean, p: UTSArray<String>){
                    uni_showToast(ShowToastOptions(title = "权限被拒绝了", position = "bottom"));
                    console.log(p);
                }
                );
            }
            ;
            fun genGetLocationFn(altitude: Boolean? = true, isHighAccuracy: Boolean? = true, geocode: Boolean? = false): UTSPromise<Coordinate> {
                return UTSPromise<Coordinate>(fun(reslove, reject){
                    uni_getLocation(GetLocationOptions(provider = "system", type = "wgs84", altitude = altitude, isHighAccuracy = isHighAccuracy, geocode = geocode, success = fun(res: GetLocationSuccess){
                        val newCoord = Coordinate(location = res, timestamp = formatTime(Date()));
                        reslove(newCoord);
                    }
                    , fail = fun(err){
                        reject(err);
                    }
                    ));
                }
                );
            }
            val getLocation = ::genGetLocationFn;
            var packageName: String = "持续定位";
            onMounted(fun(){
                packageName = UTSAndroid.getAppContext()!!.getPackageName();
                console.log("packageName： " + packageName);
                keep.setTitle("定位APP");
                keep.setContent("定位APP正在运行");
                keep.setLargeIcon("location");
                keep.setSmallIcon("location");
                keep.setWorkerEnabled(true);
                keep.onAddBackgroundCallback(fun(res: Boolean) {
                    console.log("后台运行 " + res);
                }
                );
                keep.onAddScrrenListenerCallback(fun(res: Boolean) {
                    console.log("屏幕开启状态 " + res);
                }
                );
                val isNotification = keep.checkAppNotification(packageName);
                console.log("是否开启通知栏通知 " + isNotification);
                if (!isNotification) {
                }
                val isIgnoringBatteryOptimizations = keep.isIgnoringBatteryOptimizations();
                console.log("是否开放电池后台运行 " + isIgnoringBatteryOptimizations);
                if (!isIgnoringBatteryOptimizations) {
                    keep.requestIgnoreBatteryOptimizations();
                }
                requestBackgroundLocationPermission();
            }
            );
            val title = ref("持续定位");
            val titleClick = fun(){
                uni_showToast(ShowToastOptions(title = "点击标题"));
            }
            ;
            val coordinates = ref(utsArrayOf<Coordinate>());
            val isLocating = ref(false);
            val altitudeSelect = ref(true);
            val isHighAccuracySelect = ref(true);
            val geocodeSelect = ref(false);
            val errMsg = ref("");
            var locationInterval: Number? = null;
            val startLocationInterval = fun(): UTSPromise<Unit> {
                suspend fun async(): Unit {
                    console.log("" + formatTime(Date()) + " - \u5B9A\u65F6\u83B7\u53D6GPS");
                    try {
                        val newCoord = await(getLocation(altitudeSelect.value, isHighAccuracySelect.value, geocodeSelect.value));
                        console.log("" + newCoord.timestamp + " - \u5750\u6807\uFF1A" + JSON.stringify(newCoord.location));
                        coordinates.value.unshift(newCoord);
                        if (coordinates.value.length > 2000) {
                            coordinates.value.pop();
                        }
                    }
                     catch (err: Throwable) {
                        errMsg.value = "" + formatTime(Date()) + " - \u5F02\u5E38\u4FE1\u606F\uFF1A" + JSON.stringify(err);
                        console.error("获取位置失败：", err);
                    }
                }
                return UTSPromise(fun(resolve, reject) {
                    kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                        try {
                            val result = async();
                            resolve(result);
                        }
                         catch (e: Throwable) {
                            reject(e);
                        }
                    }
                    ;
                }
                );
            }
            ;
            val startLocation = fun(){
                locationInterval = setInterval(fun(){
                    startLocationInterval();
                }
                , 5000);
            }
            ;
            val stopLocation = fun(){
                if (locationInterval != null) {
                    clearInterval(locationInterval as Number);
                    locationInterval = null;
                }
            }
            ;
            val toggleLocation = fun(){
                if (isLocating.value) {
                    stopLocation();
                } else {
                    startLocation();
                }
                isLocating.value = !isLocating.value;
            }
            ;
            val altitudeChange = fun(e: UniSwitchChangeEvent){
                altitudeSelect.value = e.detail.value;
            }
            ;
            val highAccuracySelectChange = fun(e: UniSwitchChangeEvent){
                isHighAccuracySelect.value = e.detail.value;
            }
            ;
            val startAleraTask = fun(): UTSPromise<Unit> {
                suspend fun async(): Unit {
                    keep.hideNotification(false);
                    keep.setTitle("定位APP");
                    var content = "定位APP正在运行";
                    try {
                        val newCoord = await(getLocation(true, true, false));
                        content = "" + newCoord.timestamp + " - \u7ECF\u5EA6\uFF1A" + newCoord.location.longitude + "\uFF0C\u7EAC\u5EA6\uFF1A" + newCoord.location.latitude;
                        console.log("" + newCoord.timestamp + " - \u5750\u6807\uFF1A" + JSON.stringify(newCoord.location));
                    }
                     catch (err: Throwable) {
                        content = JSON.stringify(err);
                        console.error("获取位置失败：", err);
                    }
                    keep.setContent(content);
                    keep.updateNotification();
                }
                return UTSPromise(fun(resolve, reject) {
                    kotlinx.coroutines.CoroutineScope(io.dcloud.uts.UTSAndroid.getDomCoroutineDispatcher()).async {
                        try {
                            val result = async();
                            resolve(result);
                        }
                         catch (e: Throwable) {
                            reject(e);
                        }
                    }
                    ;
                }
                );
            }
            ;
            onAppShow(fun(_options){
                keep.unregister();
                keep.cancleAleraTask();
            }
            );
            onAppHide(fun(){
                if (isLocating.value) {
                    keep.hideNotification(false);
                    keep.register();
                    keep.startAleraTask(0, 5 * 1000, fun(){
                        startAleraTask();
                    });
                } else {
                    keep.unregister();
                    keep.cancleAleraTask();
                }
            }
            );
            onUnmounted(fun(){
                stopLocation();
            }
            );
            return fun(): Any? {
                val _component_uni_navbar_lite = resolveEasyComponent("uni-navbar-lite", GenComponentsUniNavbarLiteUniNavbarLiteClass);
                val _component_switch = resolveComponent("switch");
                return createElementVNode(Fragment, null, utsArrayOf(
                    createVNode(_component_uni_navbar_lite, utsMapOf("title" to unref(title), "onClick" to fun(){
                        titleClick();
                    }
                    ), null, 8, utsArrayOf(
                        "title",
                        "onClick"
                    )),
                    createElementVNode("view", utsMapOf("class" to "container"), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "uni-list-cell uni-list-cell-pd", "style" to normalizeStyle(utsMapOf("margin-top" to "0px"))), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "uni-list-cell-db"), "高度信息"),
                            createVNode(_component_switch, utsMapOf("checked" to unref(altitudeSelect), "onChange" to altitudeChange), null, 8, utsArrayOf(
                                "checked"
                            ))
                        ), 4),
                        createElementVNode("view", utsMapOf("class" to "uni-list-cell uni-list-cell-pd"), utsArrayOf(
                            createElementVNode("view", utsMapOf("class" to "uni-list-cell-db"), "开启高精度定位"),
                            createVNode(_component_switch, utsMapOf("checked" to unref(isHighAccuracySelect), "onChange" to highAccuracySelectChange), null, 8, utsArrayOf(
                                "checked"
                            ))
                        )),
                        createElementVNode("button", utsMapOf("onClick" to toggleLocation), toDisplayString(if (unref(isLocating)) {
                            "停止定位";
                        } else {
                            "开始定位";
                        }
                        ), 1),
                        createElementVNode("text", null, toDisplayString(unref(errMsg)), 1),
                        createElementVNode("scroll-view", utsMapOf("class" to "coordinates", "style" to normalizeStyle(utsMapOf("height" to "500px"))), utsArrayOf(
                            createElementVNode(Fragment, null, RenderHelpers.renderList(unref(coordinates), fun(coord, index, __index, _cached): Any {
                                return createElementVNode("view", utsMapOf("key" to index), utsArrayOf(
                                    createElementVNode("text", utsMapOf("class" to "text-smail"), toDisplayString(coord.timestamp) + " - 经度：" + toDisplayString(coord.location.longitude) + "，纬度：" + toDisplayString(coord.location.latitude) + "， 速度：" + toDisplayString(coord.location.speed) + "，位置的精确度：" + toDisplayString(coord.location.accuracy) + "， 高度：" + toDisplayString(coord.location.altitude) + "，垂直精度：" + toDisplayString(coord.location.verticalAccuracy) + "， 水平精度：" + toDisplayString(coord.location.horizontalAccuracy), 1),
                                    createElementVNode("text", null, "  ")
                                ));
                            }
                            ), 128)
                        ), 4)
                    ))
                ), 64);
            }
            ;
        }
        ;
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("container" to padStyleMapOf(utsMapOf("paddingTop" to 20, "paddingRight" to 20, "paddingBottom" to 20, "paddingLeft" to 20)), "title" to padStyleMapOf(utsMapOf("fontSize" to 20, "fontWeight" to "bold", "marginBottom" to 10)), "coordinates" to padStyleMapOf(utsMapOf("marginTop" to 10)), "text-smail" to padStyleMapOf(utsMapOf("fontSize" to 14)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
