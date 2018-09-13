package base.xiyun.com.myandfix;

import android.app.Application;
import android.content.pm.PackageManager;

import com.alipay.euler.andfix.patch.PatchManager;

/**
 * Created by WangPeng on 2018/9/12.
 */
public class MyApplication extends Application {
    private static PatchManager patchManager;
    @Override
    public void onCreate() {
        super.onCreate();
        String appversion= null;
        try {
            appversion = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        //注意每次appversion变更都会导致所有补丁被删除,如果appversion没有改变，则会加载已经保存的所有补丁。
         patchManager = new PatchManager(this);
        patchManager.init(appversion);//current version
        patchManager.loadPatch();
    }

    public static PatchManager getPatchManager() {
        return patchManager;
    }
}
