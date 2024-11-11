@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uts.sdk.modules.androidKeeplive;
import com.gyf.cactus.CactusHelp;
import com.gyf.cactus.KeepLiveUtils;
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
open class KeepLive : CactusHelp.OnAppBackgroudCallback {
    open var helper: CactusHelp;
    open var onBackgroundListener: OnBackgroundListener? = null;
    open var onNotificationClickListener: OnNotificationClickListener? = null;
    open var onScreenListener: OnScreenListener? = null;
    open var onAleraListener: OnAleraListener? = null;
    constructor(){
        helper = CactusHelp(UTSAndroid.getAppContext()!!);
        helper.setOnAppBackgroudCallback(this);
        this.setNotifationAcIntent();
        this.setBackgroundMusicEnabled(true);
    }
    public open fun isIgnoringBatteryOptimizations(): Boolean {
        return KeepLiveUtils.isIgnoringBatteryOptimizations(UTSAndroid.getAppContext()!!);
    }
    public open fun requestIgnoreBatteryOptimizations(): Unit {
        KeepLiveUtils.requestIgnoreBatteryOptimizations(UTSAndroid.getAppContext()!!);
    }
    public open fun goKeepLiveSetting(): Unit {
        KeepLiveUtils.goKeepLiveSetting(UTSAndroid.getAppContext());
    }
    public open fun doStartApplicationWithPackageName(packagename: String): Unit {
        helper.doStartApplicationWithPackageName(UTSAndroid.getAppContext(), packagename);
    }
    public open fun restartThisApp() {
        this.doStartApplicationWithPackageName(UTSAndroid.getAppContext()!!.getPackageName());
    }
    public open fun setNotifationAcIntent() {
        helper.setPendingIntent(UTSAndroid.getUniActivity()!!);
    }
    public open fun setNotifationBrodcastIntent() {
        helper.setNotificationClick();
    }
    public open fun checkAppNotification(id: String): Boolean {
        return helper.checkAppNotification(UTSAndroid.getAppContext()!!, id);
    }
    public open fun goNotificationSetting(): Unit {
        return helper.goNotificationSetting(UTSAndroid.getAppContext()!!);
    }
    public open fun setMusicEnabled(en: Boolean): Unit {
        helper.setMusicEnabled(en);
    }
    public open fun setTitle(title: String): Unit {
        helper.setTitle(title);
    }
    public open fun setContent(content: String): Unit {
        helper.setContent(content);
    }
    public open fun setWorkerEnabled(on: Boolean): Unit {
        helper.setWorkerEnabled(on);
    }
    public open fun setSmallIcon(icon: String): Unit {
        var id = UTSAndroid.getAppContext()!!.getResources().getIdentifier(icon, "drawable", UTSAndroid.getAppContext()!!.getPackageName());
        if (id > 0) {
            helper.setSmallIcon(id);
        }
    }
    public open fun setLargeIcon(icon: String): Unit {
        var id = UTSAndroid.getAppContext()!!.getResources().getIdentifier(icon, "drawable", UTSAndroid.getAppContext()!!.getPackageName());
        if (id > 0) {
            helper.setLargeIcon(id);
        }
    }
    public open fun setMusicId(musicId: String): Unit {
        var id = UTSAndroid.getAppContext()!!.getResources().getIdentifier(musicId, "raw", UTSAndroid.getAppContext()!!.getPackageName());
        if (id > 0) {
            helper.setMusicId(id);
        }
    }
    public open fun setDebug(d: Boolean): Unit {
        helper.setDebug(d);
    }
    public open fun setBackgroundMusicEnabled(on: Boolean): Unit {
        helper.setBackgroundMusicEnabled(on);
    }
    public open fun setMusicInterval(t: Number): Unit {
        helper.setMusicInterval(t.toInt());
    }
    public open fun setWorkOnMainThread(t: Boolean): Unit {
        helper.setWorkOnMainThread(t);
    }
    public open fun register(): Unit {
        helper.register(UTSAndroid.getAppContext()!!);
    }
    public open fun unregister(): Unit {
        helper.unregister(UTSAndroid.getAppContext()!!);
    }
    public open fun isRunning(): Boolean {
        return helper.isRunning(UTSAndroid.getAppContext()!!);
    }
    public open fun restart(): Unit {
        helper.restart(UTSAndroid.getAppContext()!!);
    }
    public open fun setChannelName(title: String): Unit {
        helper.setChannelName(title);
    }
    public open fun setChannelId(id: String) {
        helper.setChannelId(id);
    }
    public open fun updateNotification(): Unit {
        helper.updateNotification(UTSAndroid.getAppContext()!!);
    }
    public open fun hideNotification(hide: Boolean): Unit {
        helper.hideNotification(hide);
    }
    override fun onBackground(on1: Boolean): Unit {
        if (this.onBackgroundListener != null) {
            this.onBackgroundListener!!.onBack(on1);
        }
    }
    override fun onNotificationClick(): Unit {
        console.log("onNotificationClick");
        if (this.onNotificationClickListener != null) {
            this.onNotificationClickListener!!.onClick();
        }
    }
    override fun onScrrenListener(on: Boolean) {
        if (this.onScreenListener != null) {
            this.onScreenListener!!.screenState(on);
        }
    }
    override fun onAleraTaskExec() {
        if (this.onAleraListener != null) {
            this.onAleraListener!!.onAlera();
        }
    }
    public open fun onAddNotificationClickListener(callback: () -> Unit): Unit {
        open class MyOnNotificationClickListener : OnNotificationClickListener {
            override fun onClick(): Unit {
                callback();
            }
        }
        this.onNotificationClickListener = MyOnNotificationClickListener();
    }
    public open fun startAleraTask(startTime: Number, intervalTime: Number, callback: () -> Unit): Unit {
        open class MyOnAleraListener : OnAleraListener {
            override fun onAlera(): Unit {
                callback();
            }
        }
        this.onAleraListener = MyOnAleraListener();
        helper.startExeckTask(startTime.toLong(), intervalTime.toLong());
    }
    public open fun cancleAleraTask(): Unit {
        helper.cancleTask();
    }
    public open fun onAddBackgroundCallback(callback: (sth: Boolean) -> Unit): Unit {
        open class MyOnBackgroundListener : OnBackgroundListener {
            override fun onBack(on: Boolean): Unit {
                callback(on);
            }
        }
        this.onBackgroundListener = MyOnBackgroundListener();
    }
    public open fun onAddScrrenListenerCallback(callback: (sth: Boolean) -> Unit): Unit {
        open class MyOnScreenListener : OnScreenListener {
            override fun screenState(on: Boolean): Unit {
                callback(on);
            }
        }
        this.onScreenListener = MyOnScreenListener();
    }
}
interface OnBackgroundListener {
    fun onBack(on: Boolean)
}
interface OnNotificationClickListener {
    fun onClick()
}
interface OnScreenListener {
    fun screenState(on: Boolean)
}
interface OnAleraListener {
    fun onAlera()
}
