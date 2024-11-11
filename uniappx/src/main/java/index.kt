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
import io.dcloud.uniapp.extapi.exit as uni_exit;
import io.dcloud.uniapp.extapi.getPrivacySetting as uni_getPrivacySetting;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class TestConsole {
    constructor(){
        console.log("test main.uts console.log");
    }
}
val ts = TestConsole();
open class SafeArea (
    @JsonNotNull
    open var top: Number,
    @JsonNotNull
    open var right: Number,
    @JsonNotNull
    open var bottom: Number,
    @JsonNotNull
    open var left: Number,
    @JsonNotNull
    open var width: Number,
    @JsonNotNull
    open var height: Number,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return SafeAreaReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class SafeAreaReactiveObject : SafeArea, IUTSReactive<SafeArea> {
    override var __v_raw: SafeArea;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: SafeArea, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(top = __v_raw.top, right = __v_raw.right, bottom = __v_raw.bottom, left = __v_raw.left, width = __v_raw.width, height = __v_raw.height) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): SafeAreaReactiveObject {
        return SafeAreaReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var top: Number
        get() {
            return trackReactiveGet(__v_raw, "top", __v_raw.top, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("top")) {
                return;
            }
            val oldValue = __v_raw.top;
            __v_raw.top = value;
            triggerReactiveSet(__v_raw, "top", oldValue, value);
        }
    override var right: Number
        get() {
            return trackReactiveGet(__v_raw, "right", __v_raw.right, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("right")) {
                return;
            }
            val oldValue = __v_raw.right;
            __v_raw.right = value;
            triggerReactiveSet(__v_raw, "right", oldValue, value);
        }
    override var bottom: Number
        get() {
            return trackReactiveGet(__v_raw, "bottom", __v_raw.bottom, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("bottom")) {
                return;
            }
            val oldValue = __v_raw.bottom;
            __v_raw.bottom = value;
            triggerReactiveSet(__v_raw, "bottom", oldValue, value);
        }
    override var left: Number
        get() {
            return trackReactiveGet(__v_raw, "left", __v_raw.left, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("left")) {
                return;
            }
            val oldValue = __v_raw.left;
            __v_raw.left = value;
            triggerReactiveSet(__v_raw, "left", oldValue, value);
        }
    override var width: Number
        get() {
            return trackReactiveGet(__v_raw, "width", __v_raw.width, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("width")) {
                return;
            }
            val oldValue = __v_raw.width;
            __v_raw.width = value;
            triggerReactiveSet(__v_raw, "width", oldValue, value);
        }
    override var height: Number
        get() {
            return trackReactiveGet(__v_raw, "height", __v_raw.height, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("height")) {
                return;
            }
            val oldValue = __v_raw.height;
            __v_raw.height = value;
            triggerReactiveSet(__v_raw, "height", oldValue, value);
        }
}
open class State (
    @JsonNotNull
    open var lifeCycleNum: Number,
    @JsonNotNull
    open var statusBarHeight: Number,
    @JsonNotNull
    open var safeArea: SafeArea,
    @JsonNotNull
    open var devicePixelRatio: Number,
    @JsonNotNull
    open var eventCallbackNum: Number,
    @JsonNotNull
    open var noMatchLeftWindow: Boolean = false,
    @JsonNotNull
    open var active: String,
    @JsonNotNull
    open var leftWinActive: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return StateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class StateReactiveObject : State, IUTSReactive<State> {
    override var __v_raw: State;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: State, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(lifeCycleNum = __v_raw.lifeCycleNum, statusBarHeight = __v_raw.statusBarHeight, safeArea = __v_raw.safeArea, devicePixelRatio = __v_raw.devicePixelRatio, eventCallbackNum = __v_raw.eventCallbackNum, noMatchLeftWindow = __v_raw.noMatchLeftWindow, active = __v_raw.active, leftWinActive = __v_raw.leftWinActive) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): StateReactiveObject {
        return StateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var lifeCycleNum: Number
        get() {
            return trackReactiveGet(__v_raw, "lifeCycleNum", __v_raw.lifeCycleNum, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("lifeCycleNum")) {
                return;
            }
            val oldValue = __v_raw.lifeCycleNum;
            __v_raw.lifeCycleNum = value;
            triggerReactiveSet(__v_raw, "lifeCycleNum", oldValue, value);
        }
    override var statusBarHeight: Number
        get() {
            return trackReactiveGet(__v_raw, "statusBarHeight", __v_raw.statusBarHeight, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("statusBarHeight")) {
                return;
            }
            val oldValue = __v_raw.statusBarHeight;
            __v_raw.statusBarHeight = value;
            triggerReactiveSet(__v_raw, "statusBarHeight", oldValue, value);
        }
    override var safeArea: SafeArea
        get() {
            return trackReactiveGet(__v_raw, "safeArea", __v_raw.safeArea, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("safeArea")) {
                return;
            }
            val oldValue = __v_raw.safeArea;
            __v_raw.safeArea = value;
            triggerReactiveSet(__v_raw, "safeArea", oldValue, value);
        }
    override var devicePixelRatio: Number
        get() {
            return trackReactiveGet(__v_raw, "devicePixelRatio", __v_raw.devicePixelRatio, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("devicePixelRatio")) {
                return;
            }
            val oldValue = __v_raw.devicePixelRatio;
            __v_raw.devicePixelRatio = value;
            triggerReactiveSet(__v_raw, "devicePixelRatio", oldValue, value);
        }
    override var eventCallbackNum: Number
        get() {
            return trackReactiveGet(__v_raw, "eventCallbackNum", __v_raw.eventCallbackNum, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("eventCallbackNum")) {
                return;
            }
            val oldValue = __v_raw.eventCallbackNum;
            __v_raw.eventCallbackNum = value;
            triggerReactiveSet(__v_raw, "eventCallbackNum", oldValue, value);
        }
    override var noMatchLeftWindow: Boolean
        get() {
            return trackReactiveGet(__v_raw, "noMatchLeftWindow", __v_raw.noMatchLeftWindow, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("noMatchLeftWindow")) {
                return;
            }
            val oldValue = __v_raw.noMatchLeftWindow;
            __v_raw.noMatchLeftWindow = value;
            triggerReactiveSet(__v_raw, "noMatchLeftWindow", oldValue, value);
        }
    override var active: String
        get() {
            return trackReactiveGet(__v_raw, "active", __v_raw.active, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("active")) {
                return;
            }
            val oldValue = __v_raw.active;
            __v_raw.active = value;
            triggerReactiveSet(__v_raw, "active", oldValue, value);
        }
    override var leftWinActive: String
        get() {
            return trackReactiveGet(__v_raw, "leftWinActive", __v_raw.leftWinActive, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("leftWinActive")) {
                return;
            }
            val oldValue = __v_raw.leftWinActive;
            __v_raw.leftWinActive = value;
            triggerReactiveSet(__v_raw, "leftWinActive", oldValue, value);
        }
}
val state = reactive(State(lifeCycleNum = 0, statusBarHeight = 0, devicePixelRatio = 1, eventCallbackNum = 0, noMatchLeftWindow = true, active = "componentPage", leftWinActive = "/pages/component/view/view", safeArea = SafeArea(top = 0, right = 0, bottom = 0, left = 0, width = 0, height = 0)));
val setLifeCycleNum = fun(num: Number){
    state.lifeCycleNum = num;
}
;
var firstBackTime: Number = 0;
open class GenGlobalData {
    open var str = "default globalData str";
    open var num: Number = 0;
    open var bool = false;
    open var obj = object : UTSJSONObject() {
        var str = "default globalData obj str"
        var num: Number = 0
        var bool = false
    };
    open var `null` = null as String?;
    open var arr = utsArrayOf<Number>();
    open var mySet = Set<String>();
    open var myMap = Map<String, Any>();
    open var func = fun(): String {
        return "globalData func";
    }
    ;
    open var launchOptions = OnLaunchOptions(path = "");
    open var onShowOption = OnShowOptions(path = "");
}
open class GenApp : BaseApp {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLaunch(fun(res: OnLaunchOptions) {
            this.globalData.launchOptions = res;
            setLifeCycleNum(state.lifeCycleNum + 1000);
            console.log("App Launch");
            if ("production" !== "development") {
                uni_getPrivacySetting(GetPrivacySettingOptions(success = fun(res1) {
                    if (res1.needAuthorization) {
                    }
                }
                ));
            }
        }
        , __ins);
        onAppShow(fun(res: OnShowOptions) {
            this.globalData.onShowOption = res;
            var url = this.getRedirectUrl(res.appScheme, res.appLink);
            if (null != url) {
                uni_navigateTo(NavigateToOptions(url = url));
            }
            setLifeCycleNum(state.lifeCycleNum + 100);
            console.log("App Show");
        }
        , __ins);
        onHide(fun() {
            setLifeCycleNum(state.lifeCycleNum - 100);
            console.log("App Hide");
        }
        , __ins);
        onLastPageBackPress(fun() {
            setLifeCycleNum(state.lifeCycleNum - 1000);
            console.log("App LastPageBackPress");
            if (firstBackTime == 0) {
                uni_showToast(ShowToastOptions(title = "再按一次退出应用", position = "bottom"));
                firstBackTime = Date.now();
                setTimeout(fun(){
                    firstBackTime = 0;
                }, 2000);
            } else if (Date.now() - firstBackTime < 2000) {
                firstBackTime = Date.now();
                uni_exit(null);
            }
        }
        , __ins);
        onExit(fun() {
            console.log("App Exit");
        }
        , __ins);
        onError(fun(err: Any) {
            console.log("App onError", err);
        }
        , __ins);
    }
    open val globalData: GenGlobalData
        get() {
            return getApp().globalData;
        }
    override fun `$initMethods`() {
        this.increasetLifeCycleNum = fun() {
            setLifeCycleNum(state.lifeCycleNum + 100);
            console.log("App increasetLifeCycleNum");
        }
        ;
        this.getRedirectUrl = fun(scheme: String?, ulink: String?): String? {
            var url: String? = null;
            if (null != scheme && scheme.length > 0) {
                val PATHPRE = "redirect";
                var parts: String? = null;
                var pos = scheme.search("//");
                if (pos > 0) {
                    parts = scheme.substring(pos + 2);
                }
                if (null != parts && parts.startsWith(PATHPRE)) {
                    url = parts.substring(PATHPRE.length);
                }
            } else if (null != ulink && ulink.length > 0) {
                val PATH = "ulink/redirect.html";
                var parts = ulink.split("?");
                if (parts.length > 1 && parts[0].endsWith(PATH) && parts[1].length > 0) {
                    parts[1].split("&").forEach(fun(e){
                        var params = e.split("=");
                        if (params.length > 1 && params[0].length > 0 && params[1].length > 0) {
                            if ("url" == params[0]) {
                                if (null == url) {
                                    url = decodeURIComponent(params[1]);
                                }
                            }
                        }
                    }
                    );
                }
            }
            return url;
        }
        ;
    }
    open lateinit var increasetLifeCycleNum: () -> Unit;
    open lateinit var getRedirectUrl: (scheme: String?, ulink: String?) -> String?;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("uni-padding-wrap" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 15)), "uni-title" to padStyleMapOf(utsMapOf("paddingTop" to 10, "paddingRight" to 0, "paddingBottom" to 10, "paddingLeft" to 0)), "uni-title-text" to padStyleMapOf(utsMapOf("fontSize" to 15, "fontWeight" to "bold")), "uni-subtitle-text" to padStyleMapOf(utsMapOf("color" to "#888888", "fontSize" to 12, "fontWeight" to "bold", "marginTop" to 5)), "uni-common-mb" to padStyleMapOf(utsMapOf("marginBottom" to 15)), "uni-common-pb" to padStyleMapOf(utsMapOf("paddingBottom" to 15)), "uni-common-pl" to padStyleMapOf(utsMapOf("paddingLeft" to 15)), "uni-common-mt" to padStyleMapOf(utsMapOf("marginTop" to 15)), "uni-hello-text" to padStyleMapOf(utsMapOf("color" to "#7A7E83", "lineHeight" to "22px")), "uni-list" to padStyleMapOf(utsMapOf("backgroundColor" to "#FFFFFF", "position" to "relative", "display" to "flex", "flexDirection" to "column", "borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#c8c7cc")), "uni-list-cell" to padStyleMapOf(utsMapOf("position" to "relative", "display" to "flex", "flexDirection" to "row", "justifyContent" to "space-between", "alignItems" to "center")), "uni-list-cell-padding" to padStyleMapOf(utsMapOf("paddingTop" to 16, "paddingRight" to 16, "paddingBottom" to 16, "paddingLeft" to 16)), "uni-list-cell-line" to padStyleMapOf(utsMapOf("borderBottomWidth" to 1, "borderBottomStyle" to "solid", "borderBottomColor" to "#c8c7cc")), "uni-list-cell-hover" to padStyleMapOf(utsMapOf("backgroundColor" to "#eeeeee")), "uni-list-cell-pd" to padStyleMapOf(utsMapOf("paddingTop" to 11, "paddingRight" to 15, "paddingBottom" to 11, "paddingLeft" to 0)), "uni-list-cell-left" to padStyleMapOf(utsMapOf("paddingTop" to 0, "paddingRight" to 15, "paddingBottom" to 0, "paddingLeft" to 10)), "uni-list-cell-db" to padStyleMapOf(utsMapOf("flex" to 1)), "uni-list-cell-right" to padStyleMapOf(utsMapOf("flex" to 1)), "uni-label" to padStyleMapOf(utsMapOf("width" to 105)), "uni-input" to padStyleMapOf(utsMapOf("height" to 25, "paddingTop" to 8, "paddingRight" to 13, "paddingBottom" to 8, "paddingLeft" to 13, "fontSize" to 14, "backgroundImage" to "none", "backgroundColor" to "#FFFFFF", "flex" to 1, "boxSizing" to "content-box")), "uni-flex" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-flex-item" to padStyleMapOf(utsMapOf("flex" to 1)), "uni-row" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "uni-column" to padStyleMapOf(utsMapOf("flexDirection" to "column")), "uni-bg-red" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "#F76260")), "uni-bg-green" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "#09BB07")), "uni-bg-blue" to padStyleMapOf(utsMapOf("backgroundImage" to "none", "backgroundColor" to "#007AFF")), "uni-btn-v" to padStyleMapOf(utsMapOf("paddingTop" to 5, "paddingRight" to 0, "paddingBottom" to 5, "paddingLeft" to 0)), "uni-btn" to padStyleMapOf(utsMapOf("marginTop" to 10)), "uni-link" to padStyleMapOf(utsMapOf("color" to "#576B95", "fontSize" to 13)), "uni-center" to padStyleMapOf(utsMapOf("flexDirection" to "row", "justifyContent" to "center")), "uni-textarea" to padStyleMapOf(utsMapOf("paddingTop" to 9, "paddingRight" to 9, "paddingBottom" to 9, "paddingLeft" to 9, "lineHeight" to 1.6, "fontSize" to 14)), "uni-icon-size" to padStyleMapOf(utsMapOf("width" to 14, "height" to 14)), "uni-container" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "backgroundColor" to "#f8f8f8")), "uni-header-logo" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "flexDirection" to "column", "justifyContent" to "center", "alignItems" to "center", "marginTop" to 5)), "uni-header-image" to padStyleMapOf(utsMapOf("width" to 80, "height" to 80)), "uni-text-box" to padStyleMapOf(utsMapOf("marginBottom" to 20)), "hello-text" to padStyleMapOf(utsMapOf("color" to "#7A7E83", "fontSize" to 14, "lineHeight" to "20px")), "uni-panel" to padStyleMapOf(utsMapOf("marginBottom" to 12)), "text-disabled" to padStyleMapOf(utsMapOf("!color" to "#a0a0a0")), "uni-panel-h" to padStyleMapOf(utsMapOf("backgroundColor" to "#ffffff", "!flexDirection" to "row", "!justifyContent" to "space-between", "!alignItems" to "center", "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12)), "uni-panel-h-on" to padStyleMapOf(utsMapOf("backgroundColor" to "#f0f0f0")), "uni-panel-text" to padStyleMapOf(utsMapOf("color" to "#000000", "fontSize" to 14, "fontWeight" to "normal")), "uni-navigate-item" to padStyleMapOf(utsMapOf("flexDirection" to "row", "alignItems" to "center", "backgroundColor" to "#FFFFFF", "borderTopStyle" to "solid", "borderTopColor" to "#f0f0f0", "borderTopWidth" to 1, "paddingTop" to 12, "paddingRight" to 12, "paddingBottom" to 12, "paddingLeft" to 12, "justifyContent" to "space-between", "backgroundColor:active" to "#f8f8f8")), "is--active" to padStyleMapOf(utsMapOf("backgroundColor" to "#f8f8f8")), "uni-navigate-text" to padStyleMapOf(utsMapOf("color" to "#000000", "fontSize" to 14, "fontWeight" to "normal")), "left-win-active" to padStyleMapOf(utsMapOf("!color" to "#007AFF")), "page-scroll-view" to padStyleMapOf(utsMapOf("flex" to 1)));
            }
    }
}
val GenAppClass = CreateVueAppComponent(GenApp::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "app", name = "", inheritAttrs = true, inject = Map(), props = Map(), propsNeedCastKeys = utsArrayOf(), emits = Map(), components = Map(), styles = GenApp.styles);
}
, fun(instance): GenApp {
    return GenApp(instance);
}
);
val `default` = "/assets/uniicons.ab33ac77.ttf";
val GenComponentsUniNavbarLiteUniNavbarLiteClass = CreateVueComponent(GenComponentsUniNavbarLiteUniNavbarLite::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "component", name = GenComponentsUniNavbarLiteUniNavbarLite.name, inheritAttrs = GenComponentsUniNavbarLiteUniNavbarLite.inheritAttrs, inject = GenComponentsUniNavbarLiteUniNavbarLite.inject, props = GenComponentsUniNavbarLiteUniNavbarLite.props, propsNeedCastKeys = GenComponentsUniNavbarLiteUniNavbarLite.propsNeedCastKeys, emits = GenComponentsUniNavbarLiteUniNavbarLite.emits, components = GenComponentsUniNavbarLiteUniNavbarLite.components, styles = GenComponentsUniNavbarLiteUniNavbarLite.styles);
}
, fun(instance): GenComponentsUniNavbarLiteUniNavbarLite {
    return GenComponentsUniNavbarLiteUniNavbarLite(instance);
}
);
open class Coordinate (
    @JsonNotNull
    open var location: GetLocationSuccess,
    @JsonNotNull
    open var timestamp: String,
) : UTSReactiveObject() {
    override fun __v_create(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): UTSReactiveObject {
        return CoordinateReactiveObject(this, __v_isReadonly, __v_isShallow, __v_skip)
    }
}
open class CoordinateReactiveObject : Coordinate, IUTSReactive<Coordinate> {
    override var __v_raw: Coordinate;
    override var __v_isReadonly: Boolean;
    override var __v_isShallow: Boolean;
    override var __v_skip: Boolean;
    constructor(__v_raw: Coordinate, __v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean) : super(location = __v_raw.location, timestamp = __v_raw.timestamp) {
        this.__v_raw = __v_raw;
        this.__v_isReadonly = __v_isReadonly;
        this.__v_isShallow = __v_isShallow;
        this.__v_skip = __v_skip;
    }
    override fun __v_clone(__v_isReadonly: Boolean, __v_isShallow: Boolean, __v_skip: Boolean): CoordinateReactiveObject {
        return CoordinateReactiveObject(this.__v_raw, __v_isReadonly, __v_isShallow, __v_skip);
    }
    override var location: GetLocationSuccess
        get() {
            return trackReactiveGet(__v_raw, "location", __v_raw.location, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("location")) {
                return;
            }
            val oldValue = __v_raw.location;
            __v_raw.location = value;
            triggerReactiveSet(__v_raw, "location", oldValue, value);
        }
    override var timestamp: String
        get() {
            return trackReactiveGet(__v_raw, "timestamp", __v_raw.timestamp, this.__v_isReadonly, this.__v_isShallow);
        }
        set(value) {
            if (!this.__v_canSet("timestamp")) {
                return;
            }
            val oldValue = __v_raw.timestamp;
            __v_raw.timestamp = value;
            triggerReactiveSet(__v_raw, "timestamp", oldValue, value);
        }
}
val GenPagesIndexIndexClass = CreateVueComponent(GenPagesIndexIndex::class.java, fun(): VueComponentOptions {
    return VueComponentOptions(type = "page", name = "", inheritAttrs = GenPagesIndexIndex.inheritAttrs, inject = GenPagesIndexIndex.inject, props = GenPagesIndexIndex.props, propsNeedCastKeys = GenPagesIndexIndex.propsNeedCastKeys, emits = GenPagesIndexIndex.emits, components = GenPagesIndexIndex.components, styles = GenPagesIndexIndex.styles, setup = fun(props: ComponentPublicInstance): Any? {
        return GenPagesIndexIndex.setup(props as GenPagesIndexIndex);
    }
    );
}
, fun(instance): GenPagesIndexIndex {
    return GenPagesIndexIndex(instance);
}
);
fun createApp(): UTSJSONObject {
    val app = createSSRApp(GenAppClass);
    return UTSJSONObject(Map<String, Any?>(utsArrayOf(
        utsArrayOf(
            "app",
            app
        )
    )));
}
fun main(app: IApp) {
    definePageRoutes();
    defineAppConfig();
    (createApp()["app"] as VueApp).mount(app, GenUniApp());
}
open class UniAppConfig : io.dcloud.uniapp.appframe.AppConfig {
    override var name: String = "持续定位";
    override var appid: String = "__UNI__509F621";
    override var versionName: String = "1.6.5";
    override var versionCode: String = "10605";
    override var uniCompilerVersion: String = "4.32";
    constructor() : super() {}
}
fun definePageRoutes() {
    __uniRoutes.push(UniPageRoute(path = "pages/index/index", component = GenPagesIndexIndexClass, meta = UniPageMeta(isQuit = true), style = utsMapOf("navigationStyle" to "custom")));
}
val __uniTabBar: Map<String, Any?>? = utsMapOf();
val __uniLaunchPage: Map<String, Any?> = utsMapOf("url" to "pages/index/index", "style" to utsMapOf("navigationStyle" to "custom"));
fun defineAppConfig() {
    __uniConfig.entryPagePath = "/pages/index/index";
    __uniConfig.globalStyle = utsMapOf("navigationBarTextStyle" to "black", "navigationBarTitleText" to "持续定位", "navigationBarBackgroundColor" to "#F8F8F8", "backgroundColor" to "#F8F8F8");
    __uniConfig.tabBar = __uniTabBar as Map<String, Any>?;
    __uniConfig.conditionUrl = "";
    __uniConfig.uniIdRouter = Map();
    __uniConfig.themeConfig = utsMapOf("light" to utsMapOf(), "dark" to utsMapOf());
    __uniConfig.ready = true;
}
open class GenUniApp : UniAppImpl() {
    open val vm: GenApp?
        get() {
            return getAppVm() as GenApp?;
        }
    open val `$vm`: GenApp?
        get() {
            return getAppVm() as GenApp?;
        }
    open var globalData = GenGlobalData();
}
fun getApp(): GenUniApp {
    return getUniApp() as GenUniApp;
}
