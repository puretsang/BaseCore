package com.core.base.module


import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager


/**
 * SharedPreferences
 *
 *
 * init before use.
 */
class BaseSettings internal constructor() {
    companion object {

        internal var prefer: SharedPreferences? = null

        fun init(ctx: Context) {
            if (prefer == null) {
                prefer = PreferenceManager.getDefaultSharedPreferences(ctx)
            }
        }

        fun clear() {
            prefer!!.edit().commit()
        }

        fun remove(key: String){
            prefer!!.edit().remove(key)
        }

        fun getString(key: String, defValue: String): String {
            return prefer!!.getString(key, defValue)
        }

        fun getInt(key: String, defValue: Int): Int {
            return prefer!!.getInt(key, defValue)
        }

        fun getBoolean(key: String, defValue: Boolean): Boolean {
            return prefer!!.getBoolean(key, defValue)
        }

        fun getLong(key: String, defValue: Long): Long {
            return prefer!!.getLong(key, defValue)
        }

        fun getFloat(key: String, defValue: Float): Float {
            return prefer!!.getFloat(key, defValue)
        }

        fun putString(key: String, value: String) {
            prefer!!.edit().putString(key, value).commit()
        }

        fun putInt(key: String, value: Int) {
            prefer!!.edit().putInt(key, value).commit()
        }

        fun putBoolean(key: String, value: Boolean) {
            prefer!!.edit().putBoolean(key, value).commit()
        }

        fun putLong(key: String, value: Long) {
            prefer!!.edit().putLong(key, value).commit()
        }

        fun putFloat(key: String, value: Float) {
            prefer!!.edit().putFloat(key, value).commit()
        }


        operator fun contains(key: String): Boolean {
            return prefer!!.contains(key)
        }

        val all: Map<String, *>
            get() = prefer!!.all

        fun getStringSet(key: String, defValues: Set<String>): Set<String> {
            return prefer!!.getStringSet(key, defValues)
        }
    }

    //	private final static String REG = "#";
    //
    //	public static void putIntegers(String key,Integer[] value){
    //		String array = "";
    //		for (Integer groupId : value){
    //			array+=(groupId+REG);
    //		}
    //		putString(key,array);
    //	}
    //
    //	public static int[] getIntegers(String key){
    //		String values = getString(key,"");
    //		if(TextUtils.isEmpty(values))return null;
    //		String[] array = values.split(REG);
    //		int[] integers = new int[array.length];
    //		for (int i = 0; i < array.length; i++) {
    //			integers[i] = Integer.parseInt(array[i]);
    //		}
    //		return integers;
    //	}

}
