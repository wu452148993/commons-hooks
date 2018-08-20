package cc.bukkitPlugin.commons.hooks;

import java.util.List;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import cc.bukkitPlugin.commons.Log;
import cc.commons.util.reflect.ClassUtil;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.PlaceholderHook;

public class PAPIHook{

    private static boolean mPAPILoad=false;
    private static long mLastCheckTime=0;
    private static final Pattern PLACEHOLDER_PATTERN=Pattern.compile("[%]([^%]+)[%]");
    private static final Pattern BRACKET_PLACEHOLDER_PATTERN=Pattern.compile("[{]([^{}]+)[}]");

    /** PAPI是否加载 */
    public static boolean isPAPILoad(){
        if(PAPIHook.mPAPILoad)
            return true;
        return PAPIHook.tryFindPAPI();
    }

    protected static boolean tryFindPAPI(){
        synchronized(PAPIHook.class){
            if(!PAPIHook.mPAPILoad){
                // 设置检查间隔
                if(PAPIHook.mLastCheckTime>System.currentTimeMillis()){
                    PAPIHook.mLastCheckTime=System.currentTimeMillis();
                    return false;
                }else if(PAPIHook.mLastCheckTime+1000>System.currentTimeMillis()){
                    return false;
                }
                if(Bukkit.getServer().getPluginManager().getPlugin("PlaceholderAPI")!=null){
                    PAPIHook.mPAPILoad=true;
                }
            }
        }
        return PAPIHook.mPAPILoad;
    }

    /**
     * 注册PAPIHook模块,模块必须有一个无参构造函数
     * 
     * @param pPlugin
     *            插件
     * @param pHookClass
     *            PAPIHook模块类全名
     * @return 是否注册成功
     */
    public static boolean registerPlaceholderHook(Plugin pPlugin,String pHookClass){
        return PAPIHook.registerPlaceholderHook(pPlugin,pHookClass,new Class<?>[0],new Object[0]);
    }

    /**
     * 注册PAPIHook模块,模块必须有一个包含一个参数的构造函数
     * 
     * @param pPlugin
     *            插件
     * @param pHookClass
     *            PAPIHook模块类全名
     * @param pArgClazz
     *            PAPIHook模块的参数类
     * @param pArg
     *            PAPIHook模块的参数
     * @return 是否注册成功
     */
    public static boolean registerPlaceholderHook(Plugin pPlugin,String pHookClass,Class<?> pArgClazz,Object pArg){
        return PAPIHook.registerPlaceholderHook(pPlugin,pHookClass,new Class<?>[]{pArgClazz},new Object[]{pArg});
    }

    /**
     * 注册PAPIHook模块,模块必须有指定类的构造函数
     * 
     * @param pPlugin
     *            插件
     * @param pHookClass
     *            PAPIHook模块类全名
     * @param pArgClazzs
     *            PAPIHook模块的参数类
     * @param pArgs
     *            PAPIHook模块的参数
     * @return 是否注册成功
     */
    public static boolean registerPlaceholderHook(Plugin pPlugin,String pHookClass,Class<?>[] pArgClazzs,Object[] pArgs){
        try{
            if(PAPIHook.isPAPILoad()){
                Class<?> tClazz=Class.forName(pHookClass);
                if(PlaceholderHook.class.isAssignableFrom(tClazz)){
                    return PAPIHook.registerPlaceholderHook(pPlugin,(PlaceholderHook)ClassUtil.newInstance(tClazz,pArgClazzs,pArgs));
                }
            }
        }catch(Throwable exp){
            Log.severe("注册PAPI模块时发生了错误",exp);
        }
        return false;
    }

    public static boolean registerPlaceholderHook(Plugin pPlugin,PlaceholderHook pHook){
        return PAPIHook.isPAPILoad()&&PlaceholderAPI.registerPlaceholderHook(pPlugin,pHook);
    }

    public static boolean registerPlaceholderHook(String pPlugin,PlaceholderHook pHook){
        return PAPIHook.isPAPILoad()&&PlaceholderAPI.registerPlaceholderHook(pPlugin,pHook);
    }

    public static boolean unregisterPlaceholderHook(Plugin pPlugin){
        return PAPIHook.isPAPILoad()&&PlaceholderAPI.unregisterPlaceholderHook(pPlugin);
    }

    public static boolean unregisterPlaceholderHook(String pPlugin){
        return PAPIHook.isPAPILoad()&&PlaceholderAPI.unregisterPlaceholderHook(pPlugin);
    }

    public static boolean containsPlaceholders(String pText){
        return pText!=null&&PLACEHOLDER_PATTERN.matcher(pText).find();
    }

    public static boolean containsBracketPlaceholders(String pText){
        return pText!=null&&BRACKET_PLACEHOLDER_PATTERN.matcher(pText).find();
    }

    public static List<String> setBracketPlaceholders(Player pPlayer,List<String> pTexts){
        return PAPIHook.isPAPILoad()?PlaceholderAPI.setBracketPlaceholders(pPlayer,pTexts):pTexts;
    }

    public static String setBracketPlaceholders(Player pPlayer,String pText){
        if(PAPIHook.isPAPILoad()){
            try{
                return PlaceholderAPI.setBracketPlaceholders(pPlayer,pText);
            }catch(Throwable exp){
                Log.severe(Bukkit.getConsoleSender(),"在调用PlaceholderAPI插件时发生了错误,请确保所用的PlaceholderAPI模块与你的插件版本对应: "+exp.getMessage(),exp);
            }
        }
        return pText;
    }

    public static List<String> setPlaceholders(Player pPlayer,List<String> pTexts){
        return PAPIHook.isPAPILoad()?PlaceholderAPI.setPlaceholders(pPlayer,pTexts):pTexts;
    }

    public static String setPlaceholders(Player pPlayer,String pText){
        return PAPIHook.isPAPILoad()?PlaceholderAPI.setPlaceholders(pPlayer,pText):pText;
    }

    public static Pattern getPlaceholderPattern(){
        return PLACEHOLDER_PATTERN;
    }

    public static Pattern getBracketPlaceholderPattern(){
        return BRACKET_PLACEHOLDER_PATTERN;
    }

}
